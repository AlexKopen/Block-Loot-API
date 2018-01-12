package blockloot.blockloot.controller;

import blockloot.blockloot.model.Price;
import blockloot.blockloot.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceController {
    @Autowired
    PriceRepository priceRepository;

    // Get All Prices
    @GetMapping("/prices")
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }
}
