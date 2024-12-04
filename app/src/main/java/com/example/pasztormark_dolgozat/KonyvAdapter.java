package com.example.pasztormark_dolgozat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class KonyvAdapter extends ArrayAdapter<ListViewItem> {
    public KonyvAdapter(Context context, int resource, List<ListViewItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listviewitem, parent, false);
        }

        ListViewItem item = getItem(position);
        TextView cimDisplay = convertView.findViewById(R.id.cimDisplay);
        TextView szerzoDisplay = convertView.findViewById(R.id.szerzoDisplay);
        TextView oldalszamDisplay = convertView.findViewById(R.id.oldalszamDisplay);

        if (item != null) {
            cimDisplay.setText(item.getCim());
            szerzoDisplay.setText(item.getSzerzo());
            oldalszamDisplay.setText(String.valueOf(item.getOldalszam()));
        }

            return convertView;
    }
}