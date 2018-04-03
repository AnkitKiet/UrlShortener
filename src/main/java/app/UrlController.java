package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UrlController {

    @Autowired
    UrlRepository urlRepository;

    @RequestMapping("/")
    public String index() {
        return "Congratulations from UrlController.java";
    }

    @GetMapping("/fetchurl")
    public List<Collections> fetchUrl(){
        Collections urlPojo=new Collections();
        urlPojo.setId(1);
        urlPojo.setToken("quiwhs");
        urlPojo.setUrl("https://www.google.com");
        String tinyUrl="https://www.yourdomain.com/"+urlPojo.getToken();
       // urlPojo.setTinyUrl(tinyUrl);
        List<Collections> urlPojoList = new ArrayList<>();
        urlPojoList.add(urlPojo);
        return urlPojoList;
    }

    @GetMapping("/fetchall")
    public List<Collections> fetchall(){
        return urlRepository.findAll();
    }


}