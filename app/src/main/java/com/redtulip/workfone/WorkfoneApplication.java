package com.redtulip.workfone;

import android.app.Application;


public class WorkfoneApplication extends Application {

    private static WorkfoneApplication singleton;

    public static String IS_LOGIN = "islogin";
    public static String ID = "id";
    public static String USER_TOKEN = "user_token";
    public static String TTL = "ttl";
    public static String CREATED  = "created";
    public static String USER_ID = "userId";


    public static WorkfoneApplication getInstance() {
        if (singleton == null)
            singleton = new WorkfoneApplication();
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
