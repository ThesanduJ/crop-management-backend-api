package lk.ijse.crop.management.dto.impl;

import lk.ijse.crop.management.entity.Gender;
import lk.ijse.crop.management.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO {
    private String staffID;
    private String staffFName;
    private String staffLName;
    private String designation;
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private Role role;
}
