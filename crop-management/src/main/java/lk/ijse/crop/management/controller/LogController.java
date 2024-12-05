package lk.ijse.crop.management.controller;

import lk.ijse.crop.management.dto.impl.LogDTO;
import lk.ijse.crop.management.exceptions.DataPersisException;
import lk.ijse.crop.management.service.LogService;
import lk.ijse.crop.management.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLogs(
            @RequestPart("logDate") String logDate,
            @RequestPart("logDetails") String logDetails,
            @RequestPart("logImage") MultipartFile logImage
    ) {
        // profilePic ----> Base64
        String base64ProPic = "";
        try {
            byte[] bytesProPic = logImage.getBytes();
            base64ProPic = AppUtil.profilePicToBase64(bytesProPic);
            String logCode=AppUtil.generateLogID();

            LogDTO logDTO = new LogDTO();

            logDTO.setLogCode(logCode);
            logDTO.setLogDate(logDate);
            logDTO.setLogDetails(logDetails);
            logDTO.setLogImage(base64ProPic);

            logService.saveLogs(logDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataPersisException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
