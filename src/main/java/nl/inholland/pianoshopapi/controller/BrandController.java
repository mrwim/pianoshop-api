package nl.inholland.pianoshopapi.controller;

import nl.inholland.pianoshopapi.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brands")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllBrands() {
        return ResponseEntity.status(200).body(brandService.getAllBrands());
    }
}
