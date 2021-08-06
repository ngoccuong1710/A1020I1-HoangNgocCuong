package vn.codegym.furama_resort.service;

import vn.codegym.furama_resort.model.Position;

public interface PositionService {
    Iterable<Position> findAll();
}
