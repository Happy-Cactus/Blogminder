package com.happycactus.blogminder.logic;

import android.util.Xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class LiveRSSLogic implements IRSSLogic{
    //http://www.tutorialspoint.com/android/android_rss_reader.htm

    @Override
    public Calendar LastPostDate(Xml Feed) {
        return null;
    }

    @Override
    public boolean FeedValid(String FeedString) {
        return false;
    }

    @Override
    public String GetFeedString(String FeedUrl) {
        try{
            URL url = new URL(FeedUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        }
        catch(IOException ex){

        }



        return null;
    }
}
