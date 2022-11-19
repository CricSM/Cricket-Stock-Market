package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Player {
    private String uniqueId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private Long debut;
    private Long lastMatch;
    private Format format;
    private PlayerType type;
    private Team nationalTeam;
    private String battingStyle;
    private String bowlingStyle;
}

