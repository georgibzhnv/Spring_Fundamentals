package com.softuni.service.impl;

import com.softuni.model.entity.RoleNameEnum;
import com.softuni.model.entity.User;
import com.softuni.model.service.UserServiceModel;
import com.softuni.model.view.UserProfileViewModel;
import com.softuni.repository.UserRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.RoleService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel,User.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username,password)
                .map(user->modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId());
        currentUser.setUsername(userServiceModel.getUsername());
        currentUser.setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        currentUser.setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleNameEnum roleNameEnum) {
        User user = userRepository.findByUsername(username)
                .orElse(null);

        if (user.getRole().getName()!=roleNameEnum){
            user.setRole(roleService.findRole(roleNameEnum));

            userRepository.save(user);
        }
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public UserProfileViewModel findProfileById(Long id) {
        User user=userRepository.findById(id)
                .orElse(null);

        UserProfileViewModel userProfileViewModel = modelMapper.map(user,UserProfileViewModel.class);
        userProfileViewModel.setHomeworkSet(user.getHomeworkSet()
                .stream().map(homework -> homework.getExercise().getName())
                .collect(Collectors.toSet()));

        return  userProfileViewModel;
    }

    @Override
    public Long findUsersCount() {
        return userRepository.count();
    }
}
