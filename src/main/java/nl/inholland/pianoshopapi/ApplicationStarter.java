package nl.inholland.pianoshopapi;

import nl.inholland.pianoshopapi.model.Brand;
import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.Stock;
import nl.inholland.pianoshopapi.repository.BrandRepository;
import nl.inholland.pianoshopapi.repository.PianoRepository;
import nl.inholland.pianoshopapi.repository.StockRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationStarter implements ApplicationRunner {

    private PianoRepository pianoRepository;
    private StockRepository stockRepository;
    private BrandRepository brandRepository;

    public ApplicationStarter(PianoRepository pianoRepository, StockRepository stockRepository, BrandRepository brandRepository) {
        this.pianoRepository = pianoRepository;
        this.stockRepository = stockRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Brand yamaha = new Brand("Yamaha", "Japan");
        brandRepository.save(yamaha);
        Piano piano = new Piano(yamaha, "A1", 1993);
        pianoRepository.save(piano);
        Stock stock = new Stock(piano, 15);
        stockRepository.save(stock);
    }
}
