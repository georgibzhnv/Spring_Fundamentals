package com.softuni.model.view;

public class HomeworkViewModel {
    private Long id;
    private String gitAddress;

    public HomeworkViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
