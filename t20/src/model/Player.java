package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Player {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private Date dODebut;
    private Date lastMatch;
    private FORMAT format;
    private PlayerType type;
    private TEAM nationalTeam;
    private String battingStyle;
    private String bowlingStyle;
}

