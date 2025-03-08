package bg.softuni.mobilele.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private static final String ANONYMOUS="anonymous";

    private String name=ANONYMOUS;
    private boolean isAnonymous;


    public void setName(String name) {
        this.name = name;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        if (anonymous){
            this.name=ANONYMOUS;
        }
        isAnonymous = anonymous;
    }

    public String getName() {
        return name;
    }
}
