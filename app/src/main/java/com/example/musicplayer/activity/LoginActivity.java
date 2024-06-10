package com.example.musicplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.musicplayer.R;
import com.example.musicplayer.useLitepal.UserInfoBean;
import com.example.musicplayer.widget.StrUtil;
import com.example.musicplayer.widget.ToastUtil;

import org.litepal.crud.DataSupport;

import java.util.List;


public class LoginActivity extends Activity {

    TextView tv_regi;

    TextView tv_login;

    EditText et_phone;

    EditText et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initData();
    }

    protected void initData() {
        tv_regi = findViewById(R.id.tv_regi);
        tv_login = findViewById(R.id.tv_login);
        et_phone = findViewById(R.id.et_phone);
        et_pwd = findViewById(R.id.et_pwd);

        tv_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RegiDialog(LoginActivity.this).showDialog();
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempPhone = et_phone.getText().toString().trim();
                String tempPwd = et_pwd.getText().toString().trim();
                if (StrUtil.isEmpty(tempPhone) || StrUtil.isEmpty(tempPwd)) {
                    ToastUtil.showToast(LoginActivity.this, "用户名或密码不能为空");
                    return;
                }
//                if (tempPhone.length() != 11) {
//                    ToastUtil.showToast(LoginActivity.this, "手机号错误");
//                    return;
//                }
                //  List<UserInfoBean> list = DataSupport.where("name = " + tempPhone + " and " + "pwd = " + tempPwd).find(UserInfoBean.class);//查询表Comment
//                if (list.size() == 0) {
//                    ToastUtil.showToast(LoginActivity.this, "手机号或密码错误");
//                    return;
//                }
                List<UserInfoBean> list = DataSupport.findAll(UserInfoBean.class);
                if (list == null) {
                    ToastUtil.showToast(LoginActivity.this, "手机号或密码不正确");
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(tempPhone) && list.get(i).getPwd().equals(tempPwd)) {

                         Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("ds", list.get(i));
                        startActivity(intent);

                        return;
                    }
                }
                ToastUtil.showToast(LoginActivity.this, "手机号或密码不正确");

            }
        });
    }
}
