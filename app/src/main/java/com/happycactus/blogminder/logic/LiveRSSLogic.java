package com.happycactus.blogminder.logic;

import com.happycactus.blogminder.models.RSSFeed;
import com.happycactus.blogminder.models.RSSItem;
import com.happycactus.blogminder.repositories.IOptionsRepository;

import org.joda.time.DateTime;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LiveRSSLogic implements IRSSLogic{

    @Override
    public DateTime LastPostDate(RSSFeed Feed) {
        try {
            RSSItem lastItem = Feed.Items.get(0);
            return new DateTime(lastItem.Timestamp);
        }
        catch(Exception ex){
            return null;
        }
    }

    @Override
    public boolean FeedValid(String FeedString) {
        return false;
    }

    @Override
    public RSSFeed GetRSSFeed(IOptionsRepository optionsRepository) {
        try{
            RSSFeed rssFeed = new RSSFeed();

            URL url = new URL(optionsRepository.GetRSSFeedUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream stream = connection.getInputStream();
            XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlParser = xmlFactory.newPullParser();

            xmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlParser.setInput(stream, null);

            int xmlEvent;
            String text = "";
            String pubNode = optionsRepository.GetPublishDateNodeName();

            try{
                xmlEvent = xmlParser.getEventType();

                while(xmlEvent != XmlPullParser.END_DOCUMENT){
                    RSSItem item = new RSSItem();
                    String name = xmlParser.getName();

                    switch(xmlEvent){
                        case XmlPullParser.START_TAG:
                            break;

                        case XmlPullParser.TEXT:
                            text = xmlParser.getText();
                            break;

                        case XmlPullParser.END_TAG:
                            if(name == "title"){
                                item.Title = text;
                            }
                            else if(name == "link"){
                                item.Link = text;
                            }
                            else if (name == pubNode) {
                                item.Timestamp = text;
                            }
                            break;
                    }

                    rssFeed.Items.add(item);
                    xmlEvent = xmlParser.next();
                }
            }
            catch(Exception ex){

            }

            return rssFeed;

        }
        catch(Exception ex){
            return null;
        }
    }
}
