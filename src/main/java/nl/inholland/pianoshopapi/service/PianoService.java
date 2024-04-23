package nl.inholland.pianoshopapi.service;

import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.PianoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.random.RandomGenerator;

@Service
public class PianoService {

    private List<Piano> pianos;

    private RandomGenerator randomGenerator;

    public PianoService(List<Piano> allPianos, RandomGenerator randomGenerator) {
        this.pianos = allPianos;
        this.randomGenerator = randomGenerator;
    }

    public List<Piano> getAllPianos() {
        return pianos;
    }

    public Piano getPianoById(long id) {
        return pianos.stream()
                .filter(piano -> piano.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Piano addPiano(PianoDTO pianoDTO) {
        Piano piano = new Piano(
                randomGenerator.nextLong(),
                pianoDTO.brand(),
                pianoDTO.model(),
                pianoDTO.year()
        );
        pianos.add(piano);
        return piano;
    }

    public Piano updatePiano(long id, PianoDTO pianoDTO) {
        Piano piano = pianos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        piano.setBrand(pianoDTO.brand());
        piano.setModel(pianoDTO.model());
        piano.setYear(pianoDTO.year());
        return piano;
    }

    public void deletePiano(long id) {
        pianos.removeIf(piano -> piano.getId() == id);
    }
}
