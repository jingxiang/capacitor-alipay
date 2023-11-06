package net.liyanjie.capacitor.alipay;

import java.util.Map;

import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.app.Activity;
import android.os.Message;

@CapacitorPlugin(name = "Alipay")
public class AlipayPlugin extends Plugin {

    final private Alipay implementation = new Alipay();

    static PluginCall _call;

    public static PluginCall getCall() {
        return _call;
    }

    @PluginMethod
    public void openPay(PluginCall call) {
        _call = call;

        String payInfo = call.getString("payInfo");
        final Activity activity = getBridge().getActivity();
        final Runnable runnable = () -> {
            PayTask task = new PayTask(activity);
            Map<String, String> result = task.payV2(payInfo, true);
            Message message = new Message();
            message.what = Alipay.SDK_PAY_FLAG;
            message.obj = result;

            implementation.messageHandler.sendMessage(message);
        };
        new Thread(runnable).start();
    }

    @PluginMethod
    public void openAuth(PluginCall call) {
        _call = call;

        String authInfo = call.getString("authInfo");
        final Activity activity = getBridge().getActivity();
        final Runnable runnable = () -> {
            AuthTask task = new AuthTask(activity);
            Map<String, String> result = task.authV2(authInfo, true);
            Message message = new Message();
            message.what = Alipay.SDK_AUTH_FLAG;
            message.obj = result;

            implementation.messageHandler.sendMessage(message);
        };
        new Thread(runnable).start();
    }
}
