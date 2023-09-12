package com.nsane.springboot.thymleafdemo.Controller;

import com.nsane.springboot.thymleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${favouriteLanguage}")
    private List<String> favouriteLanguage;

    @Value("${favouriteSystem}")
    private List<String> favouriteSystem;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {
        // create a student object
        Student theStudent = new Student();
        // add student object to the model
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("favouriteLanguage", favouriteLanguage);
        theModel.addAttribute("favouriteSystem", favouriteSystem);
        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
