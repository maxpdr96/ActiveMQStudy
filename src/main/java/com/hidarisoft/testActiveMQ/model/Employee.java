package com.hidarisoft.testActiveMQ.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;

    private String employeeFirstName;
    private String employeeFullName;
    private String employeeId;
    private String employeeLastName;
    private String employeeMiddleName;
}
