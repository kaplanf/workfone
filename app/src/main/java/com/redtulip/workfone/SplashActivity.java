package com.redtulip.workfone;


import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.redtulip.workfone.activity.BaseActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

@EActivity(R.layout.splash_activity)
public class SplashActivity extends BaseActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    @AfterInject
    void afterInject() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @AfterViews
    protected void afterViews() {
        initUI();
    }

    @UiThread
    public void initUI() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, MainActivity_.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
