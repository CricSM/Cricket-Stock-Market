package com.cricket.stockmarketdatamodel.player.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Date {
    private String year;
    private String month;
    private String day;
}
