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

    @PostMapping("/login") //links to method: post on login.html
    public String handleUsername(
        @RequestParam String username, //requesting username
        @RequestParam String password, //reguesting password
        Model model)
    {
        //checks if the values are correct
        if ("test".equalsIgnoreCase(username) && "pass".equalsIgnoreCase(password)) 
        {
            //opens homepage method
            return "redirect:/homePage";
        }
        else
        {
            //error message
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    //opens homepage
    @GetMapping("/homePage")
    public String showHomePage()
    {
        return "homePage";
    }
}

