package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null || "".equals(username) || password==null || "".equals(password)){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前的用户名或密码为空~");
            return;
        }
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(username);
        if(user == null ||!user.getPassWord().equals(password)){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户名或密码错误~");
            return;
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("user",user);

        resp.sendRedirect("blog_list.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        HttpSession session = req.getSession(false);
        if (session == null) {
            User user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        user.setPassWord("");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
