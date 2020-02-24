package http;

import com.sun.net.httpserver.Headers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Request {
    //请求方法：get 或者post
    private String method;
    //请求地址：对应服务器端的服务路径
    private String url;
    //http版本
    private String version;
    //请求头
    private Map<String,String> headers = new HashMap<>();
    //请求参数
    private Map<String,String> parameters = new HashMap<>();

    /**
     * 类似单例的写法，提供私有构造方法
     */
    private Request(){

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }


    /**
     * 通过客户端发送的http请求数据,转换为request请求类；
     * 包装请求方法，url

     * @param inputStream
     * @return
     */
    public static Request buildRequest(InputStream inputStream) throws IOException {
        Request request = new Request();

        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(inputStream,"utf-8"));
            String requestLine = input.readLine();
            request.parseRequestLine(requestLine);
            String header;
            while ((header = input.readLine())!= null && header.length() != 0) {
                String[] parts = header.split(":");
                request.headers.put(parts[0].trim(),parts[1].trim());
                System.out.printf("请求头：%s=%s\n",parts[0].trim(),parts[1].trim());

            }
            System.out.println();
            //如果是post 方法提交，并且有content-Length,表示请求数据中包含请求体
            //需要处理请求体
            if("POST".equalsIgnoreCase(request.method)
                    && request.headers.containsKey("content-Length")){
                int len = Integer.parseInt(request.headers.get("contemnt-length"));
                char[] chars = new char[len];
                input.read(chars,0,len);
                request.parseParameters(new String(chars));

            }
            System.out.print("请求参数：");
            for(Map.Entry<String,String> entry : request.parameters.entrySet()){
                System.out.printf("%s=%s," ,entry.getKey(),entry.getValue());
            }
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("处理请求数据错误",e);
        }
        return request;
    }

    public void parseRequestLine(String requestLine){
        String[] parts = requestLine.split(" ");
        method = parts[0];
        url = parts[1];
        //如果url 包含“？”，表示有请求参数，需要处理
        int index = url.indexOf("?");
        if(index != -1){
            //包含请求参数时，？前的是url,之后的是请求参数

            parseParameters(url.substring(index+1));
            url = url.substring(0,index);
        }

        version = parts[2];
        System.out.printf("请求方法:%s,url:%s,版本号:%s\n",method,url,version);
    }

    /**
     * 解析请求参数；
     * 格式为k1=v1&k2=v2&.....
     * @param parameters
     */
    private void parseParameters(String parameters){
        String[] parts = parameters.split("&");
        if(parts != null && parts.length != 0){
            //parts 对应 k1=v1
            for(String part : parts){
                String [] paras = part.split("=");
                this.parameters.put(paras[0],paras[1]);
            }
        }
    }

}
