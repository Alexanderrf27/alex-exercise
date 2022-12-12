package com.inditex.alexexercise.adapter;


import com.inditex.alexexercise.domain.model.ProductsPriceLast;
import com.inditex.alexexercise.domain.model.ProductsPriceLastResponse;
import com.inditex.alexexercise.ports.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 */
@RestController
@RequestMapping(ControllerAPIPaths.BASE_PATH)
public class ProductController {

    private final PriceService priceService;

    @Autowired
    public ProductController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Operation(description = "In the company's e-commerce database we have the PRICES table that reflects the final price (pvp) and the rate that applies to a product in a chain between certain dates")
    @PostMapping(ControllerAPIPaths.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<ProductsPriceLastResponse>> getPriceLast(@RequestBody ProductsPriceLast productsPriceLast) {
        return priceService.getProductPriceLast(productsPriceLast)
                .map(lastResponse -> new ResponseEntity<>(lastResponse, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
