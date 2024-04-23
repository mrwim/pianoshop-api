package nl.inholland.pianoshopapi.repository;

import nl.inholland.pianoshopapi.model.Piano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PianoRepository extends JpaRepository<Piano, Long> {
}
