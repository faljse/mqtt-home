package com.dunai.home.client.workspace;

import com.dunai.home.R;

import org.json.JSONException;
import org.json.JSONObject;

public class TextWidget extends Widget {
    public String prefix;
    public String suffix;

    public TextWidget(String id, String title, String topic, String publishTopic, boolean retain, boolean showTitle, boolean showLastUpdate, int spanPortrait, int spanLandscape, String bgColor, String prefix, String suffix) {
        super(id, title, topic, publishTopic, retain, showTitle, showLastUpdate, spanPortrait, spanLandscape, bgColor);
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public JSONObject serialize() {
        JSONObject root = super.serialize();
        try {
            root.put("prefix", this.prefix);
            root.put("suffix", this.suffix);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public String getType() {
        return "text";
    }

    @Override
    public int getIconResource() {
        return R.drawable.ic_w_text;
    }
}
