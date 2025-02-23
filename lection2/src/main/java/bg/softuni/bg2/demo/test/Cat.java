package bg.softuni.bg2.demo.test;

import org.springframework.stereotype.Component;

public class Cat implements Animal{
    @Override
    public String makeNoise() {
        return "meow";
    }
}
