package com.softuni.web;

import com.softuni.model.binding.CommentAddBindingModel;
import com.softuni.model.service.CommentServiceModel;
import com.softuni.model.view.HomeworkViewModel;
import com.softuni.service.CommentService;
import com.softuni.service.HomeworkService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    private final HomeworkService homeworkService;
    private final ModelMapper modelMapper;
    private final CommentService commentService;

    public CommentsController(HomeworkService homeworkService, ModelMapper modelMapper, CommentService commentService) {
        this.homeworkService = homeworkService;
        this.modelMapper = modelMapper;
        this.commentService = commentService;
    }

    @GetMapping("/add")
    public String add(Model model){

        if (!model.containsAttribute("commentAddBindingModel")){
            model.addAttribute("commentAddBindingModel",
                    new CommentAddBindingModel());
        }

        HomeworkViewModel homework = modelMapper.map(homeworkService.findHomeworkForScoring(),HomeworkViewModel.class);
        model.addAttribute("homework",homework);
        return "homework-check";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid CommentAddBindingModel commentAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("commentAddBindingModel",commentAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.commentAddBindingModel",bindingResult);
            return "redirect:add";
        }

        CommentServiceModel serviceModel = modelMapper.map(commentAddBindingModel,CommentServiceModel.class);

        commentService.add(serviceModel,commentAddBindingModel.getHomeworkId());

        return "redirect:/";
    }
}
