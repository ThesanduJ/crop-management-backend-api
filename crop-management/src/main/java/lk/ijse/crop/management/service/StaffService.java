package lk.ijse.crop.management.service;

import lk.ijse.crop.management.dto.impl.StaffDTO;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    void deleteStaff(String staffID);
}
