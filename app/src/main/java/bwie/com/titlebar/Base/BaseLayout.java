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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bwie.com.titlebar.R;


/**布局的基类
 * 为了统一TitleBar的样式
 * Created by Administrator on 2016/8/11.
 */
public class BaseLayout extends RelativeLayout {
    private static final int HEADER = 1;
    private static final int HEADERANDPROGRESS = 2;
    private View headerBar;
    public ImageButton btnBack;//返回按钮
    private TextView tvTitle;//标题内容


    public BaseLayout(Context context,int layoutResourceId,int type) {
        super(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (type){
            case HEADER:
                setHeaderBar(layoutInflater);
                break;
            case HEADERANDPROGRESS:
                break;
        }
        View view = layoutInflater.inflate(layoutResourceId,null);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.BELOW, R.id.header_bar);
        addView(view,params);
    }

    /**
     * 添加标题内容
     * @param text
     */
    public void setTitleText(String text){
        if (text!=null&&!text.equals("")){
            tvTitle.setText(text);
        }
    }
    /**
     * 加载标题栏的布局，放置布局的位置
     * @param layoutInflater
     */
    public void setHeaderBar(LayoutInflater layoutInflater){
        headerBar = layoutInflater.inflate(R.layout.titlebar,null);
        btnBack = (ImageButton) headerBar.findViewById(R.id.btnBack);
        tvTitle = (TextView) headerBar.findViewById(R.id.tvTitle);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        addView(headerBar,params);
    }

}
