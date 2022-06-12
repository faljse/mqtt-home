package com.dunai.home.client.workspace;

import com.dunai.home.R;

import org.json.JSONObject;

public class GraphWidget extends Widget {
    public GraphWidget(String id, String title, String topic, String publishTopic, boolean retain, boolean showTitle, boolean showLastUpdate, int spanPortrait, int spanLandscape, String bgColor) {
        super(id, title, topic, publishTopic, retain, showTitle, showLastUpdate, spanPortrait, spanLandscape, bgColor);
    }

    public JSONObject serialize() {
        //        try {
//            root.put("suffix", this.suffix);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        return super.serialize();
    }

    @Override
    public String getType() {
        return "graph";
    }

    @Override
    public int getIconResource() {
        return R.drawable.ic_w_graph;
    }
}
