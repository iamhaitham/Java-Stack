package com.codingdojo.DojoOverFlow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.DojoOverFlow.models.Answer;
import com.codingdojo.DojoOverFlow.models.Question;
import com.codingdojo.DojoOverFlow.services.AnswerService;
import com.codingdojo.DojoOverFlow.services.QuestionService;
import com.codingdojo.DojoOverFlow.services.TagService;

@Controller
public class Controllers {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	public Controllers(QuestionService questionService,TagService tagService,AnswerService answerService) {
		this.questionService=questionService;
		this.tagService=tagService;
		this.answerService=answerService;
	}
	
	@RequestMapping("/questions")
	public String displayQuestions(Model model) {
		List<Question> allQuestions=questionService.allQuestions();
		model.addAttribute("allQuestions",allQuestions);
		return "displayQuestions.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute(value="questions") Question question) {
		return "newQuestion.jsp";
	}
	
	@RequestMapping(value="/questions/newProcessing",method=RequestMethod.POST)
	public String processNewQuestion(@Valid @ModelAttribute(value="questions") Question question, BindingResult result) {
		if (result.hasErrors()) {
            return "newQuestion.jsp";
        } else {
        	questionService.createQuestion(question);
    		return "redirect:/questions/new";
        }
	}
	
	@RequestMapping("/questions/{id}")
	public String infoQuestion(Model model,@PathVariable(value="id")Long id, @ModelAttribute(value="answers")Answer answer) {
		Question myQuestion=questionService.findQuestion(id);		
		model.addAttribute("myQuestion",myQuestion);
		return "info.jsp";
	}
	
	@RequestMapping(value="/questions/{id}/createAnswer",method=RequestMethod.POST)
	public String createAnswer(Model model,@Valid @ModelAttribute(value="answers")Answer answer,BindingResult result,@PathVariable(value="id")Long id) {
		if (result.hasErrors()) {
			model.addAttribute("myQuestion",questionService.findQuestion(id));
            return "info.jsp";
        } else {
        	Answer myAnswer=answerService.createAnswer(answer);
        	Question myQuestion=questionService.findQuestion(id);	
        	answerService.updateAnswer(myQuestion,myAnswer);
        	return "redirect:/questions/"+id;
        }
	}
	
}
