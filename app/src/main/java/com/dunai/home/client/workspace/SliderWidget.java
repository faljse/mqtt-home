package com.dunai.home.client.workspace;

import com.dunai.home.R;

import org.json.JSONException;
import org.json.JSONObject;

public class SliderWidget extends Widget {
    public int minValue;
    public int maxValue;
    public int step;

    public SliderWidget(String id, String title, String topic, String publishTopic, boolean retain, boolean showTitle, boolean showLastUpdate, int spanPortrait, int spanLandscape, String bgColor, int minValue, int maxValue, int step) {
        super(id, title, topic, publishTopic, retain, showTitle, showLastUpdate, spanPortrait, spanLandscape, bgColor);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.step = step;
    }

    public JSONObject serialize() {
        JSONObject root = super.serialize();
        try {
            root.put("minValue", this.minValue);
            root.put("maxValue", this.maxValue);
            root.put("step", this.step);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public String getType() {
        return "slider";
    }

    @Override
    public int getIconResource() {
        return R.drawable.ic_w_slider;
    }
}
