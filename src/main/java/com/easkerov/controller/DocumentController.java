package com.easkerov.controller;

import com.easkerov.dao.DocumentService;
import com.easkerov.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class DocumentController {

    private final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @Resource(name="documentService")
    private DocumentService documentService;

    @RequestMapping(value = "/document/list", method = RequestMethod.GET)
    public String getPersons(Model model) {

        logger.debug("Viewing list of documents to user");

        List<Document> documents = documentService.getAll();

        model.addAttribute("documents", documents);

        return "doclist";
    }

    @RequestMapping(value = "/document/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        logger.debug("Show 'Add Document' page");

        model.addAttribute("document", new Document());

        return "adddoc";
    }

    @RequestMapping(value = "/document/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("document") Document document) {

        logger.debug("Request to add new document");

        documentService.addDocument(document);

        return "doclist";
    }


    @RequestMapping(value = "/document/delete", method = RequestMethod.GET)
    public String delete(Model model) {

        logger.debug("Show 'Remove Document' page");

        return "deldoc";
    }

    @RequestMapping(value = "/document/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value="id") Long id, Model model) {

        logger.debug("Removing the document...");

        documentService.delDocument(id);

        model.addAttribute("id", id);

        return "doclist";
    }

}
