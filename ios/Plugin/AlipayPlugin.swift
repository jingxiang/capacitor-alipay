import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(AlipayPlugin)
public class AlipayPlugin: CAPPlugin {
    @objc public static var call: CAPPluginCall?
    
    @objc public func openPay(_ call:CAPPluginCall) {
        Self.call = call
        let orderStr = call.getString("payInfo")
        let fromScheme = call.getString("scheme") ?? "alipay"
        
        AlipaySDK.defaultService()?.payOrder(
            orderStr,
            fromScheme: fromScheme,
            callback: {
                response in
                if let result = response as NSDictionary? {
                    AlipayPlugin.call?.resolve([
                        "resultStatus":result.value(forKey: "resultStatus") as! String,
                        "result":result.value(forKey: "result") as! String,
                        "memo":result.value(forKey: "memo") as! String
                    ])
                }
            }
        )
    }
    
    @objc public func openAuth(_ call:CAPPluginCall) {
        Self.call = call
        let withInfo = call.getString("authInfo")
        let fromScheme = call.getString("scheme") ?? "alipay"
        
        AlipaySDK.defaultService()?.auth_V2(
            withInfo: withInfo,
            fromScheme: fromScheme,
            callback: {
                response in
                if let result = response as NSDictionary? {
                    AlipayPlugin.call?.resolve([
                        "resultStatus":result.value(forKey: "resultStatus") as! String,
                        "result":result.value(forKey: "result") as! String,
                        "memo":result.value(forKey: "memo") as! String
                    ])
                }
            }
        )
    }
}
