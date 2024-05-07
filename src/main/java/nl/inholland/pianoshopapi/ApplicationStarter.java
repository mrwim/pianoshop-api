package nl.inholland.pianoshopapi;

import nl.inholland.pianoshopapi.model.Brand;
import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.Role;
import nl.inholland.pianoshopapi.model.Stock;
import nl.inholland.pianoshopapi.model.User;
import nl.inholland.pianoshopapi.repository.BrandRepository;
import nl.inholland.pianoshopapi.repository.PianoRepository;
import nl.inholland.pianoshopapi.repository.StockRepository;
import nl.inholland.pianoshopapi.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApplicationStarter implements ApplicationRunner {

    private PianoRepository pianoRepository;
    private StockRepository stockRepository;
    private BrandRepository brandRepository;
    private UserService userService;

    public ApplicationStarter(PianoRepository pianoRepository, StockRepository stockRepository, BrandRepository brandRepository, UserService userService) {
        this.pianoRepository = pianoRepository;
        this.stockRepository = stockRepository;
        this.brandRepository = brandRepository;
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Brand yamaha = new Brand("Yamaha", "Japan");
        brandRepository.save(yamaha);
        Piano piano = new Piano(yamaha, "A1", 1993);
        pianoRepository.save(piano);
        Stock stock = new Stock(piano, 15);
        stockRepository.save(stock);
        User user = userService.createUser(new User(1, "admin", "admin", List.of(Role.ADMIN_ROLE)));
        userService.getUsers().forEach(System.out::println);
    }


}
