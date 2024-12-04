package com.example.pasztormark_dolgozat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText cimEditText;
    private EditText szerzoEditText;
    private EditText oldalszamEditText;
    private Button submitButton;
    private ListView listView;
    private ArrayList<ListViewItem> ujKonyv;

    private KonyvAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cimEditText = findViewById(R.id.cim);
        szerzoEditText = findViewById(R.id.szerzo);
        oldalszamEditText = findViewById(R.id.oldalszam);
        submitButton = findViewById(R.id.submit);
        listView = findViewById(R.id.lista);

        ujKonyv = new ArrayList<>();
        adapter = new KonyvAdapter(this, R.layout.listviewitem, ujKonyv);
        listView.setAdapter(adapter);

        submitButton.setOnClickListener(view -> {
            String cim = cimEditText.getText().toString();
            if (cim.isEmpty()) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("cím nem jó");
                alert.show();
                return;
            }
            String szerzo = szerzoEditText.getText().toString();
            if (szerzo.isEmpty()) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("szerző nem jó");
                alert.show();
                return;
            }
            int oldalszam = Integer.parseInt(oldalszamEditText.getText().toString());
            if (oldalszam < 50) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("min 50 oldal");
                alert.show();
                return;
            }
            ListViewItem item = new ListViewItem(cim, szerzo, oldalszam);
            ujKonyv.add(item);
            adapter.notifyDataSetChanged();
        });
    }
}