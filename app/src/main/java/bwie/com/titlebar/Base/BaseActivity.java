package bwie.com.titlebar.Base;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/24
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import bwie.com.titlebar.R;


/**
 * Created by Administrator on 2016/8/11.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    private BaseApplication mApp;
    protected Context mContext;
    protected BaseLayout baseLayout;
    protected static final int LAYOUT_TYPE_NORMAL = 0;
    protected static final int LAYOUT_TYPE_HEADER = 1;
    protected boolean mIsFront = false;//判断当前Activity是否在最顶端
    public BaseActivity() {
        mContext = this;
        mApp = BaseApplication.getSelf();
    }
    protected void setView(int layoutResId,int type){
        switch (type){
            //设置没有标题栏
            case LAYOUT_TYPE_NORMAL:
                setContentView(layoutResId);
                break;
            //设置有标题栏
            case LAYOUT_TYPE_HEADER:
                baseLayout = new BaseLayout(this,layoutResId,type);
                setContentView(baseLayout);
                break;
        }
        if (baseLayout!= null){
            if (baseLayout.btnBack!=null){
                baseLayout.btnBack.setOnClickListener(this);
            }
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    /**
     * 添加标题内容
     * @param text
     */
    protected void setTitleText(String text){
        baseLayout.setTitleText(text);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBack:
                exit();
                break;
        }
    }

    //点击back键返回上一页或退出程序
    private void exit() {
        onKeyDown(KeyEvent.KEYCODE_BACK,new KeyEvent(KeyEvent.KEYCODE_BACK,KeyEvent.ACTION_DOWN));
    }
    /**
     * <功能详细描述>是否响应物理按键到搜索，onKeyDown中调用<br>
     *
     * @return<br>
     */
    protected boolean isCanSearch() {
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SEARCH){
            if (!isCanSearch()){
                return true;
            }
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_BACK){
            if (event.getRepeatCount() == 0){
                if (this.getParent() instanceof TabActivity){
                    finish();
                    getParent().finish();
                    //也可以自己加动画效果getParent().overridePendingTransition()
                }else {
                    finish();
                }
                try {
                    return getParent().onKeyDown(keyCode,event);
                } catch (NullPointerException e) {
                    if (getParent() == null) {
                        this.finish();
                    }
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public View findViewById(int id) {
        if (baseLayout!=null){
            return baseLayout.findViewById(id);
        }else {
            return super.findViewById(id);
        }
    }
}

