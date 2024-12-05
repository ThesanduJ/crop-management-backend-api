package lk.ijse.crop.management.controller;

import lk.ijse.crop.management.dto.impl.EquipmentDTO;
import lk.ijse.crop.management.exceptions.DataPersisException;
import lk.ijse.crop.management.service.EquipmentService;
import lk.ijse.crop.management.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(
            @RequestPart("equipmentName") String equipmentName,
            @RequestPart("equipmentType") String equipmentType,
            @RequestPart("equipmentStatus") String  equipmentStatus

    ){
        try{
            String equipmentID= AppUtil.generateEquipmentID();

            EquipmentDTO equipmentDTO = new EquipmentDTO();
            equipmentDTO.setEquipmentID(equipmentID);
            equipmentDTO.setEquipmentName(equipmentName);
            equipmentDTO.setEquipmentType(equipmentType);
            equipmentDTO.setEquipmentStatus(equipmentStatus);

            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (DataPersisException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
