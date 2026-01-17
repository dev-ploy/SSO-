package com.example.demo.components;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

import java.util.Map;


@Component
public class OauthEventListener {
    private final UserRepo userRepo;//dependency injection

    public OauthEventListener(UserRepo userRepo) {
        this.userRepo = userRepo; //constructor injection
    }
    @EventListener
    public void handleLogin(AuthenticationSuccessEvent event){
        // to handle
        if(!(event.getAuthentication().getPrincipal() instanceof OAuth2User)){
            return;
        }
        OAuth2User user=(OAuth2User) event.getAuthentication().getPrincipal();
        Map<String,Object> attributes=user.getAttributes();
        Long id=((Number) attributes.get("id")).longValue();
        User u=new User();
        u.setId(id);
        u.setLogin((String)attributes.get("login"));
//        u.setEmail((String)attributes.get("email"));
//        u.setUsername((String)attributes.get("username"));
        userRepo.save(u);
    }


}