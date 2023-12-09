package com.betrybe.museumfinder.solution;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Testes para a CollectionTypeService")
public class CollectionTypeServiceTest {

  @Mock
  private MuseumFakeDatabase mockDatabase;

  @InjectMocks
  private CollectionTypeService collectionTypeService;

  @Test
  @DisplayName("Testa a função CollectionTypeService com apenas 1 tipo")
  public void countByCollectionTypesOneTypeTest() {
    String typesList = "hist";
    String[] collectionTypes = {"hist"};
    long count = 387;
    when(mockDatabase.countByCollectionType(typesList)).thenReturn(count);

    CollectionTypeCount result = collectionTypeService.countByCollectionTypes(typesList);
    assertEquals(1, result.collectionTypes().length);
    assertEquals(count, result.count());
  }

  @Test
  @DisplayName("Testa a função CollectionTypeService com mais de 1 tipo")
  public void countByCollectionTypesMultiplesTypeTest() {
    String typesList = "hist,imag";
    String[] collectionTypes = {"hist", "imag"};

    long[] count = {387, 105};
    long total = 492;
    for (int i = 0; i < collectionTypes.length; i += 1) {
      when(mockDatabase.countByCollectionType(collectionTypes[i])).thenReturn(count[i]);
    }

    CollectionTypeCount result = collectionTypeService.countByCollectionTypes(typesList);
    assertEquals(2, result.collectionTypes().length);
    assertEquals(total, result.count());
  }

}
