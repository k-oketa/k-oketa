package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping(params = {"addOption"})
    public ModelAndView addOption(@ModelAttribute SurveyField surveyField, HttpServletRequest req, ModelAndView mav) {
        var questionIndex = Integer.parseInt(req.getParameter("addOption"));
        surveyField.getQuestionFields().get(questionIndex).addOptionField();
        return mav;
    }

    @PostMapping(params = {"resetOption"})
    public ModelAndView resetOption(@ModelAttribute SurveyField surveyField, HttpServletRequest req, ModelAndView mav) {
        var questionIndex = Integer.parseInt(req.getParameter("resetOption"));
        surveyField.getQuestionFields().get(questionIndex).getOptionFields().clear();
        return mav;
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute SurveyField surveyField, ModelAndView mav) {
        log.info(surveyField.toString());
        return mav;
    }

    @PostMapping(params = {"removeQuestion"})
    public ModelAndView removeQuestion(@ModelAttribute SurveyField surveyField, HttpServletRequest req, ModelAndView mav) {
        var questionIndex = Integer.parseInt(req.getParameter("removeQuestion"));
        surveyField.getQuestionFields().remove(questionIndex);
        return mav;
    }
}
