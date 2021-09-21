package snail.app.flutter.apple.flutterapplepay;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterApplePayPlugin */
public class FlutterApplePayPlugin implements MethodCallHandler, FlutterPlugin {
  /** Plugin registration. */
  private MethodChannel methodChannel;

  public static void registerWith(Registrar registrar) {
    FlutterApplePayPlugin instance = new FlutterApplePayPlugin();
    instance.initInstance(registrar.messenger(), registrar.context());
  }
  
  public void initInstance(BinaryMessenger messenger, Context context){
    methodChannel = new MethodChannel(messenger, "flutter_apple_pay");
    methodChannel.setMethodCallHandler(new FlutterApplePayPlugin());
  }
  
  private void dispose(){
    methodChannel.setMethodCallHandler(null);
    methodChannel = null;
  }
  
  @Override
  public void onAttachedToEngine(FlutterPluginBinding binding){
    initInstance(binding.getBinaryMessenger(), binding.getApplicationContext());
  }
  
  @Override
  public void onDetachedFromEngine(FlutterPlugin binding){
    dispose();
  }
  
  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }
}
