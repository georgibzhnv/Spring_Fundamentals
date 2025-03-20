package com.softuni.service;

import jakarta.validation.constraints.Pattern;

public interface HomeworkService {
    void addHomework(String exercise, @Pattern(regexp = "https:\\/\\/github\\.com\\/.+"
            ,message = "Enter valid git address!") String gitAddress);
}
