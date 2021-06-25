package com.codingdojo.DojoOverFlow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverFlow.models.Answer;
import com.codingdojo.DojoOverFlow.models.Question;
import com.codingdojo.DojoOverFlow.repositories.AnswerRepository;
import com.codingdojo.DojoOverFlow.repositories.QuestionRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	public AnswerService(AnswerRepository answerRepository,QuestionRepository questionRepository) {
		this.answerRepository=answerRepository;
		this.questionRepository=questionRepository;
	}
	
  public List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if(optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }
    	
    public Answer updateAnswer(Question myQuestion,Answer myAnswer) {
    	myAnswer.setQuestion(myQuestion);
    	return answerRepository.save(myAnswer);
    }

}
