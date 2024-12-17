package com.example.compatibilityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MotherboardSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>() {{
            add(new Motherboard("Gigabyte A520M", "AM4", "AMD A520", "Micro-ATX", "DDR4"));
            add(new Motherboard("MSI B450", "AM4", "AMD B450", "ATX", "DDR4"));
            add(new Motherboard("ASUS TUF X570", "AM4", "AMD X570", "ATX", "DDR4"));
            add(new Motherboard("ASRock B550 Pro4", "AM4", "AMD B550", "Micro-ATX", "DDR4"));
            add(new Motherboard("Gigabyte Z690 Aorus Elite", "LGA1700", "Intel Z690", "ATX", "DDR5"));
            add(new Motherboard("MSI MAG B660M", "LGA1700", "Intel B660", "Micro-ATX", "DDR5"));
            add(new Motherboard("ASUS PRIME B760M", "LGA1700", "Intel B760", "Micro-ATX", "DDR5"));
            add(new Motherboard("ASRock X670E Pro RS", "AM5", "AMD X670E", "ATX", "DDR5"));
            add(new Motherboard("ASUS ROG STRIX Z790", "LGA1700", "Intel Z790", "ATX", "DDR5"));
            add(new Motherboard("Gigabyte X570 AORUS Master", "AM4", "AMD X570", "ATX", "DDR5"));
            add(new Motherboard("MSI MPG B650", "AM5", "AMD B650", "ATX", "DDR5"));
            add(new Motherboard("ASRock H610M-HDV", "LGA1700", "Intel H610", "Micro-ATX", "DDR5"));
        }};

        ArrayList<String> motherboardsNames = new ArrayList<>();
        for (Motherboard motherboard : motherboards) {
            motherboardsNames.add(
                motherboard.name + " "
                + motherboard.socket + " "
                + motherboard.chipset + " "
                + motherboard.formFactor + " "
                + motherboard.ram
            );
        }


        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, motherboardsNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Motherboard selectedMotherboard = motherboards.get(position);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedComponent", selectedMotherboard);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

}