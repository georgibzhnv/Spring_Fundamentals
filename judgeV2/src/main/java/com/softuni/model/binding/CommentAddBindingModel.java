package com.softuni.model.binding;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentAddBindingModel {

    private Integer score;
    private String textContent;
    private Long homeworkId;

    public CommentAddBindingModel() {
    }

    @Min(value = 2, message = "Score must be more than 2")
    @Max(value = 6, message = "Score must be less than 6")
    public Integer getScore() {
        return score;
    }

    public CommentAddBindingModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Size(min = 3, message = "Text content length must be more than 3")
    @NotBlank(message = "Cannot be empty")
    public String getTextContent() {
        return textContent;
    }

    public CommentAddBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public CommentAddBindingModel setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
        return this;
    }
}
