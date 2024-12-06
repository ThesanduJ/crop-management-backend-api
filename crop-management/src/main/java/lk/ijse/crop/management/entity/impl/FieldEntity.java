package lk.ijse.crop.management.entity.impl;

import jakarta.persistence.*;
import lk.ijse.crop.management.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private String fieldExtentSize;
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String fieldImage01;
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String fieldImage02;

    @ManyToMany
    @JoinTable(name = "field_crop", joinColumns = @JoinColumn(name = "field_code"), inverseJoinColumns = @JoinColumn(name = "crop_code"))
    private List<CropEntity> crops;
    @OneToMany(mappedBy = "field")
    private List<EquipmentEntity> equipmentList;
    @OneToMany(mappedBy = "field")
    private List<LogEntity> logs;

}
