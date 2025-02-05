package com.dunai.home.renderers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dunai.home.R;
import com.dunai.home.client.HomeClient;
import com.dunai.home.client.workspace.DropdownWidget;

import java.util.List;

/**
 * TODO: document your custom view class.
 */
@SuppressLint("ViewConstructor")
public class DropdownWidgetRenderer extends WidgetRenderer {
    private final DropdownWidget workspaceDropdownWidget;

    private final Spinner spinnerView;

    public DropdownWidgetRenderer(Context context, DropdownWidget workspaceDropdownWidget, String value) {
        super(context, workspaceDropdownWidget);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.dropdown_renderer, this.findViewById(R.id.rendererContainer), true);

        this.workspaceDropdownWidget = workspaceDropdownWidget;

        this.spinnerView = this.findViewById(R.id.dropdownRendererSpinner);
        this.spinnerView.setAdapter(new DropdownAdapter(getContext(), R.layout.two_column_list_item, this.workspaceDropdownWidget.keyValues));
        this.spinnerView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean isInitial = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isInitial) {
                    isInitial = false;
                    return;
                }
                HomeClient.getInstance().publish(
                        workspaceDropdownWidget.topic,
                        workspaceDropdownWidget.publishTopic,
                        workspaceDropdownWidget.keyValues.get(position).getValue(),
                        workspaceDropdownWidget.retain
                );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (value != null) {
            this.setValue(value);
        }
    }

    public void setValue(String value) {
        int index = -1;
        int i = 0;
        for (DropdownWidget.KeyValue keyValue : this.workspaceDropdownWidget.keyValues) {
            if (keyValue.getValue().equals(value)) {
                index = i;
            }
            i++;
        }
        if (index != -1) {
            this.spinnerView.setSelection(index);
        }
        super.notifyValueChanged();
    }

    public static class DropdownAdapter extends ArrayAdapter<DropdownWidget.KeyValue> {
        public DropdownAdapter(@NonNull Context context, int resource, @NonNull List<DropdownWidget.KeyValue> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return this.getCustomView(position, convertView, parent, false);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return this.getCustomView(position, convertView, parent, true);
        }

        public View getCustomView(int position, @Nullable View convertView, @NonNull ViewGroup parent, boolean showLine2) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.two_column_list_item, parent, false);
            }
            ((TextView) view.findViewById(R.id.itemLine1)).setText(this.getItem(position).getKey());
            TextView line2 = view.findViewById(R.id.itemLine2);
            if (showLine2) {
                line2.setVisibility(VISIBLE);
                line2.setText(this.getItem(position).getValue());
            } else {
                line2.setVisibility(GONE);
            }
            return view;
        }
    }
}