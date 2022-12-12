package com.inditex.alexexercise.ports;

import com.inditex.alexexercise.domain.model.ProductsPriceLast;
import com.inditex.alexexercise.domain.model.ProductsPriceLastResponse;
import reactor.core.publisher.Mono;

public interface PriceService {

    Mono<ProductsPriceLastResponse> getProductPriceLast(ProductsPriceLast productsPriceLast);
}
