package com.example.compatibilityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RamSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ListView listView = findViewById(R.id.listView);

        ArrayList<RAM> ramOptions = new ArrayList<RAM>() {{
            add(new RAM("DDR4 8GB", "DDR4", 8));
            add(new RAM("DDR4 16GB", "DDR4", 16));
            add(new RAM("DDR5 16GB", "DDR5", 16));
            add(new RAM("DDR5 32GB", "DDR5", 32));
            add(new RAM("DDR4 32GB", "DDR4", 32));
            add(new RAM("DDR5 64GB", "DDR5", 64));
            add(new RAM("DDR4 4GB", "DDR4", 4));
            add(new RAM("DDR5 8GB", "DDR5", 8));
            add(new RAM("DDR5 128GB", "DDR5", 128));
            add(new RAM("DDR4 64GB", "DDR4", 64));
            add(new RAM("DDR5 256GB", "DDR5", 256));
            add(new RAM("DDR4 128GB", "DDR4", 128));
        }};

        ArrayList<String> ramNames = new ArrayList<>();
        for (RAM ram : ramOptions) {
            ramNames.add(ram.name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ramNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            RAM selectedRam = ramOptions.get(position);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedComponent", selectedRam);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
