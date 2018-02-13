package com.easkerov.docworkflowapp.dao;

import com.easkerov.docworkflowapp.domain.Document;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentDAOImpl implements DocumentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Document> getAll() {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a SQL query
        Query query = session.createQuery("FROM Document");

        // Retrieve all documents
        return query.list();
    }

    public Document getDocument(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Document document = (Document) session.get(Document.class, id);

        return document;
    }

    public void addDocument(Document document) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(document);

    }

    public void delDocument(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing document first
        Document document = (Document) session.get(Document.class, id);

        // Delete
        session.delete(document);
    }
}
