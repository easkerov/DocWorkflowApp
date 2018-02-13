package com.easkerov.dao;

import com.easkerov.model.Document;
import java.util.List;

public interface DocumentService {

    List<Document> getAll();

    Document getDocument(Long id );

    void addDocument(Document document);

    void delDocument(Long id);

}
