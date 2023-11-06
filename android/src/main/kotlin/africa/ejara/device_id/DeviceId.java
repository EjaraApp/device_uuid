package africa.ejara.device_id;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.UUID;

public class DeviceId {
    public static String getUniquePseudoID(Context context) {
        String serial = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String devIdShort = "35" +
                (Build.BOARD.length() % 10) +
                (Build.BRAND.length() % 10) +
                (Build.DEVICE.length() % 10) +
                (Build.MANUFACTURER.length() % 10) +
                (Build.MODEL.length() % 10) +
                (Build.PRODUCT.length() % 10);
        // UUID deviceUuid = new UUID(serial.hashCode(), devIdShort.hashCode());
        // return formatUUID(deviceUuid.toString());
        return formatUUID(serial + devIdShort);
    }

    public static String formatUUID(String shortString) {
        // Pad the string with zeros (or any other fixed value) to reach 32 characters
        String padded = shortString + "000000000000000000000000";
        // Take the first 32 characters of the padded string for UUID
        String hex = padded.substring(0, 32);

        // Split the string into the parts needed for a UUID
        long mostSigBits = Long.parseUnsignedLong(hex.substring(0, 16), 16);
        long leastSigBits = Long.parseUnsignedLong(hex.substring(16), 16);

        // Create a new UUID using the bits
        return new UUID(mostSigBits, leastSigBits).toString().replaceAll("-", "");
    }
}
