package com.example.train;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class OkHttpUtil {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(OkHttpUtil.class);

    public static String get(String url, Map<String,String> queries){
        String responseBody ="";
        StringBuffer stringBuffer = new StringBuffer(url);
        if (queries != null && queries.keySet().size()>0){
            boolean firstFlag = true;
            Iterator iterator = queries.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry<String, String>) iterator.next();
                if (firstFlag){
                    stringBuffer.append("?"+entry.getKey()+ "=" + entry.getValue());
                    firstFlag=false;
                }
                else{
                    stringBuffer.append("&"+ entry.getKey()+ "=" + entry.getValue());
                }
            }

        }
        Request request = new Request.Builder()
                .url(stringBuffer.toString())
                .build();
        Response response =null;
        try{
            OkHttpClient okHttpClient = new OkHttpClient();
            response = okHttpClient.newCall(request).execute();
            int status = response.code();
            if (response.isSuccessful()){
                return  response.body().string();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }finally {
            if(response!= null)
                response.close();
        }
        return responseBody;
    }


}
