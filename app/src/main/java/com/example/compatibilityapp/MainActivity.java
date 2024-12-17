package com.example.compatibilityapp;

import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Motherboard motherboard;
    private Processor processor;
    private GPU gpu;
    private RAM ram;
    private PowerSupply powerSupply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button motherboardButton = findViewById(R.id.buttonMotherboard);
        Button processorButton = findViewById(R.id.buttonProcessor);
        Button gpuButton = findViewById(R.id.buttonGpu);
        Button ramButton = findViewById(R.id.buttonRam);
        Button psuButton = findViewById(R.id.buttonPsu);
        Button checkButton = findViewById(R.id.buttonCheck);

        TextView resultText = findViewById(R.id.textViewResult);

        motherboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MotherboardSelectionActivity.class);
            startActivityForResult(intent, 1);
        });

        processorButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProcessorSelectionActivity.class);
            startActivityForResult(intent, 2);
        });

        gpuButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GpuSelectionActivity.class);
            startActivityForResult(intent, 3);
        });

        ramButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RamSelectionActivity.class);
            startActivityForResult(intent, 4);
        });

        psuButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PowerSupplySelectionActivity.class);
            startActivityForResult(intent, 5);
        });

        checkButton.setOnClickListener(v -> {
            resultText.setText(isCompatible());
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView motherboardText = findViewById(R.id.textViewMotherboard);
        TextView processorText = findViewById(R.id.textViewProcessor);
        TextView GPUText = findViewById(R.id.textViewGPU);
        TextView RAMText = findViewById(R.id.textViewRAM);
        TextView PSUText = findViewById(R.id.textViewPsu);

        if (resultCode == RESULT_OK && data != null) {
            try {
                switch (requestCode) {
                    case 1:
                        motherboard = data.getParcelableExtra("selectedComponent");
                        if (motherboard != null) {
                            Toast.makeText(this, "Материнская плата выбрана: " + motherboard.name, Toast.LENGTH_SHORT).show();
                            motherboardText.setText(
                                "Материнская плата: "
                                + motherboard.name + " "
                                + motherboard.socket + " "
                                + motherboard.chipset + " "
                                + motherboard.ram + " "
                                + motherboard.formFactor + " "
                                + motherboard.ram
                            );
                        } else {
                            Toast.makeText(this, "Материнская плата не выбрана!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        processor = (Processor) data.getParcelableExtra("selectedComponent");
                        Toast.makeText(this, "Процессор выбран: " + processor.name, Toast.LENGTH_SHORT).show();
                        processorText.setText(
                                "Процессор: "
                                + processor.name + " "
                                + processor.socket + " "
                                + processor.cores + " ядер "
                                + processor.frequency + " Ghz "
                                + processor.power + " Ватт"
                        );
                        break;
                    case 3:
                        gpu = (GPU) data.getParcelableExtra("selectedComponent");
                        Toast.makeText(this, "Видеокарта выбрана: " + gpu.name, Toast.LENGTH_SHORT).show();
                        GPUText.setText(
                                "Видеокарта: "
                                + gpu.name + " "
                                + gpu.memorySize + " ГБ "
                                + gpu.memoryType + " "
                                + gpu.power + " Ватт"
                        );
                        break;
                    case 4:
                        ram = (RAM) data.getParcelableExtra("selectedComponent");
                        Toast.makeText(this, "Оперативная память выбрана: " + ram.name, Toast.LENGTH_SHORT).show();
                        RAMText.setText(
                                "Оперативная память: "
                                + ram.name + " "
                                + ram.type + " "
                                + ram.size + " "
                        );
                        break;
                    case 5:
                        powerSupply = (PowerSupply) data.getParcelableExtra("selectedComponent");
                        Toast.makeText(this,"Блок питания выбран: " + powerSupply.name, Toast.LENGTH_SHORT).show();
                        PSUText.setText(
                                "Блок питания: "
                                + powerSupply.name + " "
                        );
                        break;
                    default:
                        Toast.makeText(this, "Неизвестный запрос.", Toast.LENGTH_SHORT).show();
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
                Toast.makeText(this, "Ошибка при получении компонента. Проверьте классы!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String isCompatible() {
        StringBuilder result = new StringBuilder();

        if (motherboard == null) { result.append("Материнская плата не выбрана! \n"); }
        if (processor == null) { result.append("Процессор не выбран! \n"); }
        if (gpu == null) { result.append("Видеокарта не выбрана! \n"); }
        if (ram == null) { result.append("Оперативная память не выбрана! \n"); }
        if (powerSupply == null) { result.append("Блок питания не выбран! \n"); }

        if (motherboard != null && ram != null && !motherboard.ram.equals(ram.type)) {
            result.append("Тип оперативной памяти не подходит к материнской плате! \n");
        }
        if (motherboard != null && processor != null && !motherboard.socket.equals(processor.socket)) {
            result.append("Сокет процессора и материнской платы отличается! \n");
        }
        if (powerSupply != null && gpu != null && processor != null) {
            int totalPower = gpu.power + processor.power + 100;
            if (powerSupply.wattage < totalPower) {
                result.append("Недостаточный вольтаж блока питания! \n");
            }
        }

        if (result.length() == 0) {
            return "Все компоненты совместимы!";
        }

        return result.toString();
    }


}
