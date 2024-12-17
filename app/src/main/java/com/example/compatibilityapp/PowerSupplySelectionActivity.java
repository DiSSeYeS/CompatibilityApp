package com.example.compatibilityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PowerSupplySelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ListView listView = findViewById(R.id.listView);

        ArrayList<PowerSupply> powerSupplies = new ArrayList<PowerSupply>() {{
            add(new PowerSupply("Cooler Master 500W", 500));
            add(new PowerSupply("Corsair CV650", 650));
            add(new PowerSupply("EVGA 750W Bronze", 750));
            add(new PowerSupply("Be Quiet! 850W Gold", 850));
            add(new PowerSupply("Thermaltake 1000W Platinum", 1000));
            add(new PowerSupply("Seasonic Prime TX-1200", 1200));
            add(new PowerSupply("NZXT C750", 750));
            add(new PowerSupply("Gigabyte P850GM", 850));
            add(new PowerSupply("Antec NeoEco 650M", 650));
            add(new PowerSupply("MSI MPG A1000G", 1000));
        }};

        ArrayList<String> psuNames = new ArrayList<>();
        for (PowerSupply psu : powerSupplies) {
            psuNames.add(psu.name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, psuNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            PowerSupply selectedPsu = powerSupplies.get(position);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedComponent", selectedPsu);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
