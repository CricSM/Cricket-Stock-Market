package com.cricket.stockmarketdatamodel.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String line1;
    private String line2;
    private String city;
    private String country;
    private String zipCode;
}
