package com.dunai.home.client.workspace;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Item implements Cloneable{
    public String id;
    public String title;
    public String topic;
    public String publishTopic;


    public Item(String id, String title, String topic, String publishTopic) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.publishTopic = publishTopic;

    }

    public JSONObject serialize() {
        JSONObject root = new JSONObject();
        try {
            root.put("id", this.id);
            root.put("title", this.title);
            root.put("topic", this.topic);
            root.put("publishTopic", this.publishTopic);
            root.put("type", this.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return root;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract String getType();
    public abstract String getTitle();
    public abstract String getSubTitle();
    public abstract int getIconResource();
}
