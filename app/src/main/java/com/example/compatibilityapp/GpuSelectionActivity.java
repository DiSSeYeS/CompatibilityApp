package com.example.compatibilityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class GpuSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ListView listView = findViewById(R.id.listView);

        ArrayList<GPU> gpus = new ArrayList<GPU>() {{
            add(new GPU("NVIDIA GTX 1660", "GDDR5", 6, 120));
            add(new GPU("NVIDIA RTX 3060", "GDDR6", 12, 170));
            add(new GPU("AMD RX 6600", "GDDR6", 8, 132));
            add(new GPU("AMD RX 6700XT", "GDDR6", 12, 230));
            add(new GPU("NVIDIA RTX 3080", "GDDR6X", 10, 320));
            add(new GPU("NVIDIA RTX 4090", "GDDR6X", 24, 450));
            add(new GPU("AMD RX 7900XTX", "GDDR6", 24, 355));
            add(new GPU("Intel Arc A770", "GDDR6", 16, 225));
            add(new GPU("NVIDIA GTX 1050 Ti", "GDDR5", 4, 75));
            add(new GPU("AMD RX 580", "GDDR5", 8, 185));
            add(new GPU("NVIDIA RTX 3070 Ti", "GDDR6X", 8, 290));
            add(new GPU("AMD RX 7700XT", "GDDR6", 12, 245));
        }};

        ArrayList<String> gpuNames = new ArrayList<>();
        for (GPU gpu : gpus) {
            gpuNames.add(
                    gpu.name + " "
                    + gpu.memoryType + " "
                    + gpu.memorySize + "ГБ "
                    + gpu.memorySize + " Ватт"
            );
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gpuNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            GPU selectedGpu = gpus.get(position);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedComponent", selectedGpu);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

}

