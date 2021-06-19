package com.dojo.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.language.models.Language;
import com.dojo.language.repositories.LanguageRepository;

@Service
public class LanguageServices {
	private final LanguageRepository languageRepository;

	public LanguageServices(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	// returns all the languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
        //this create language
	public Language createLanguage(Language L) {
		return languageRepository.save(L);
	}

	// retrieves a Language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	//This is  a code to delete 
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);
	}
	
	//Prepopulate
   public Language getLanguage(Long id) {
		Optional<Language> optionalLanguage = this.languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}

    }
          //update
	public Language updateLanguage(Long id,String name,String creator,String version) {
	    	Language toUpdateLanguage = this.languageRepository.findById(id).orElseGet(null);
	    	if (toUpdateLanguage==null) {
				return null;
			}
	    	else {
	    		toUpdateLanguage.setName(name);
	    		toUpdateLanguage.setCreator(creator);
	    		toUpdateLanguage.setVersion(version);
	    		
	    		return this.languageRepository.save(toUpdateLanguage);
	    	}
	}

	     public  Language updateLanguage( Language language) {
	    	return this.languageRepository.save(language);
	    }
}

