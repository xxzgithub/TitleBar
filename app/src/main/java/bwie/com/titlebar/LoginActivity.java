package bwie.com.titlebar;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/24
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

import android.os.Bundle;
import android.widget.Toast;

import bwie.com.titlebar.Base.BaseActivity;


/**
 * Created by Administrator on 2016/8/12.
 */
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.activity_login, LAYOUT_TYPE_HEADER);
        setTitleText("登录");
        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
    }
}
