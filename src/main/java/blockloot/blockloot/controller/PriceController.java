package blockloot.blockloot.controller;

import blockloot.blockloot.model.Price;
import blockloot.blockloot.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceController {
    @Autowired
    private PriceRepository priceRepository;

    // Get All Prices
    @GetMapping("/prices")
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    // Get All Prices
    @GetMapping("/time-range")
    public List<Price> custom(@RequestParam("symbol") String symbol, @RequestParam("start-date") String startDate, @RequestParam("end-date") String endDate) {
        symbol = symbol.isEmpty() ? "btc" : symbol;
        startDate = startDate.isEmpty() ? "2000-01-01" : startDate;
        endDate = endDate.isEmpty() ? "2100-01-01" : endDate;

        return priceRepository.getBySmbolAndDateRange(symbol, startDate, endDate);
    }
}
