package com.easkerov.docworkflowapp.dao;

import com.easkerov.docworkflowapp.domain.Document;

import java.util.List;

public interface DocumentDAO {

    List<Document> getAll();

    Document getDocument(Integer id );

    void addDocument(Document document);

    void delDocument(Integer id);

}
