package lk.ijse.crop.management.service.impl;

import lk.ijse.crop.management.dao.VehicleDAO;
import lk.ijse.crop.management.dto.impl.VehicleDTO;
import lk.ijse.crop.management.entity.impl.VehicleEntity;
import lk.ijse.crop.management.exceptions.DataPersisException;
import lk.ijse.crop.management.service.VehicleService;
import lk.ijse.crop.management.util.Mapping;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        VehicleEntity saveVehicle=vehicleDAO.save(mapping.toVehicleEntity(vehicleDTO));
        if (saveVehicle==null){
            throw new DataPersisException("Vehicle Not Saved");
        }
    }
}
