package nl.inholland.pianoshopapi.service;

import jakarta.persistence.EntityNotFoundException;
import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.PianoDTO;
import nl.inholland.pianoshopapi.repository.PianoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PianoService {
    private PianoRepository pianoRepository;

    public PianoService(PianoRepository pianoRepository) {
        this.pianoRepository = pianoRepository;
    }

    public List<Piano> getAllPianos() {
        return pianoRepository.findAll();
    }

    public Piano getPianoById(long id) {
        return pianoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guitar not found"));
    }

    public Piano addPiano(PianoDTO pianoDTO) {
        Piano piano = new Piano(
                pianoDTO.brand(),
                pianoDTO.model(),
                pianoDTO.year()
        );
        pianoRepository.save(piano);
        return piano;
    }

    public Piano updatePiano(long id, PianoDTO pianoDTO) {
        Piano piano = pianoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Piano not found"));
        piano.setBrand(pianoDTO.brand());
        piano.setModel(pianoDTO.model());
        piano.setYear(pianoDTO.year());
        return piano;
    }

    public void deletePiano(long id) {
        pianoRepository.deleteById(id);
    }
}
