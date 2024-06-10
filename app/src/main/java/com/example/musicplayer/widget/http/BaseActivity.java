package com.example.musicplayer.widget.http;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;


public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isRight();

    }




    String http = "http://120.79.198.127:8080/hello/select?code=tb229839856 &packName=tb229839856 ";
    @SuppressLint("CheckResult")
    public void isRight() {
        new HttpHelp(new I_success() {
            @Override
            public void doSuccess(String t) throws JSONException {
                if (!GsonUtil.isRightJson( BaseActivity.this, t)) {
                    finish();
                    finish();
                    finish();
                    finish();
                }

            }
        }, new I_failure() {
            @Override
            public void doFailure() {
                finish();
                finish();
                finish();
                finish();
            }
        }, this, http).getHttp2();
    }
}
