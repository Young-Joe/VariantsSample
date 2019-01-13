package com.joe.tencent.wechat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        WxUtils.wxapi.handleIntent(intent, this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        WxUtils.wxapi.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {
        switch (baseReq.transaction) {
            case "weixin":
//                CommonUtils.showToast("微信请求回调");
                break;
            case "circle":
//                CommonUtils.showToast("朋友圈请求回调");
                break;
        }
    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.transaction) {
            case "weixin":
                String openId = baseResp.openId;
                boolean checkArgs = baseResp.checkArgs();
                int errCode = baseResp.errCode;
                String errStr = baseResp.errStr;
                switch (baseResp.errCode) {
                    case BaseResp.ErrCode.ERR_OK:
//                        CommonUtils.showToast("微信响应成功");
                        break;
                    case BaseResp.ErrCode.ERR_USER_CANCEL:
//                        CommonUtils.showToast("微信响应取消");
                        break;
                    case BaseResp.ErrCode.ERR_AUTH_DENIED:
//                        CommonUtils.showToast("微信响应拒绝");
                        break;
                    default:

                        break;
                }
                finish();
                break;
            case "circle":
                switch (baseResp.errCode) {
                    case BaseResp.ErrCode.ERR_OK:
//                        CommonUtils.showToast("朋友圈响应成功");
                        break;
                    case BaseResp.ErrCode.ERR_USER_CANCEL:
//                        CommonUtils.showToast("朋友圈响应取消");
                        break;
                    case BaseResp.ErrCode.ERR_AUTH_DENIED:
//                        CommonUtils.showToast("朋友圈响应拒绝");
                        break;
                    default:

                        break;
                }
                finish();
                break;
        }
    }
}
