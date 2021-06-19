package com.dojo.language.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.language.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language>findAll(); 
}
