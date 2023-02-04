package com.cricket.stockmarketdatamodel.player.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseBean {
    private String id;
    private String createdTime;
    private boolean deleted;
    private String modifiedTime;
    private String version;
}
