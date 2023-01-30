package com.cricket.stockmarketdatamodel.player.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStock extends BaseBean {
    private String noOfStock;
    private String debutValue;
    private String currentValue;
    private String noOfStockLeft;
}
