package nl.inholland.pianoshopapi.service;

import nl.inholland.pianoshopapi.model.Brand;
import nl.inholland.pianoshopapi.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandByName(String name) {
        return brandRepository.findByName(name);
    }
}
