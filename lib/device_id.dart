
import 'package:flutter/services.dart';

class DeviceId {
  static const MethodChannel _channel = MethodChannel('device_id');

  static Future<String?> uuid() async {
    try {
      final String deviceId = await _channel.invokeMethod('uuid');
      return deviceId;
    }catch(e) {
      return null;
    }
  }
}
