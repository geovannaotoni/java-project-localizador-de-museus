package com.betrybe.museumfinder.solution;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Testes para a camada de serviço do Museu")
public class MuseumServiceTest {

  @Mock
  private MuseumFakeDatabase mockDatabase;

  @InjectMocks
  private MuseumService service;

  @Test
  @DisplayName("Retorna o museu quando recebe um id válido")
  public void getMuseumSuccessfullyTest() {
    Long museumId = 1L;
    Museum expectedMuseum = new Museum();

    when(mockDatabase.getMuseum(museumId)).thenReturn(Optional.of(expectedMuseum));

    Museum result = service.getMuseum(museumId);

    assertSame(expectedMuseum, result);
  }

  @Test
  @DisplayName("Retorna o museu quando recebe um id válido")
  public void getMuseumNullTest() {
    Long museumId = 99999L;

    when(mockDatabase.getMuseum(museumId)).thenReturn(Optional.empty());

    Museum result = service.getMuseum(museumId);

    assertEquals(null, result);
  }
}
