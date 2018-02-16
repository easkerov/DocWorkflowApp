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

    /**
     * Retrieve all documents from DB
     * @return
     */
    public List<Document> getAll() {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a HQL query
        Query query = session.createQuery("FROM Document");

        // Retrieve all documents
        return query.list();
    }

    /**
     * Return document object from DB by provided id
     * @param id
     * @return
     */
    public Document getDocument(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing document first
        Document document = (Document) session.get(Document.class, id);

        return document;
    }

    /**
     * Add document to DB by Document object
     * @param document
     */
    public void addDocument(Document document) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(document);

    }

    /**
     * Delete a document from DB by id
     * @param id
     */
    public void delDocument(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing document first
        Document document = (Document) session.get(Document.class, id);

        // Delete
        session.delete(document);
    }
}
