package lk.ijse.crop.management.service.impl;

import lk.ijse.crop.management.dao.LogDAO;
import lk.ijse.crop.management.dao.StaffDAO;
import lk.ijse.crop.management.dto.impl.LogDTO;
import lk.ijse.crop.management.entity.impl.LogEntity;
import lk.ijse.crop.management.exceptions.DataPersisException;
import lk.ijse.crop.management.service.LogService;
import lk.ijse.crop.management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveLogs(LogDTO logDTO) {
        LogEntity saveLog=logDAO.save(mapping.toLogEntity(logDTO));
        if (saveLog==null){
            throw new DataPersisException("Logs Not Saved");
        }
    }


}
