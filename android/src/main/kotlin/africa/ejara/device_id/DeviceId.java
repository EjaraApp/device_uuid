package africa.ejara.device_id;

import android.os.Build;

import java.util.UUID;

public class DeviceId {
    public static String getUniquePseudoID() {
        String devIdShort = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        // Only devices with API >= 9 have android.os.Build.SERIAL
        // If a user upgrades software or roots their device, there will be a duplicate entry
        String serial = null;
        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();

            // Go ahead and return the serial for api => 9
            return formatUUID(new UUID(devIdShort.hashCode(), serial.hashCode()).toString());
        } catch (Exception exception) {
            // String needs to be initialized
            serial = "axions";
        }

        // Finally, combine the values we have found by using the UUID class to create a unique identifier
        return formatUUID(new UUID(devIdShort.hashCode(), serial.hashCode()).toString());
    }

    private static String formatUUID(String uuid) {
        return uuid.replaceAll("-", "");
    }
}
