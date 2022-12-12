package com.inditex.alexexercise.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class ProductsPriceLastResponse {

    @Schema(description = "Represents product identifier")
    private Long productId;
    @Schema(description = "Group chain id (1 = ZARA)")
    private Long brandId;
    @Schema(description = "rate to apply to the product")
    private Long rateToApply;

    @Schema(description = "product price application dates")
    private LocalDateTime priceApplicationDates;

    @Schema(description = "final Price application")
    private Double finalPrice;



    @Override
    public String toString() {
        return "PriceLastResponse{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", rateToApply=" + rateToApply +
                ", priceApplicationDates=" + priceApplicationDates +
                ", finalPrice=" + finalPrice +
                '}';
    }

}
