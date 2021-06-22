package com.codingdojo.OneToMany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.OneToMany.models.Dojo;
import com.codingdojo.OneToMany.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository=dojoRepository;
	}
	
	public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

	public Dojo createDojo(Dojo dojo,String dojoName) {
		dojo.setName(dojoName);
        return dojoRepository.save(dojo);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
