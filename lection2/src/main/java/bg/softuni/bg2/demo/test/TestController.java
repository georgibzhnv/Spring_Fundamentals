package bg.softuni.bg2.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    final Animal animal1,animal2;

    @Autowired
    public TestController(Animal animal1,Animal animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("message",animal1.makeNoise()+animal1.hashCode()
                + " " +
                animal2.makeNoise()+animal2.hashCode());
        return "test";
    }
}
