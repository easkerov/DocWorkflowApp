package com.easkerov.docworkflowapp.web;

import com.easkerov.docworkflowapp.config.ApplicationConstants;
import com.easkerov.docworkflowapp.domain.Document;
import com.easkerov.docworkflowapp.service.DocumentService;
import com.easkerov.docworkflowapp.util.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {

    private static final Logger logger = LoggerUtil.getLogger(DocumentController.class);

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getDocuments(HttpServletRequest request, Model model) {

        List<Document> documents = documentService.getAll();

        model.addAttribute("documents", documents);

        LoggerUtil.logActivity(logger,
                "debug",
                "getDocuments",
                request.getMethod(),
                request.getRequestURI(),
                "Show 'Document List' view");

        return "doclist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddDocument(Model model, HttpServletRequest request) {

        model.addAttribute("document", new Document());

        LoggerUtil.logActivity(logger,
                "debug",
                "getAddDocument",
                request.getMethod(),
                request.getRequestURI(),
                "Show 'Add Document' view");

        return "adddoc";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDocument(@ModelAttribute("document") Document document, BindingResult bindingResult, HttpServletRequest request) {

        //Input validation
        boolean error = false;

            // Validating document number value
            if (document.getId() == null) {
                bindingResult.rejectValue("id", "error_null");
                error = true;
            } else if (document.getId() < 0 || document.getId() > ApplicationConstants.DOCUMENT_ID_MAX_VALUE) {
                bindingResult.rejectValue("id", "error_val");
                error = true;
            } else if (documentService.getDocument(document.getId()) != null) {
                bindingResult.rejectValue("id", "error_exist");
                error = true;
            }

            // Validating document amount value
            if (document.getAmount() == null) {
                bindingResult.rejectValue("amount", "error_null");
                error = true;
            } else if (document.getAmount().compareTo(BigDecimal.ZERO) == -1) {
                bindingResult.rejectValue("amount", "error_val");
                error = true;
            }

        if(error) {
            return "adddoc";
        }

        documentService.addDocument(document);

        LoggerUtil.logActivity(logger,
                "debug",
                "addDocument",
                request.getMethod(),
                request.getRequestURI(),
                "Creating document " + document.toString());

        return "redirect:/document/list";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelDocument(Model model, HttpServletRequest request) {

        model.addAttribute("document", new Document());

        LoggerUtil.logActivity(logger,
                "debug",
                "getDelDocument",
                request.getMethod(),
                request.getRequestURI(),
                "Show 'Remove Document' page");

        return "deldoc";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delDocument(@ModelAttribute("document") Document document, BindingResult bindingResult, HttpServletRequest request) {

        boolean error = false;

        // Validating document number value
        if(document.getId() == null){
            bindingResult.rejectValue("id", "error_null");
            error = true;
        } else if (document.getId() < 0 || document.getId() > ApplicationConstants.DOCUMENT_ID_MAX_VALUE) {
            bindingResult.rejectValue("id", "error_val");
            error = true;
        } else if (documentService.getDocument(document.getId()) == null) {
            bindingResult.rejectValue("id", "error_notexist");
            error = true;
        }

        if(error) {
            return "deldoc";
        }

        documentService.delDocument(document.getId());

        LoggerUtil.logActivity(logger,
                "debug",
                "delDocument",
                request.getMethod(),
                request.getRequestURI(),
                "Removing document #" + document.getId());

        return "redirect:/document/list";
    }

}
