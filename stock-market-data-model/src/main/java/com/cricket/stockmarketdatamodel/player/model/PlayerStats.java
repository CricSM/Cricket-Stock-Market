package com.cricket.stockmarketdatamodel.player.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStats {
    private Long matchesPlayed;
    private Double battingAverage;
    private Double battingStrikeRate;
    private Double bowlingStrikeRate;
    private Double bowlingEconomy;
    private Format format;
}
