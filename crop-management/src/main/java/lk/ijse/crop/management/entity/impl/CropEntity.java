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
@Table(name = "crop")
public class CropEntity implements SuperEntity {
    @Id
    private String cropCode;
    @Column(unique = true,nullable = false)
    private String cropCommonName;
    @Column(unique = true,nullable = false)
    private String cropScientificName;
    @Column(columnDefinition = "LONGTEXT",nullable = false)
    private String cropImage;
    @Column(nullable = false)
    private String cropCategory;
    @Column(nullable = false)
    private String cropSeason;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fieldCode", nullable = false)
    private FieldEntity field;
    @OneToMany(mappedBy="crop",cascade = CascadeType.ALL)
    private List<LogEntity> logs;
}
