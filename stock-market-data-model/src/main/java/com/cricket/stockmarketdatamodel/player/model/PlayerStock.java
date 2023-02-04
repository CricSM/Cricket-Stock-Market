package com.cricket.stockmarketdatamodel.player.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class PlayerStock extends BaseBean {
    private Long noOfStock;
    private BigDecimal debutValue;
    private BigDecimal currentValue;
    private Long noOfStockLeft;
}
