import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("username");
        Integer count = (Integer)session.getAttribute("count");
        count+=1;
        session.setAttribute("count",count);

        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("<h3> 欢迎你~ "+username+"第 "+count+"次访问！"+"</h3>");
    }
}
