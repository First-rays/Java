package http;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * http响应数据；
 * 1.构建response对象，将输出流设置到给对象属性
 * 2.把这个对象相关数据设置进去，设置响应头，响应行，响应体
 * 3.调用刷新，输出流打印数据返回客户端
 */
public class Response {

    private PrintWriter writer;
    //版本号
    private String version = "HTTP/1.1";
    //状态码
    private int status;
    //响应码描述
    private String message;
    //响应头
    private Map<String, String> headers = new HashMap<>();
    //响应体
    private StringBuilder body = new StringBuilder();
    public Response(){

    }

    public void println(String line){
        body.append(line+"\n");
    }

    //打印并刷新输出流响应数据，返回给客户端

    public void flush(){
        //打印相应行
        writer.println(version+" "+status+" "+message);
        System.out.println();
        //打印响应头
        //设置响应格式 Content-Type(浏览器获取响应数据后，用什么类型处理数据)
        writer.println("Content-Type: text/html;charset=utf-8");
        System.out.println();
        if(body.length() != 0){
            writer.println("Content-Length:"+body.toString().getBytes().length);
            System.out.println();
        }


        for(Map.Entry<String,String> entry : headers.entrySet()){
            writer.println(entry.getKey()+": "+entry.getValue());
        }
        //打印空行
        writer.println();
        //打印响应体
        if(body.length()!= 0){
            writer.println(body);
        }
        //刷新一下输出流：1.初始化printWriter,第二个参数为：true,设置自动刷新
        //2. printWriter.flush();
        writer.flush();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBody(StringBuilder body) {
        this.body = body;
    }

    public void addHeader(String key, String value){
        headers.put(key,value);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static Response buildResponse(OutputStream outputStream){
        Response response = new Response();
        response.writer = new PrintWriter(outputStream);

        return response;
    }

    public void build200(){
        status = 200;
        message = "ok";
    }
    public void build404(){
        status = 404;
        message = "Not found";
    }

    public void build307(){
        status = 307;
        message = "sent redirect";
    }
    public void build405(){
        status = 405;
        message = "method not allowed";
    }

    public void build500(){
        status = 500;
        message = "Internal Server Error";
    }

}
