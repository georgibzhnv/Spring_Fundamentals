package bg.softuni.mobilele.security;

import bg.softuni.mobilele.model.entities.enums.UserRoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

    private static final String ANONYMOUS="anonymous";

    private String name=ANONYMOUS;
    private boolean isAnonymous=true;
    private List<UserRoleEnum>userRoles = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public CurrentUser setUserRoles(List<UserRoleEnum>newUserRoles){
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }
    public boolean isAdmin(){
        return userRoles.contains(UserRoleEnum.ADMIN);
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean isLoggedIn(){
        return !isAnonymous();
    }

    public void setAnonymous(boolean anonymous) {
        if (anonymous){
            this.name=ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
    }

    public String getName() {
        return name;
    }
}
