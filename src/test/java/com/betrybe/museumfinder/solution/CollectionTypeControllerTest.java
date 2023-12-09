package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes para a CollectionTypeController")
public class CollectionTypeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CollectionTypeService  service;

  @Test
  @DisplayName("Retorna o número de museus cujo tipo de coleção contém os tipos especificados")
  public void getCollectionTypesCountTest() throws Exception {
    String typesList = "hist,imag";
    String[] collectionTypes = {"hist", "imag"};

    Mockito.when(service.countByCollectionTypes(typesList))
            .thenReturn(new CollectionTypeCount(collectionTypes, 492));

    mockMvc.perform(get("/collections/count/{typesList}", typesList))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.count").value(492))
        .andExpect(jsonPath("$.collectionTypes").isArray())
        .andExpect(jsonPath("$.collectionTypes", Matchers.containsInAnyOrder("hist", "imag")));
  }

  @Test
  @DisplayName("Retorna o número de museus cujo tipo de coleção contém os tipos especificados")
  public void notFoundCollectionTypesCountTest() throws Exception {
    String typesList = "not,found";
    String[] collectionTypes = {"not", "found"};

    Mockito.when(service.countByCollectionTypes(typesList))
        .thenReturn(new CollectionTypeCount(collectionTypes, 0));

    mockMvc.perform(get("/collections/count/{typesList}", typesList))
        .andExpect(status().isNotFound());
  }
}
