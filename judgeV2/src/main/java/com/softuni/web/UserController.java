package com.softuni.web;

import com.softuni.model.binding.UserLoginBinding;
import com.softuni.model.binding.UserRegisterBinding;
import com.softuni.model.service.UserServiceModel;
import com.softuni.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model){
        if (!model.containsAttribute("userLoginBinding")){
            model.addAttribute("userLoginBinding",new UserLoginBinding());
            model.addAttribute("notFound",false);
        }
        return "login";
    }
    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginBinding userLoginBinding,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBinding",userLoginBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBinding",bindingResult);

            return "redirect:login";
        }

        UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBinding.getUsername()
                ,userLoginBinding.getPassword());

        if (user==null){
            redirectAttributes.addFlashAttribute("userLoginBinding",userLoginBinding);
            redirectAttributes.addFlashAttribute("notFound",true);

            return "redirect:login";
        }

//        httpSession.setAttribute("user",user);

        userService.login(user);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        if (!model.containsAttribute("userRegisterBinding")){
           model.addAttribute("userRegisterBinding",new UserRegisterBinding());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBinding userRegisterBinding,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()||
                !userRegisterBinding.getPassword().equals(userRegisterBinding.getConfirmedPassword())){
            redirectAttributes.addFlashAttribute("userRegisterBinding",userRegisterBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBinding",bindingResult);
            return "redirect:register";
        }

        UserServiceModel userServiceModel =modelMapper.map(userRegisterBinding,UserServiceModel.class);
        userService.registerUser(userServiceModel);
        return "redirect:/login";
    }
}
