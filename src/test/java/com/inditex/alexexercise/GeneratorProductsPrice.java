package com.inditex.alexexercise;

import com.inditex.alexexercise.domain.model.ProductsPriceLast;

import java.time.LocalDateTime;

public class GeneratorProductsPrice {

    public static ProductsPriceLast generateProductsPrice() {
        return generateProductsPriceLast();
    }

    private static ProductsPriceLast generateProductsPriceLast() {
        return ProductsPriceLast.builder()
                .brandId(1L)
                .productId(35455L)
                .appDate(LocalDateTime.parse("2020-10-31T23:59:59")).build();
    }

    public static ProductsPriceLast generateProductsPriceSequence(String localDateTime) {
        return generateProductsPriceLastSequence(localDateTime);
    }

    private static ProductsPriceLast generateProductsPriceLastSequence(String localDateTime) {
        return ProductsPriceLast.builder()
                .brandId(1L)
                .productId(35455L)
                .appDate(LocalDateTime.parse(localDateTime)).build();
    }
}
