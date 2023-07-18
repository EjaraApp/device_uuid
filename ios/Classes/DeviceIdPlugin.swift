import Flutter
import UIKit
import FCUUID

public class DeviceIdPlugin: NSObject, FlutterPlugin {
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "device_id", binaryMessenger: registrar.messenger())
        let instance = DeviceIdPlugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }
    
    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        switch call.method {
        case "uuid":
            result(FCUUID.uuidForDevice() as String)
        default:
            result(FlutterMethodNotImplemented)
        }
    }
}
