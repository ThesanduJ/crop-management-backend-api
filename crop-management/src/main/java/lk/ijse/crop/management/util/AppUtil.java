package lk.ijse.crop.management.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String profilePicToBase64(byte[] profilePic) {
        return Base64.getEncoder().encodeToString(profilePic);
    }
    public static String generateCropID(){
        String uuid = UUID.randomUUID().toString();
        String shortUUID = uuid.substring(0, 5); // Take the first 8 characters of the UUID
        return "CROP-" + shortUUID;
    }
    public static String generateStaffID(){
        String uuid = UUID.randomUUID().toString();
        String shortUUID = uuid.substring(0, 5); // Take the first 8 characters of the UUID
        return "STAFF-" + shortUUID;
    }
    public static String generateLogID(){
        String uuid = UUID.randomUUID().toString();
        String shortUUID = uuid.substring(0, 5); // Take the first 8 characters of the UUID
        return "LOG-" + shortUUID;
    }
    public static String generateVehicleID(){
        String uuid = UUID.randomUUID().toString();
        String shortUUID = uuid.substring(0, 5); // Take the first 8 characters of the UUID
        return "VEHICLE-" + shortUUID;
    }
    public static String generateEquipmentID(){
        String uuid = UUID.randomUUID().toString();
        String shortUUID = uuid.substring(0, 5); // Take the first 8 characters of the UUID
        return "TOOL-" + shortUUID;
    }
    public static String generateFieldID(){
        String uuid = UUID.randomUUID().toString();
        String shortUUID = uuid.substring(0, 5); // Take the first 8 characters of the UUID
        return "FIELD-" + shortUUID;
    }
}
