package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.controller.MuseumController;
import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.CollectionTypeService;
import com.betrybe.museumfinder.service.MuseumService;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes para a MuseumController")
public class MuseumControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Mock
  private MuseumServiceInterface museumService;

  @InjectMocks
  private MuseumController museumController;

  @Test
  @DisplayName("Testa a rota GET /museums/{id}")
  public void getMuseumByIdSuccessfullyTest() throws Exception {
    Long museumId = 1L;
    Museum expectedMuseum = new Museum();
    expectedMuseum.setId(museumId);
    expectedMuseum.setName("Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial");
    expectedMuseum.setDescription("Preservação da memória dos ex-combatentes da Segunda Guerra.");
    expectedMuseum.setAddress("SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF");
    expectedMuseum.setCollectionType("História");
    expectedMuseum.setSubject("História");
    expectedMuseum.setCoordinate(new Coordinate(-15.75063, -47.9001824));

    Mockito.when(museumService.getMuseum(museumId)).thenReturn(expectedMuseum);

    mockMvc.perform(get("/museums/{id}", museumId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial"))
        .andExpect(jsonPath("$.description").value("Preservação da memória dos ex-combatentes da Segunda Guerra."))
        .andExpect(jsonPath("$.address").value("SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF"));
  }
}
