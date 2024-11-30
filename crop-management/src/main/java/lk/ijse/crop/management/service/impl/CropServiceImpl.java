package lk.ijse.crop.management.service.impl;

import lk.ijse.crop.management.dao.CropDAO;
import lk.ijse.crop.management.dto.impl.CropDTO;
import lk.ijse.crop.management.entity.impl.CropEntity;
import lk.ijse.crop.management.exceptions.DataPersisException;
import lk.ijse.crop.management.service.CropService;
import lk.ijse.crop.management.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CropServiceImpl implements CropService {
    @Autowired
    private CropDAO cropDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveCrop(CropDTO cropDTO) {
        CropEntity saveCrop=cropDAO.save(mapping.toCropEntity(cropDTO));
        if (saveCrop==null){
            throw new DataPersisException("Crop not saved");
        }
    }
}
