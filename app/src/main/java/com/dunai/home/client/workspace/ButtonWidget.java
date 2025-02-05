package com.dunai.home.client.workspace;

import com.dunai.home.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ButtonWidget extends Widget {
    public ArrayList<KeyValue> keyValues;
    public Orientation orientation;

    public ButtonWidget(String id, String title, String topic, String publishTopic, boolean retain, boolean showTitle, boolean showLastUpdate, int spanPortrait, int spanLandscape, String bgColor, ArrayList<KeyValue> keyValues, Orientation orientation) {
        super(id, title, topic, publishTopic, retain, showTitle, showLastUpdate, spanPortrait, spanLandscape, bgColor);
        this.keyValues = keyValues;
        this.orientation = orientation;
    }

    public JSONObject serialize() {
        JSONObject root = super.serialize();
        try {
            JSONArray list = new JSONArray();
            for (KeyValue keyValue : this.keyValues) {
                JSONObject obj = new JSONObject();
                obj.put("key", keyValue.getKey());
                obj.put("value", keyValue.getValue());
                list.put(obj);
            }
            root.put("keyValues", list);
            root.put("orientation", orientation);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public String getType() {
        return "button";
    }

    @Override
    public int getIconResource() {
        return R.drawable.ic_w_button;
    }

    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public static class KeyValue {
        private String key;
        private String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
