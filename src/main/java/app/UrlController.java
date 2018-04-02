package app;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @RequestMapping("/")
    public String index() {
        return "Congratulations from UrlController.java";
    }

}