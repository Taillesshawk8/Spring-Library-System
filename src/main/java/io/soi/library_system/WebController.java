package io.soi.library_system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    // Function to interact with the HTML page
    @GetMapping("/")
    public String homePage() {
        return "login";  // Return the name of the HTML template (Thymeleaf will resolve it)
    }

    @PostMapping("/login")
    public String handleUsername(
        @RequestParam String username,
        @RequestParam String password,
        Model model)
    {
        if ("test".equalsIgnoreCase(username) && "pass".equalsIgnoreCase(password)) 
        {
            return "redirect:/homePage";
        }
        else
        {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/homePage")
    public String showHomePage()
    {
        return "homePage";
    }
}

