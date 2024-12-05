package lk.ijse.crop.management.entity.impl;

import jakarta.persistence.*;
import lk.ijse.crop.management.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity implements SuperEntity {
    @Id
    private String equipmentID;
    private String equipmentName;
    private String equipmentType;
    private String equipmentStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staffID")
    private StaffEntity staff;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fieldCode")
    private FieldEntity field;
}
