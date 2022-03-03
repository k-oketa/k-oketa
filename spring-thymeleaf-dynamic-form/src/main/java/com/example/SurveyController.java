package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("survey")
public class SurveyController {

    @GetMapping
    public ModelAndView surveyCreationForm(ModelAndView mav) {
        mav.addObject("surveyField", new SurveyField());
        mav.setViewName("survey");
        return mav;
    }

    @PostMapping(params = {"addQuestion"})
    public ModelAndView addQuestion(@ModelAttribute SurveyField surveyField, ModelAndView mav) {
        surveyField.addQuestion();
        return mav;
    }
}
