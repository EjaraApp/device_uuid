# Device Identifier

This Flutter library aims to simplify the process of obtaining a unique identifier for mobile devices. It specifically addresses the challenges associated with non-persistent UUIDs on both Android and iOS platforms.
## Usage

1. Import the package
```dart
import 'package:device_id/device_id.dart';
```

2. Call the method `uuid()` to get the device Id
```dart
String deviceId = await DeviceId.uuid();
```