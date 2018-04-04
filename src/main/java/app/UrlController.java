package app;


import app.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UrlController {

    @Autowired
    UrlRepository urlRepository;

    @RequestMapping("/")
    public String index() {
        return "Congratulations from UrlController.java";
    }

    //Just a Demo route
    @GetMapping("/fetchurl")
    public List<Collections> fetchUrl(){
        Collections urlPojo=new Collections();
        urlPojo.setId(1);
        urlPojo.setToken("quiwhs");
        urlPojo.setUrl("https://www.google.com");
        String tinyUrl="https://www.yourdomain.com/"+urlPojo.getToken();
        List<Collections> urlPojoList = new ArrayList<>();
        urlPojoList.add(urlPojo);
        return urlPojoList;
    }

    @GetMapping("/fetchall")
    public List<Collections> fetchall(){
        return urlRepository.findAll();
    }


    @PostMapping("/generatetoken")
    public Collections create(@RequestBody Map<String, String> body){
        TokenGenerator obj = new TokenGenerator();
        String url = body.get("url");
        Collections urlPojo=new Collections();
        urlPojo.setUrl(url);
        urlPojo.setToken(obj.generateToken(url));
        String tinyUrl="https://www.yourdomain.com/"+urlPojo.getToken();
        return urlRepository.save(urlPojo);
    }

}