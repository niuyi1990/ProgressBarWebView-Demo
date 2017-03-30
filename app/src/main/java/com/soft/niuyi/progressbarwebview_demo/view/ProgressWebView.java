package com.soft.niuyi.progressbarwebview_demo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.soft.niuyi.progressbarwebview_demo.R;

/**
 * 作者：${牛毅}
 * 时间：2017/03/30 14：57
 * 邮箱：niuyi19900923@gmail.com
 * 描述：
 */
public class ProgressWebView extends WebView {

    private ProgressBar mProgressBar;
    private Context mContext;

    public ProgressWebView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public ProgressWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //设置横向进度条
        mProgressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
        //设置进度条宽高
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 10);
        mProgressBar.setLayoutParams(params);
        //设置进度条样式
        Drawable drawable = mContext.getResources().getDrawable(R.drawable.web_progress_bar);
        mProgressBar.setProgressDrawable(drawable);

        addView(mProgressBar);
        setWebChromeClient(new ProgressWebChromeClient());
    }

    /**
     * 重写WebChromeClient获取加载进度
     */
    class ProgressWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressBar.setVisibility(View.GONE);
            } else {
                if (mProgressBar.getVisibility() == View.GONE) {
                    mProgressBar.setVisibility(View.VISIBLE);
                }
                mProgressBar.setProgress(newProgress);
            }

            super.onProgressChanged(view, newProgress);
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
