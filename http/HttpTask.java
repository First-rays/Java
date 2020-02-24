package http;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

public class HttpTask implements Runnable{

    //private static ConcurrentMap<String,String> SESSIOONS = new ConcurrentMap<>();
    //private Socket socket;
    private Request request;

    private Response response;
    public HttpTask(Socket socket){
    //   this.socket = socket;
        try {
            //通过客户端发送报文的输入刘
            request = Request.buildRequest(socket.getInputStream());
            response = Response.buildResponse(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接的io流异常！");
        }
    }

    @Override
    public void run() {
        try {
            //将html 文件所在的webapp 需要设置为resource资源文件夹，----->
            // 将webapp中的文件复制编译到输出文件夹
            InputStream is = this.getClass().getClassLoader().
                    getResourceAsStream("."+request.getUrl());
            if(is != null){
                BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));

                String content;
                while ((content = br.readLine()) != null){
                    response.println(content);
                }
                response.build200();

            }else if("/login".equals(request.getUrl())){
                if(!"post".equalsIgnoreCase(request.getMethod())){
                    response.build405();
                    response.println("不支持的请求方法："+request.getMethod());
                }else{
                    response.build200();
                    response.println("请求的数据：" +
                            "username="+request.getParameter("username")
                            +"password="+request.getParameter("password"));
                    //session:将用户信息保存到服务器，并返回客户端
                    String sessionId = UUID.randomUUID().toString();
                    //SESSIOONS.put(sessionId,request.getParameter("username")
                    //+","+request.getParameter("password"));
                    //自己定义header头
                    response.addHeader("SESSIONID",sessionId);
                }
                //敏感的url,没有登录的时间，不能访问
            }else if("/sentitive".equals(request.getUrl())){
                String sessionId = request.getHeader("SESSION");



            } else{
                //所有路径没找到，说明服务器不提供该url的服务，返回404
                response.build404();
                response.println("找不到资源");
            }

            //response.println("正确响应了客户端的信息");

        } catch (IOException e) {
            e.printStackTrace();
            response.build500();
            response.println("服务器出错");
        } finally {
            response.flush();
        }
    }
}
