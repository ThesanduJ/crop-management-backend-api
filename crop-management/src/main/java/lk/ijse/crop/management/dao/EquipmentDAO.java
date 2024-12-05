package lk.ijse.crop.management.dao;

import lk.ijse.crop.management.entity.impl.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDAO extends JpaRepository<EquipmentEntity,String> {
}
