package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorInfo")
public class AuthorServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        String param = req.getParameter("blogId");
        if(param == null || "".equals(param)){
            resp.getWriter().write("{\"ok\":false,\"reason\":\"参数缺失!\"}");
            return;
        }
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(param));
        if(blog == null){
            resp.getWriter().write("{\"ok\":false,\"reason\":\"博客不存在!\"}");
            return;
        }
        UserDao userDao = new UserDao();
        User author = userDao.selectById(blog.getUserId());


        if(author == null){
            resp.getWriter().write("{\"ok\":false,\"reason\":\"用户不存在!\"}");
            return;
        }
        author.setPassWord("");
        resp.getWriter().write(objectMapper.writeValueAsString(author));

    }
}
