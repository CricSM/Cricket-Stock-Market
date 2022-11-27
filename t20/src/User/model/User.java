package User.model;

import Player.model.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User extends BaseBean {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Long accountNumber;
    private int age;
    private Address address;
    private boolean isKycCompleted;
}
