package mk.ukim.finki.wpaudrecap.web.controller;

import mk.ukim.finki.wpaudrecap.model.User;
import mk.ukim.finki.wpaudrecap.model.exceptions.InvalidUsernameCredentialsException;
import mk.ukim.finki.wpaudrecap.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try{
            user = this.authService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        } catch(InvalidUsernameCredentialsException ex) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
            return "login";
        }
    }

}
