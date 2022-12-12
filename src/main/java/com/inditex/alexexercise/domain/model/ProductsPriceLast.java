package com.inditex.alexexercise.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
public class ProductsPriceLast {

    @Schema(description = "Group chain id (1 = ZARA)")
    @NotNull
    @NotBlank(message = "brand Id is required")
    @Size(min = 1, max = 1)
    private Long brandId;

    @NotNull
    @NotBlank(message = "product Id  is required")
    @Size(min = 5, max = 6)
    @Schema(description = "Represents product identifier")
    private Long productId;

    @NotNull
    @NotBlank(message = "brand Id is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Represents application date")
    private LocalDateTime appDate;

}
