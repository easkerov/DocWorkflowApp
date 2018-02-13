package com.easkerov.docworkflowapp.web;

import com.easkerov.docworkflowapp.domain.Document;
import com.easkerov.docworkflowapp.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {

    private final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getPersons(Model model) {

        logger.debug("Viewing list of documents to user");

        List<Document> documents = documentService.getAll();

        model.addAttribute("documents", documents);

        return "doclist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        logger.debug("Show 'Add Document' page");

        model.addAttribute("document", new Document());

        return "adddoc";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("document") Document document) {

        logger.debug("Request to add new document");

        documentService.addDocument(document);

        return "redirect:/document/list";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model) {

        logger.debug("Show 'Remove Document' page");

        model.addAttribute("document", new Document());

        return "deldoc";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("document") Document document) {

        logger.debug("Removing the document #" + document.getId());

        documentService.delDocument(document.getId());

        return "redirect:/document/list";
    }

}
