package com.example.pasztormark_dolgozat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

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

        CardView cardView = convertView.findViewById(R.id.cardView);
        ListViewItem item = getItem(position);
        TextView cimDisplay = convertView.findViewById(R.id.cimDisplay);
        TextView szerzoDisplay = convertView.findViewById(R.id.szerzoDisplay);
        TextView oldalszamDisplay = convertView.findViewById(R.id.oldalszamDisplay);
        Button torles = convertView.findViewById(R.id.torles);

//notifyDataSetChanged();!!!!!
        if (item != null) {
            cimDisplay.setText(item.getCim());
            szerzoDisplay.setText(item.getSzerzo());
            oldalszamDisplay.setText(String.valueOf(item.getOldalszam()));

            convertView.setOnClickListener(view -> {
                Intent adat = new Intent(getContext(), DetailsActivity.class);
                adat.putExtra("cim", item.getCim());
                adat.putExtra("szerzo", item.getSzerzo());
                adat.putExtra("oldalszam", item.getOldalszam());
                getContext().startActivity(adat);
            });

            torles.setOnClickListener(view -> {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Biztos törölni szeretnéd?");
                alert.setPositiveButton("Igen", (dialog, which) -> {
                    remove(item);
                    notifyDataSetChanged();
                });
                alert.setNegativeButton("Nem", (dialog, which) -> {

                });
                alert.show();
            });
        }

            return convertView;
    }
}