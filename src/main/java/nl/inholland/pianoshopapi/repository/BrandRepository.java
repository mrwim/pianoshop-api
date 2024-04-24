package nl.inholland.pianoshopapi.repository;

import nl.inholland.pianoshopapi.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    Brand findByName(String name);
}
