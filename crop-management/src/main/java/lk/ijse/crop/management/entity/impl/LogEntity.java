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
@Table(name = "Logs")
public class LogEntity implements SuperEntity {
    @Id
    private String logCode;
    private String logDate;
    private String logDetails;
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String logImage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fieldCode", nullable = false)
    private FieldEntity field;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cropCode", nullable = false)
    private CropEntity crop;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staffID", nullable = false)
    private StaffEntity staff;
}
