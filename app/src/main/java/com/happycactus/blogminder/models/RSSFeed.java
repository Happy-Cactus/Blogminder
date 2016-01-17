package com.happycactus.blogminder.models;

import java.util.ArrayList;
import java.util.List;

public class RSSFeed {
    public String FeedUrl;
    public List<RSSItem> Items;

    public RSSFeed(){
        Items = new ArrayList<RSSItem>();
    }
}
