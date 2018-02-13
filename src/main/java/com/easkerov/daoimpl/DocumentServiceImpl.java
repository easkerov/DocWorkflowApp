package com.easkerov.daoimpl;

import com.easkerov.dao.DocumentService;
import com.easkerov.model.Document;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Document> getAll() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a SQL query
        Query query = session.createQuery("FROM Document");

        List<Document> result = query.list();

        // Retrieve all documents
        return result;
    }

    @Override
    public Document getDocument(Long id) {

        // Retrieve session from Hibernate
        /*Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Document document = (Document) session.get(Document.class, id);

        return document;*/

        return null;
    }

    @Override
    public void addDocument(Document document) {

        // Retrieve session from Hibernate
        /*Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(document);*/

    }

    @Override
    public void delDocument(Long id) {

        // Retrieve session from Hibernate
        /*Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Document person = (Document) session.get(Document.class, id);

        // Delete
        session.delete(person);*/

    }
}
