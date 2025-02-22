package bg.softuni.bg2.demo.test;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{

    @Override
    public String makeNoise() {
        return "waf-waf";
    }
}
