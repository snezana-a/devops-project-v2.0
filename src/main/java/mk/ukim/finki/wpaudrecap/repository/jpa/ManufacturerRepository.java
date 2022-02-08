package mk.ukim.finki.wpaudrecap.repository.jpa;

import mk.ukim.finki.wpaudrecap.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {


}
