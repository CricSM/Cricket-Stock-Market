package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Player extends BaseBean{
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private Long debutDate;
    private Long lastMatchDate;
    private List<Format> format;
    private PlayerType type;
    private List<PlayerTeamStats> teamBasisStats;
    private String battingStyle;
    private String bowlingStyle;
}

