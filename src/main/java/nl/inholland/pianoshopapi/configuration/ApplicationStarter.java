package nl.inholland.pianoshopapi.configuration;

import jakarta.transaction.Transactional;
import nl.inholland.pianoshopapi.model.Brand;
import nl.inholland.pianoshopapi.model.BrandDTO;
import nl.inholland.pianoshopapi.model.PianoDTO;
import nl.inholland.pianoshopapi.service.BrandService;
import nl.inholland.pianoshopapi.service.PianoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class ApplicationStarter implements ApplicationRunner {

    private PianoService pianoService;
    private BrandService brandService;

    public ApplicationStarter(PianoService pianoService, BrandService brandService) {
        this.pianoService = pianoService;
        this.brandService = brandService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BrandDTO yamaha = new BrandDTO("Yamaha", "Great pianos from Japan");
        BrandDTO steinway = new BrandDTO("Steinway & Sons", "Classic pianos from Germany");

        Brand savedYamaha = brandService.save(yamaha);
        Brand savedSteinway = brandService.save(steinway);
        List<PianoDTO> pianos = List.of(
                new PianoDTO("Yamaha", "A3", 2013),
                new PianoDTO("Steinway & Sons", "A-188 PE", 2009)
        );

        pianos.forEach(piano -> pianoService.addPiano(new PianoDTO(piano.brand(), piano.model(), piano.year())));

        pianoService.getAllPianos().forEach(piano -> System.out.println(piano.getBrand() + " " + piano.getModel() + " " + piano.getYear()));
    }
}
