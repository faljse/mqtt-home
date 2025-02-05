package com.dunai.home.client.workspace;

import com.dunai.home.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ColorWidget extends Widget {
    public ColorFormat format;
    public boolean alpha;

    public ColorWidget(String id, String title, String topic, String publishTopic, boolean retain, boolean showTitle, boolean showLastUpdate, int spanPortrait, int spanLandscape, String bgColor, String format, boolean alpha) {
        super(id, title, topic, publishTopic, retain, showTitle, showLastUpdate, spanPortrait, spanLandscape, bgColor);
        this.format = ColorFormat.valueOf(format);
        this.alpha = alpha;
    }

    public JSONObject serialize() {
        JSONObject root = super.serialize();
        try {
            root.put("format", this.format.name());
            root.put("alpha", this.alpha);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public String getType() {
        return "color";
    }

    @Override
    public int getIconResource() {
        return R.drawable.ic_w_color;
    }

    public enum ColorFormat {
        HTML, // #102030 / #FF102030
        COMMA, // 16,32,48 / 16,32,48,255
        HSV, // 210,50,12 / 210,50,12,255
        INT // 1056816 / 4279246896
    }
}
