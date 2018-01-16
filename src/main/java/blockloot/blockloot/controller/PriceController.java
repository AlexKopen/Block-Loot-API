package blockloot.blockloot.controller;

import blockloot.blockloot.model.Price;
import blockloot.blockloot.model.PriceHistoryRequest;
import blockloot.blockloot.repository.PriceRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PriceController {
    @Autowired
    private PriceRepository priceRepository;

    @GetMapping("/prices")
    public List<Price> getAllPrices() {
        return this.priceRepository.findAll();
    }

    @GetMapping("/time-range")
    public List<Price> custom(@RequestBody String body) {
        Gson g = new Gson();
        PriceHistoryRequest priceHistoryRequest = g.fromJson(body, PriceHistoryRequest.class);

        return this.priceRepository.getBySmbolAndDateRange(Arrays.asList(priceHistoryRequest.symbols), priceHistoryRequest.startDate,
                priceHistoryRequest.endDate);
    }
}
