package com.codingdojo.DojoOverFlow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverFlow.models.Question;
import com.codingdojo.DojoOverFlow.models.Tag;
import com.codingdojo.DojoOverFlow.repositories.AnswerRepository;
import com.codingdojo.DojoOverFlow.repositories.QuestionRepository;
import com.codingdojo.DojoOverFlow.repositories.TagRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	private final AnswerRepository answerRepository;
	public QuestionService(QuestionRepository questionRepository,TagRepository tagRepository,AnswerRepository answerRepository) {
		this.questionRepository=questionRepository;
		this.tagRepository=tagRepository;
		this.answerRepository=answerRepository;
	}
	
  public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public Question createQuestion(Question question) {
    	ArrayList<Tag> questionsTags = new ArrayList<Tag>();
    	for(String subject: question.splitTags()) {
    		Tag tag = this.tagRepository.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tagRepository.save(tag);
			}
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
    	}
//    	Question newQuestion = new Question(question.getQuestion(), questionsTags);
    	question.setTags(questionsTags);
        return questionRepository.save(question);
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
    
}
