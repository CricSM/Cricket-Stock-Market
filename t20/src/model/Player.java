package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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
    private Date debutDate;
    private Date retireDate;
    private List<FORMAT> format;
    private PlayerType type;
    private TEAM nationalTeam;
    private String battingStyle;
    private String bowlingStyle;
}

