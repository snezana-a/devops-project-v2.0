package mk.ukim.finki.wpaudrecap.web.servlet;

import mk.ukim.finki.wpaudrecap.model.User;
import mk.ukim.finki.wpaudrecap.model.exceptions.InvalidUsernameCredentialsException;
import mk.ukim.finki.wpaudrecap.service.AuthService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;

@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/login")
public class LoginServlet extends HttpServlet {

    private final SpringTemplateEngine templateEngine;
    private final AuthService authService;

    public LoginServlet(SpringTemplateEngine templateEngine, AuthService authService) {
        this.templateEngine = templateEngine;
        this.authService = authService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        templateEngine.process("login.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = null;
        try {
            user = authService.login(username, password);
        } catch (InvalidUsernameCredentialsException ex) {
            WebContext context = new WebContext(req, resp, req.getServletContext());
            context.setVariable("hasError", true);
            context.setVariable("error", ex.getMessage());
            templateEngine.process("login.html", context, resp.getWriter());
        }
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/servlet/thymeleaf/category");
    }

}
