package com.msoft.core.controller;

import com.msoft.core.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ManhKM on 1/29/2023
 * @project cicd-tutorial
 */
@Controller
@RequestMapping("/student")
public class StudentController {

//    /student/form
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String studentForm(Model model){

        // create a new student object:
        Student student = new Student();

        // add student object (firstName, lastName, country) to the model
        model.addAttribute("student", student);

        return "student-form";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String studentConfirmation(@ModelAttribute("student") Student student, ModelMap modelMap){
        System.out.println("The Student | firstName: " + student.getFirstName()
                + " , lastName: " + student.getLastName()
                + " , country: " + student.getCountry()
                + " , favoriteLanguage: " + student.getFavoriteLanguage()
                + " , OperatingSystem: " + student.getOperatingSystemData());
        modelMap.addAttribute("student", student);

        return "student-confirmation";
    }
}
