package com.easkerov.docworkflowapp.service;

import com.easkerov.docworkflowapp.domain.Document;

import java.util.List;

public interface DocumentService {

    List<Document> getAll();

    Document getDocument(Integer id );

    void addDocument(Document document);

    void delDocument(Integer id);

}
