package com.joe.variantssample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.joe.base.ResUtil;
import com.joe.variant.AppConfig;

/**
 * Description：
 *
 * @author QiaoJF on 19/1/13.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvMainDescribe = findViewById(R.id.tv_main_describe);

        String describe = String.format(ResUtil.getString(R.string.txt_main_describe),
                BuildConfig.FLAVOR,
                ResUtil.getString(R.string.app_name),
                BuildConfig.APPLICATION_ID,
                BuildConfig.VERSION_CODE,
                BuildConfig.VERSION_NAME,
                BuildConfig.SERVER_URL,
                AppConfig.QQ_APP_ID);
        tvMainDescribe.setText(describe);

        findViewById(R.id.btn_share_qq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("QQ分享")
                        .setMessage("QQ_APP_ID : " +
                                AppConfig.QQ_APP_ID + "\n" +
                                "具体的分享逻辑自己实现即可,这里的appId仅显示用.懒得申请appId了~项目测试是没问题的.")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //TODO跳转分享
                            }
                        })
                        .show();
            }
        });

    }

}
