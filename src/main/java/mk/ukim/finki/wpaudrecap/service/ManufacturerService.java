package mk.ukim.finki.wpaudrecap.service;

import mk.ukim.finki.wpaudrecap.model.Manufacturer;
import mk.ukim.finki.wpaudrecap.repository.jpa.ManufacturerRepository;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> save(String name, String address);
    void deleteById(Long id);
}
