package com.example.PhoneSafe.ui;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.PhoneSafe.R;
import com.example.PhoneSafe.engine.UpdateVersion;
import com.example.PhoneSafe.domain.VersionInfo;

public class SplashActivity extends Activity {
    public static String TAG="SplashActivity";
    private TextView tv_splash_version;
    private LinearLayout splash_main;
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        init();
        UpdateVersion uv = new UpdateVersion(this);
        try {
            VersionInfo vi = uv.getVersionInfo(R.string.updateURL);
            Log.d(TAG,vi.toString());
            Toast.makeText(this,vi.getVersion(),Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        tv_splash_version.setText(getVersion());
        AlphaAnimation start = new AlphaAnimation(1,0);
        splash_main.setAnimation(start);

    }
    //组件初始化
    public void init(){
        tv_splash_version = (TextView)this.findViewById(R.id.tv_splash_version);
        splash_main = (LinearLayout)this.findViewById(R.id.splash_main);
    }
    //获取软件的版本信息
    public String getVersion(){
        String version = null;
        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo =  packageManager.getPackageInfo(getPackageName(),0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if(version!=null){
            return version;
        }
        return "error";
    }
}
