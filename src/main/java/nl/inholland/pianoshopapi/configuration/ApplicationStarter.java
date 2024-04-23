package nl.inholland.pianoshopapi.configuration;

import nl.inholland.pianoshopapi.model.PianoDTO;
import nl.inholland.pianoshopapi.service.PianoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStarter implements ApplicationRunner {

    private PianoService pianoService;

    public ApplicationStarter(PianoService pianoService) {
        this.pianoService = pianoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<PianoDTO> pianos = List.of(
                new PianoDTO("Yamaha", "A3", 2013),
                new PianoDTO("Steinway & Sons", "A-188 PE", 2009)
        );

        pianos.forEach(piano -> pianoService.addPiano(new PianoDTO(piano.brand(), piano.model(), piano.year())));

        pianoService.getAllPianos().forEach(piano -> System.out.println(piano.getBrand() + " " + piano.getModel() + " " + piano.getYear()));
    }
}
