package com.example.PhoneSafe.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-7-31
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class VersionInfo {
    private String version; //版本号
    private String description;     //描述信息
    private String url;    //软件更新的url

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
