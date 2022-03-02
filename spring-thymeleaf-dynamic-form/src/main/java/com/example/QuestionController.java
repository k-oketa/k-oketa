package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@Slf4j
public class QuestionController {

    @GetMapping
    public ModelAndView surveyCreationForm(@ModelAttribute Survey survey, ModelAndView mav) {
        mav.addObject("survey", survey);
        mav.setViewName("survey");
        return mav;
    }

    @PostMapping(value = "/survey", params = {"add"})
    public ModelAndView addQuestion(@ModelAttribute Survey survey, BindingResult bindingResult, ModelAndView mav) {
        survey.addQuestion();
        mav.addObject("survey", survey);
        return mav;
    }

    @PostMapping(value = "/survey", params = {"addDescription"})
    public ModelAndView addDescriptionField(@ModelAttribute Survey survey, BindingResult bindingResult, ModelAndView mav) {
        survey.addDescriptionField();
        return mav;
    }
}
