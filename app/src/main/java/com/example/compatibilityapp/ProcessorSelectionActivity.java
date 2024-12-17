package com.example.compatibilityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ProcessorSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ListView listView = findViewById(R.id.listView);

        ArrayList<Processor> processors = new ArrayList<Processor>() {{
            add(new Processor("Intel i5 12600K", "LGA1700", 10, 4.9f, 125));
            add(new Processor("Intel i7 12700K", "LGA1700", 12, 5.0f, 125));
            add(new Processor("AMD Ryzen 5 5600X", "AM4", 6, 4.6f, 65));
            add(new Processor("AMD Ryzen 7 5800X", "AM4", 8, 4.7f, 105));
            add(new Processor("Intel i9 12900K", "LGA1700", 16, 5.2f, 125));
            add(new Processor("AMD Ryzen 9 5900X", "AM4", 12, 4.8f, 105));
            add(new Processor("Intel i3 12100F", "LGA1700", 4, 4.3f, 58));
            add(new Processor("AMD Ryzen 3 3100", "AM4", 4, 3.9f, 65));
            add(new Processor("Intel i5 13600K", "LGA1700", 14, 5.1f, 125));
            add(new Processor("AMD Ryzen 7 7700X", "AM5", 8, 5.4f, 105));
            add(new Processor("Intel i7 13700K", "LGA1700", 16, 5.4f, 125));
            add(new Processor("AMD Ryzen 9 7950X", "AM5", 16, 5.7f, 170));
        }};

        ArrayList<String> processorNames = new ArrayList<>();
        for (Processor processor : processors) {
            processorNames.add(
                processor.name + " "
                + processor.socket + " "
                + processor.cores + " Ядер "
                + processor.frequency + " Ггц "
                + processor.power + " Ватт");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, processorNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Processor selectedProcessor = processors.get(position);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedComponent", selectedProcessor);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}

