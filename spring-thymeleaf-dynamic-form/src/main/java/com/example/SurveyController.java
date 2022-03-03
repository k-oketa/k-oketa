package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("survey")
@Slf4j
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

    @PostMapping(params = {"index"})
    public ModelAndView addQuestion(@RequestParam("index") int index, @ModelAttribute SurveyField surveyField, ModelAndView mav) {
        surveyField.getQuestionFields().get(index).addOptionField();
        return mav;
    }
}
