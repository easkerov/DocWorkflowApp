package com.easkerov.docworkflowapp.test;

import com.easkerov.docworkflowapp.dao.DocumentDAO;
import com.easkerov.docworkflowapp.domain.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-context.xml"})
@Transactional
public class DocumentDAOTest {

    @Autowired
    private DocumentDAO documentDAO;


    @Test
    public void getDocumentTest(){
        Integer docId = 872456;

        Document document = new Document();
        document.setId(docId);
        documentDAO.addDocument(document);

        assertEquals(document, documentDAO.getDocument(docId));
    }

    @Test
    public void addDocumentTest(){
        Integer docId = 872456;
        int docListSize = documentDAO.getAll().size();

        Document document = new Document();
        document.setId(docId);
        documentDAO.addDocument(document);

        assertTrue(docListSize < documentDAO.getAll().size());
    }

    @Test
    public void delDocumentTest(){
        // Inserting a new document
        Integer docId = 872456;
        Document document = new Document();
        document.setId(872456);
        documentDAO.addDocument(document);
        // Testing that document exists
        assertEquals(document, documentDAO.getDocument(docId));

        // Deleting the document and trying to get it
        documentDAO.delDocument(docId);
        assertNull(documentDAO.getDocument(docId));
    }


    @Test
    public void getAllTest(){

        int expectedSize = 3;

        // Removing all existing documents
        for (Document doc : documentDAO.getAll()) {
            documentDAO.delDocument(doc.getId());
        }

        // Adding new documents
        for (int i = 0; i < expectedSize; i++) {
            Document doc = new Document();
            doc.setId(i+1000);
            documentDAO.addDocument(doc);
        }

        // Testing actual size and expected size
        assertTrue(expectedSize == documentDAO.getAll().size());
    }
}
