package com.example.gyakorlo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextQuantity;
    private Button addButton;
    private ListView listView;
    private ArrayList<ShoppingItem> shoppingList;
    private ShoppingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        addButton = findViewById(R.id.buttonAdd);
        listView = findViewById(R.id.listViewItems);

        shoppingList = new ArrayList<ShoppingItem>();
        adapter = new ShoppingAdapter(this, shoppingList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            int quantity = Integer.parseInt(editTextQuantity.getText().toString());
            shoppingList.add(new ShoppingItem(name, quantity));
            adapter.notifyDataSetChanged();
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ShoppingItem item = shoppingList.get(position);

            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("ITEM_NAME", item.getName());
            intent.putExtra("ITEM_QUANTITY", item.getQuantity());
            startActivity(intent);
        });


        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            shoppingList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}