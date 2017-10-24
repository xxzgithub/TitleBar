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
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**自定义Toast
 * Created by Administrator on 2016/8/11.
 */
public class MyToast {
    private View v;
    private TextView tv;
    private Toast toast;

    public void init(Context context){
        v = LayoutInflater.from(context).inflate(R.layout.toast,null);
        tv = (TextView) v.findViewById(R.id.tv_toast);
        toast = new Toast(context);
        toast.setView(v);
    }

    public void toast(CharSequence text,int duration){
        if (text.length()!=0){
            tv.setText(text);
            toast.setDuration(duration);
            toast.setGravity(Gravity.BOTTOM,0,30);
            toast.show();
        }
    }

    public void toast(int resId,int duration){
        if (resId!=0){
            tv.setText(resId);
            toast.setDuration(duration);
            toast.show();
        }
    }

    public void toast(CharSequence text,int duration,int position,int yOffset){
        if (text.length()!=0){
            tv.setText(text);
            toast.setDuration(duration);
            toast.setGravity(position, 0, yOffset);
            toast.show();
        }
    }

    public void toast(CharSequence text){
        if (text.length()!=0){
            tv.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 30);
            toast.show();
        }
    }
}
