package lk.ijse.crop.management.service.impl;

import lk.ijse.crop.management.dao.StaffDAO;
import lk.ijse.crop.management.dto.impl.StaffDTO;
import lk.ijse.crop.management.entity.impl.StaffEntity;
import lk.ijse.crop.management.exceptions.DataPersisException;
import lk.ijse.crop.management.service.StaffService;
import lk.ijse.crop.management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
        StaffEntity saveStaff=staffDAO.save(mapping.toStaffEntity(staffDTO));
        if (saveStaff==null){
            throw new DataPersisException("Staff Not Saved");
        }
    }

    @Override
    public void deleteStaff(String staffID) {
        Optional<StaffEntity> staffExists =staffDAO.findById(staffID);
        if (!staffExists.isPresent()){
            throw new DataPersisException("Staff with ID " + staffID + " Not Found");
        }else {
            staffDAO.deleteById(staffID);
        }
    }
}
