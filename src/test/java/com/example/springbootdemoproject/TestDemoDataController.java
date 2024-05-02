package com.example.springbootdemoproject;

import com.exemple.springbootdemoproject.model.Etudiant;
import com.exemple.springbootdemoproject.repository.EtudiantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
public class TestDemoDataController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Test
    public void testCrudOperations() {
        // Create
        Etudiant etudiant = new Etudiant("John", 25);
        etudiantRepository.save(etudiant);

        // Read
        Etudiant fetchedEtudiant = etudiantRepository.findById(etudiant.getId()).orElse(null);
        assertNotNull(fetchedEtudiant);
        assertEquals("John", fetchedEtudiant.getNom());
        assertEquals(25, fetchedEtudiant.getAge());

        // Update
        fetchedEtudiant.setNom("Jane");
        etudiantRepository.save(fetchedEtudiant);
        Etudiant updatedEtudiant = etudiantRepository.findById(etudiant.getId()).orElse(null);
        assertNotNull(updatedEtudiant);
        assertEquals("Jane", updatedEtudiant.getNom());

        // Delete
        etudiantRepository.delete(updatedEtudiant);
        Etudiant deletedEtudiant = etudiantRepository.findById(etudiant.getId()).orElse(null);
        assertEquals(null, deletedEtudiant);
    }
}