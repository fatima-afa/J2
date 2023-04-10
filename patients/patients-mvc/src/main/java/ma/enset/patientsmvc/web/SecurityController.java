package ma.enset.patientsmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/notAuthorized")
    public String notAuthorized(){
        return "noAuthorized";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}