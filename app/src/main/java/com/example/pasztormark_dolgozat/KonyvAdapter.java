package com.example.pasztormark_dolgozat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class KonyvAdapter extends ArrayAdapter<ListViewItem> {
    public KonyvAdapter(Context context, int resource, List<ListViewItem> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listviewitem, parent, false);

        } ListViewItem item = getItem(position);
        TextView cim = convertView.findViewById(R.id.cim);
        TextView szerzo = convertView.findViewById(R.id.szerzo);
        TextView oldalszam = convertView.findViewById(R.id.oldalszam);

        item.setCim(cim.getText().toString());
        item.setSzerzo(szerzo.getText().toString());
        item.setOldalszam(Integer.parseInt(oldalszam.getText().toString()));return  convertView;
    }

}
