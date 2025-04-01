package com.softuni.service.impl;

import com.softuni.model.entity.Comment;
import com.softuni.model.service.CommentServiceModel;
import com.softuni.repository.CommentRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.CommentService;
import com.softuni.service.HomeworkService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final HomeworkService homeworkService;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, ModelMapper modelMapper, CurrentUser currentUser, HomeworkService homeworkService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.homeworkService = homeworkService;
    }

    @Override
    public void add(CommentServiceModel serviceModel, Long homeworkId) {
        Comment comment = modelMapper.map(serviceModel,Comment.class);
        comment.setAuthor(userService.findById(currentUser.getId()));
        comment.setHomework(homeworkService.findById(homeworkId));

        commentRepository.save(comment);
    }
}
