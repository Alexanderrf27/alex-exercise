package com.inditex.alexexercise.service;

import com.inditex.alexexercise.AlexExerciseApplication;
import com.inditex.alexexercise.GeneratorProductsPrice;
import com.inditex.alexexercise.domain.model.ProductsPriceLast;
import com.inditex.alexexercise.domain.model.ProductsPriceLastResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static com.inditex.alexexercise.adapter.ControllerAPIPaths.BASE_PATH;
import static com.inditex.alexexercise.adapter.ControllerAPIPaths.POST;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(
        classes = AlexExerciseApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    private static WebTestClient client;

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        client
                = WebTestClient
                .bindToApplicationContext(context)
                .configureClient()
                .baseUrl(BASE_PATH)
                .build();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testGetProductPrice1_thenReturnPriceResponse() {
        String localDateTime = "2020-12-31T23:59:59";
        ProductsPriceLast item = GeneratorProductsPrice.generateProductsPriceSequence(localDateTime);

        val result = client
                .post()
                .uri(POST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(item), ProductsPriceLast.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.productId")
                .isEqualTo(35455).
                jsonPath("$.brandId")
                .isEqualTo(1L).
                jsonPath("$.rateToApply")
                .isEqualTo(4L)
                .jsonPath("$.priceApplicationDates")
                .isEqualTo(localDateTime)
                .jsonPath("$.finalPrice")
                .isEqualTo(38.95);


        assertThat(result.returnResult().getResponseBody()).isNotNull();

    }

    @Test
    void testGetProductPrice2_thenReturnPriceResponse() {
        String localDateTime = "2020-06-14T10:00:00";
        ProductsPriceLastResponse response = ProductsPriceLastResponse
                .builder()
                .priceApplicationDates(LocalDateTime.parse("2020-12-31T23:59:59"))
                .productId(35455L)
                .finalPrice(35.5)
                .brandId(1L)
                .rateToApply(1L)
                .build();

        ProductsPriceLast item = GeneratorProductsPrice
                .generateProductsPriceSequence(localDateTime);

        thenReturnPriceResponse(response, item);
    }

    @Test
    void testGetProductPrice3_thenReturnPriceResponse() {
        String localDateTime = "2020-06-14T16:00:00";
        ProductsPriceLastResponse response = ProductsPriceLastResponse
                .builder()
                .productId(35455L)
                .finalPrice(25.45)
                .brandId(1L)
                .rateToApply(2L)
                .build();

        ProductsPriceLast item = GeneratorProductsPrice
                .generateProductsPriceSequence(localDateTime);

        thenReturnPriceResponse(response, item,"2020-06-14T18:30:00");
    }

    @Test
    void testGetProductPrice4_thenReturnPriceResponse() {
        String localDateTime = "2020-06-14T21:00:00";
        ProductsPriceLastResponse response = ProductsPriceLastResponse.builder()
                .priceApplicationDates(LocalDateTime.parse("2020-12-31T23:59:59"))
                .productId(35455L)
                .finalPrice(35.5)
                .brandId(1L)
                .rateToApply(1L)
                .build();

        ProductsPriceLast item = GeneratorProductsPrice
                .generateProductsPriceSequence(localDateTime);

        thenReturnPriceResponse(response, item);
    }

    @Test
    void testGetProductPrice5_thenReturnPriceResponse() {
        String localDateTime = "2020-06-15T10:00:00";
        ProductsPriceLastResponse response = ProductsPriceLastResponse.builder()
                .productId(35455L)
                .finalPrice(30.5)
                .brandId(1L)
                .rateToApply(3L)
                .build();

        ProductsPriceLast item = GeneratorProductsPrice
                .generateProductsPriceSequence(localDateTime);

        thenReturnPriceResponse(response, item, "2020-06-15T11:00:00");
    }


    /**
     * @param priceLast
     */
    void thenReturnPriceResponse(ProductsPriceLastResponse response, ProductsPriceLast priceLast) {
        val result = client
                .post()
                .uri(POST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(priceLast), ProductsPriceLast.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.productId")
                .isEqualTo(response.getProductId()).
                jsonPath("$.brandId")
                .isEqualTo(response.getBrandId()).
                jsonPath("$.rateToApply")
                .isEqualTo(response.getRateToApply())
                .jsonPath("$.priceApplicationDates")
                .isEqualTo(String.valueOf(response.getPriceApplicationDates()))
                .jsonPath("$.finalPrice")
                .isEqualTo(response.getFinalPrice());

        assertThat(result.returnResult().getResponseBody()).isNotNull();
    }

    void thenReturnPriceResponse(ProductsPriceLastResponse response, ProductsPriceLast priceLast, String date) {
        val result = client
                .post()
                .uri(POST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(priceLast), ProductsPriceLast.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.productId")
                .isEqualTo(response.getProductId()).
                jsonPath("$.brandId")
                .isEqualTo(response.getBrandId()).
                jsonPath("$.rateToApply")
                .isEqualTo(response.getRateToApply())
                .jsonPath("$.priceApplicationDates")
                .isEqualTo(date)
                .jsonPath("$.finalPrice")
                .isEqualTo(response.getFinalPrice());

        assertThat(result.returnResult().getResponseBody()).isNotNull();
    }


}

