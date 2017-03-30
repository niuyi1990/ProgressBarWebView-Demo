package com.soft.niuyi.progressbarwebview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.soft.niuyi.progressbarwebview_demo.view.ProgressWebView;

public class MainActivity extends AppCompatActivity {

    private ProgressWebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url ="http://mp.weixin.qq.com/s?__biz=MzAwODQ5MTA2NQ==&mid=402389923&idx=1&sn=3c89c329e7bf83ce8ff2364726ebd6a7#rd";

        mWebView = (ProgressWebView) findViewById(R.id.webview);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
    }
}
