package com.dojo.language;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojo.language.models.Language;
import com.dojo.language.services.LanguageServices;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dojo.language.models.Language;
//import com.dojo.language.services.LanguageServices;
//@RestController
@Controller
public class HomeController {
	 private final LanguageServices languageServices;
	    
	    public HomeController(LanguageServices languageServices) {
	        this.languageServices = languageServices;
	    }
	    
	    @RequestMapping("/languages")
	    public String index(Model model) {
	        List<Language> languages = languageServices.allLanguages();
	        model.addAttribute("language", languages);
	        return "index.jsp";
	    }
	    
	    
	    @RequestMapping("/new")
	    public String newLanguage(@ModelAttribute("language") Language language) {
	        return "new.jsp";
	    }
	    @RequestMapping(value="/languages/create", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "new.jsp";
	        } else {
	            languageServices.createLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	    
	    @RequestMapping(value="/delete/{id}")
    	public String delete(@PathVariable("id") Long id) {
    		this.languageServices.deleteLanguage(id);
    		return "redirect:/languages";
    	}
	    
	    
	    
//	    @RequestMapping("/api/languages")
//	    public List<Language> index() {
//	        return languageServices.allLanguages();
//	    }
//	    
//	    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
//	    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
//	        Language language = new Language(name, creator,version);
//	        return languageServices.createLanguage(language);
//        }
	    
	    //Prepopulate form
	    @GetMapping("/update/{id}")
	    public String update(@PathVariable("id")Long id,@ModelAttribute("language") Language language,Model model) {
	    	Language languageToShow = this.languageServices.getLanguage(id);
	    	model.addAttribute("thisLanguage",languageToShow);
	    	return "update.jsp";
	    }
	    
	    @RequestMapping(value="api/update/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "update.jsp";
	        } else {
	            languageServices.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	    
	    
	  //view or show page
	    
	    @RequestMapping("/api/languages/{id}")
	    public Language show(@PathVariable("id") Long id) {
	        Language language = languageServices.findLanguage(id);
	        return language;
	    }
	    @GetMapping("/view/{id}")
	    public String viewBook(@PathVariable("id")Long id,Model model) {
	    	Language languageToShow = this.languageServices.getLanguage(id);
	    	model.addAttribute("thisLanguage",languageToShow);
	    	return "view.jsp";
	    }
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	private final LanguageServices languageServices;
//    public  HomeController(LanguageServices languageServices){
//        this.languageServices = languageServices;
//    }
//    @RequestMapping("/api/languages")
//    public List<Language> index() {
//        return languageServices.allLanguages();
//    }
//    
//    @RequestMapping(value="/api/languages/create", method=RequestMethod.POST)
//    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
//        Language language = new Language(name, creator, version);
//        System.out.println(name);
//        return languageServices.createLanguage(language);
//    }
//    
//    @RequestMapping("/api/languages/{id}/show")
//    public Language show(@PathVariable("id") Long id) {
//        Language language = languageServices.findLanguage(id);
//        return language;
//    }
//    @RequestMapping(value="/api/languages/{id}/update", method=RequestMethod.PUT)
//    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
//        Language language = languageServices.updateLanguage(id,name, creator,version);
//        return language;
//    }
//    
//    @RequestMapping(value="/api/languages/{id}/delete", method=RequestMethod.DELETE)
//    public void delete(@PathVariable("id") Long id) {
//        languageServices.deleteLanguage(id);
//    }
//    
}
    

