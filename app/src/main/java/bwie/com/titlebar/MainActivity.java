package bwie.com.titlebar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import bwie.com.titlebar.Base.BaseActivity;
import bwie.com.titlebar.Base.BaseApplication;


public class MainActivity extends BaseActivity {
    private TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication.getSelf().setMainActivity(this);
//        setContentView(R.layout.activity_main);
        setView(R.layout.activity_main,LAYOUT_TYPE_HEADER);
        setTitleText("主界面");
        tvShow = (TextView) findViewById(R.id.tvShow);
        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}

