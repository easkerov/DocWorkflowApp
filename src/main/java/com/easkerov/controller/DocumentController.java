package com.easkerov.controller;

import java.util.List;
import com.easkerov.domain.DocumentEntity;
import com.easkerov.service.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/main")
public class DocumentController {

    @Resource(name="documentService")
    private DocumentService personService;


    /**
     * Handles and retrieves all persons and show it in a JSP page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/doclist", method = RequestMethod.GET)
    public String getPersons(Model model) {

        // Retrieve all persons by delegating the call to PersonService
        List<DocumentEntity> documents = personService.getAll();

        // Attach persons to the Model
        model.addAttribute("documents", documents);

        // This will resolve to /WEB-INF/jsp/personspage.jsp
        return "doclist";
    }

}
