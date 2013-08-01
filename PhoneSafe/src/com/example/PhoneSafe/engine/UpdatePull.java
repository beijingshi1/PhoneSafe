package com.example.PhoneSafe.engine;

import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import com.example.PhoneSafe.domain.VersionInfo;
import java.io.InputStream;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-7-31
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class UpdatePull {
    /**
     *
     * @param is 解析xml文档
     * @return
     */
    public static VersionInfo getVersionInfo(InputStream is) throws Exception{
        VersionInfo vInfo = null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is,"utf-8");
         int event = parser.getEventType();
        while(XmlPullParser.END_DOCUMENT!=event){
            switch(event){
                case XmlPullParser.START_DOCUMENT:
                    vInfo = new VersionInfo();
                    break;
                case XmlPullParser.START_TAG:
                    if("version".equals(parser.getName())){
                        String version = parser.nextText();
                        vInfo.setVersion(version);
                    }else if("description".equals(parser.getName())){
                        String description = parser.nextText();
                        vInfo.setDescription(description);
                    }else if("url".equals(parser.getName())){
                         String url = parser.nextText();
                        vInfo.setUrl(url);
                    }
                    break;
            }
            event=parser.next();
        }
        return vInfo;
    }
}
