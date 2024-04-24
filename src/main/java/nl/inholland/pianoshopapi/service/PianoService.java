package nl.inholland.pianoshopapi.service;

import jakarta.persistence.EntityNotFoundException;
import nl.inholland.pianoshopapi.model.Brand;
import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.dto.PianoDTO;
import nl.inholland.pianoshopapi.repository.PianoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PianoService {

    private PianoRepository pianoRepository;
    private BrandService brandService;

    public PianoService(PianoRepository pianoRepository, BrandService brandService) {
        this.pianoRepository = pianoRepository;
        this.brandService = brandService;
    }

    public List<Piano> getAllPianos() {
        return pianoRepository.findAll();
    }

    public Piano addPiano(PianoDTO pianoDTO) {
        Brand brand = Optional.ofNullable(
                brandService.getBrandByName(pianoDTO.brand()
                )).orElseThrow(() -> new EntityNotFoundException("No such Brand"));
        Piano piano = new Piano();
        piano.setBrand(brand);
        piano.setModel(pianoDTO.model());
        piano.setYear(pianoDTO.year());
        return pianoRepository.save(piano);
    }
}
