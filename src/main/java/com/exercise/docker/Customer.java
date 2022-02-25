package com.exercise.docker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

    private String customerid;
    private String firstName;
    private String surname;
    private String shipping_state;

}
