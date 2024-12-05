package lk.ijse.crop.management.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.crop.management.dao.EquipmentDAO;
import lk.ijse.crop.management.dto.impl.EquipmentDTO;
import lk.ijse.crop.management.entity.impl.EquipmentEntity;
import lk.ijse.crop.management.exceptions.DataPersisException;
import lk.ijse.crop.management.service.EquipmentService;
import lk.ijse.crop.management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDAO equipmentDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        EquipmentEntity saveEquipment=equipmentDAO.save(mapping.toEquipmentEntity(equipmentDTO));
        if (saveEquipment==null){
            throw new DataPersisException("Equipment not saved");
        }
    }
}
