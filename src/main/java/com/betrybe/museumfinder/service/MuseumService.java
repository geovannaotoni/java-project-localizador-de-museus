package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Museum service.
 */
@Service
public class MuseumService implements MuseumServiceInterface {
  private MuseumFakeDatabase database;

  @Autowired
  public MuseumService(MuseumFakeDatabase database) {
    this.database = database;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    Boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(coordinate);
    if (!isCoordinateValid) {
      throw new InvalidCoordinateException();
    }

    Optional<Museum> museum = database.getClosestMuseum(coordinate, maxDistance);
    if (museum.isEmpty()) {
      throw new MuseumNotFoundException();
    }
    return museum.get();
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(museum.getCoordinate());
    if (!isCoordinateValid) {
      throw new InvalidCoordinateException();
    }
    return database.saveMuseum(museum);
  }

  @Override
  public Museum getMuseum(Long id) {
    Optional<Museum> museumOptional = database.getMuseum(id);
    if (museumOptional.isEmpty()) {
      return null;
    }
    return museumOptional.get();
  }
}
