package lk.ijse.crop.management.service;

import lk.ijse.crop.management.dto.impl.CropDTO;
import lk.ijse.crop.management.dto.impl.LogDTO;

import java.util.List;

public interface LogService {
    void saveLogs(LogDTO logDTO);
    void deleteLogs(String logID);
}
