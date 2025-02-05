package com.dunai.home.activities;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.dunai.home.R;
import com.dunai.home.client.workspace.ColorWidget;
import com.dunai.home.client.workspace.Widget;

import java.util.Collections;
import java.util.List;

public class ColorWidgetEditActivity extends AbstractWidgetEditActivity {
    private CheckBox alpha;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_color_renderer_edit;
    }

    @Override
    protected String getType() {
        return "color";
    }

    @Override
    protected List<TextView> getRequiredFields() {
        return Collections.emptyList();
    }

    @Override
    protected Widget construct(String id, String title, String topic, String publishTopic, boolean retain, boolean showTitle, boolean showLastUpdate, int spanPortrait, int spanLandscape, String bgColor) {
        return new ColorWidget(id, title, topic, publishTopic, retain, showTitle, showLastUpdate, spanPortrait, spanLandscape, bgColor, "HTML", alpha.isChecked()); // TODO: format arg
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alpha = findViewById(R.id.colorRendererAlpha);

        ColorWidget item = (ColorWidget) getExisting();
        if (item != null) {
            alpha.setChecked(item.alpha);
        }
    }
}