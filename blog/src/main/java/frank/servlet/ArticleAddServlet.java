package frank.servlet;

import frank.model.Article;
import frank.model.Result;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//注解和 xml配置二选一，必须以 / 开头
@WebServlet("/articleAdd")
public class ArticleAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        Result result = new Result();
        PrintWriter pw = resp.getWriter();


        try {
            Article article = JSONUtil.deserialize(req.getInputStream(),Article.class);
            System.out.println("请求数据："+article);

            //TODO  需要把文章保存到数据库
            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("OK");


        } catch (IOException e) {
            result.setCode("500xx");
            result.setMessage("服务器出错了！");
            e.printStackTrace();
        }
        pw.println();

    }
}
