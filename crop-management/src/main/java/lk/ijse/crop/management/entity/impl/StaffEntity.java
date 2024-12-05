package lk.ijse.crop.management.entity.impl;

import jakarta.persistence.*;
import lk.ijse.crop.management.entity.Gender;
import lk.ijse.crop.management.entity.Role;
import lk.ijse.crop.management.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity implements SuperEntity {
    @Id
    private String staffID;
    private String staffFName;
    private String staffLName;
    private String designation;
    private Gender gender;
    @Column(columnDefinition = "Date")
    private String joinedDate;
    @Column(columnDefinition = "Date")
    private String dob;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    @Column(unique = true, nullable = false)
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String email;
    private Role role;

    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private FieldEntity field;
    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    private List<VehicleEntity> vehicles;
    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    private List<EquipmentEntity> equipments;
    @OneToMany(mappedBy="staff",cascade = CascadeType.ALL)
    private List <LogEntity> logs;
}
