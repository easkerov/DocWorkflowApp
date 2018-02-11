package com.easkerov.service;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.easkerov.domain.DocumentEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("documentService")
@Transactional
public class DocumentService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;


    /**
     * Retrieves all documents
     *
     * @return a list of documents
     */
    public List<DocumentEntity> getAll() {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM DOCUMENTS");

        // Retrieve all documents
        return  query.list();
    }

    /**
     * Retrieves a single person
     */
    public DocumentEntity get(Integer id ) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        DocumentEntity document = (DocumentEntity) session.get(DocumentEntity.class, id);

        return document;
    }

    /**
     * Adds a new person
     */
    public void add(DocumentEntity document) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(document);
    }

    /**
     * Deletes an existing person
     * @param id the id of the existing person
     */
    public void delete(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        DocumentEntity person = (DocumentEntity) session.get(DocumentEntity.class, id);

        // Delete
        session.delete(person);
    }

}
