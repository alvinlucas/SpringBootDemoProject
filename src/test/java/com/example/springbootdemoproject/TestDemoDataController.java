package com.example.springbootdemoproject;

import com.exemple.springbootdemoproject.model.Etudiant;
import com.exemple.springbootdemoproject.repository.EtudiantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestDemoDataController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EtudiantRepository etudiantRepository;

    @BeforeEach
    public void setup() {
        Etudiant etudiant = new Etudiant("John Doe", 20);
        etudiant.setId(1);
        when(etudiantRepository.findById(1)).thenReturn(Optional.of(etudiant));
    }

    @Test
    public void testGetEtudiant() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/etudiants/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}