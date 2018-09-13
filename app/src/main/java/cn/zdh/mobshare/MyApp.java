package cn.zdh.mobshare;

import android.app.Application;

import com.mob.MobSDK;

/**
 * Created by Administrator on 2018/9/13.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //mob分享
        MobSDK.init(this);
    }
}
