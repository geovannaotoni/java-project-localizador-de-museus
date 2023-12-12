package com.betrybe.museumfinder.solution;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("Testes para a camada de serviço do Museu")
public class MuseumServiceTest {

//  @Mock
//  private MuseumFakeDatabase mockDatabase;
//
//  @InjectMocks
//  private MuseumService service;

  @MockBean
  private MuseumFakeDatabase mockDatabase;

  @Autowired
  private MuseumService service;

  @Test
  @DisplayName("Retorna o museu quando recebe um id válido")
  public void getMuseumSuccessfullyTest() {
    Long museumId = 1L;
    Museum expectedMuseum = new Museum();

    when(mockDatabase.getMuseum(museumId)).thenReturn(Optional.of(expectedMuseum));

    Museum result = service.getMuseum(museumId);

    assertNotNull(result);
    assertSame(expectedMuseum, result);
    verify(mockDatabase).getMuseum(eq(museumId));
  }

  @Test
  @DisplayName("Lança uma exception quando recebe um id inválido")
  public void getMuseumNullTest() {
    Long museumId = 99999L;

    when(mockDatabase.getMuseum(museumId)).thenReturn(Optional.empty());

    //    Museum result = service.getMuseum(museumId);

    //    assertNull(result);
    assertThrows(MuseumNotFoundException.class, () -> {
      service.getMuseum(museumId);
    });
  }
}
