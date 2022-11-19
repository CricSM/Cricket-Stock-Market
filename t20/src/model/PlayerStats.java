package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStats {
    private String matchesPlayed;
    private String battingAverage;
    private String battingStrikeRate;
    private String bowlingStrikeRate;
    private String bowlingEconomy;
    private FORMAT format;
}
