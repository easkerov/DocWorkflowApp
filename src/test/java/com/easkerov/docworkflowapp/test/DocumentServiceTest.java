package com.easkerov.docworkflowapp.test;

import com.easkerov.docworkflowapp.domain.Document;
import com.easkerov.docworkflowapp.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-context.xml"})
public class DocumentServiceTest {

    @Autowired
    private DocumentService documentService;

    @Test
    public void addDocumentServiceTest() {

        Integer docId = 54321;
        Document doc = new Document();
        doc.setId(docId);

        documentService.addDocument(doc);

        Document foundDoc = documentService.getDocument(docId);

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

        String date = sdf.format(new Date());;
        String docDate = sdf.format(foundDoc.getDate());

        assertTrue(date.equals(docDate));
    }

}
