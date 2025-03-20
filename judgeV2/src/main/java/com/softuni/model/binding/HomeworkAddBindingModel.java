package com.softuni.model.binding;

import jakarta.validation.constraints.Pattern;

public class HomeworkAddBindingModel {

    private String exercise;
    private String gitAddress;

    public HomeworkAddBindingModel() {
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+"
            ,message = "Enter valid git address!")
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
