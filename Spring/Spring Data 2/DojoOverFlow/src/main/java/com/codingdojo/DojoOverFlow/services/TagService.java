package com.codingdojo.DojoOverFlow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverFlow.models.Question;
import com.codingdojo.DojoOverFlow.models.Tag;
import com.codingdojo.DojoOverFlow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	public TagService(TagRepository tagRepository) {
		this.tagRepository=tagRepository;
	}	
	
	public List<Tag> allTags(){
		return tagRepository.findAll();
	}
	
	 public Tag createTag(Tag tag) {
	        return tagRepository.save(tag);
	    }

	    public Tag findTag(Long id) {
	        Optional<Tag> optionalTag = tagRepository.findById(id);
	        if(optionalTag.isPresent()) {
	            return optionalTag.get();
	        } else {
	            return null;
	        }
	    }
}
