package com.example.PhoneSafe.engine;

import android.content.Context;
import com.example.PhoneSafe.domain.VersionInfo;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-7-31
 * Time: 下午10:09
 * To change this template use File | Settings | File Templates.
 */
public class UpdateVersion {
    public Context context;

    public UpdateVersion(Context context) {
        this.context = context;
    }

    /**
     * 获取版本信息
     */

    public VersionInfo getVersionInfo(int urlid) throws Exception{
        String path =  context.getResources().getString(urlid);
        URL url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setReadTimeout(5000);
        InputStream is = httpURLConnection.getInputStream();
        return UpdatePull.getVersionInfo(is);
    }
}
