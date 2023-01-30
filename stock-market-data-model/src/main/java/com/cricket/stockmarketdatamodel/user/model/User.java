package com.cricket.stockmarketdatamodel.user.model;

import com.cricket.stockmarketdatamodel.player.model.BaseBean;
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
