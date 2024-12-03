package com.example.gyakorlo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private TextView textViewName, textViewQuantity;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textViewName = findViewById(R.id.textViewName);
        textViewQuantity = findViewById(R.id.textViewQuantity);
        backButton = findViewById(R.id.backButton);

        String name = getIntent().getStringExtra("ITEM_NAME");
        int quantity = getIntent().getIntExtra("ITEM_QUANTITY", -1);

        if (name != null) {
            textViewName.setText(name);
        } else {
            textViewName.setText("Nincs név");
        }

        textViewQuantity.setText(String.valueOf(quantity));
        backButton.setOnClickListener(v -> finish());
    }

}
