package com.dunai.home.client.workspace;

import com.dunai.home.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DropdownWidget extends Widget {
    public ArrayList<KeyValue> keyValues;

    public DropdownWidget(String id, String title, String topic, String publishTopic, boolean retain, boolean showTitle, boolean showLastUpdate, int spanPortrait, int spanLandscape, String bgColor, ArrayList<KeyValue> keyValues) {
        super(id, title, topic, publishTopic, retain, showTitle, showLastUpdate, spanPortrait, spanLandscape, bgColor);
        this.keyValues = keyValues;
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public String getType() {
        return "dropdown";
    }

    @Override
    public int getIconResource() {
        return R.drawable.ic_w_dropdown;
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
