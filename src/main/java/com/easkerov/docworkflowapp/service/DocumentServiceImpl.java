package com.easkerov.docworkflowapp.service;

import com.easkerov.docworkflowapp.dao.DocumentDAO;
import com.easkerov.docworkflowapp.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDAO documentDAO;

    @Transactional
    public List<Document> getAll() {

        return documentDAO.getAll();
    }

    @Transactional
    public Document getDocument(Integer id) {

        return documentDAO.getDocument(id);
    }

    @Transactional
    public void addDocument(Document document) {

        // Inserting current date
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        document.setDate(sqlDate);

        documentDAO.addDocument(document);
    }

    @Transactional
    public void delDocument(Integer id) {

        documentDAO.delDocument(id);
    }
}
