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

import android.app.Application;

import bwie.com.titlebar.MainActivity;


/**用来初始化数据
 * Created by Administrator on 2016/8/11.
 */
public class BaseApplication extends Application {
    private static BaseApplication mApp;
    private static MainActivity mainActivity = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = (BaseApplication) getApplicationContext();

    }

    public static BaseApplication getSelf(){
        return mApp;
    }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity mainActivity) {
        BaseApplication.mainActivity = mainActivity;
    }
}

