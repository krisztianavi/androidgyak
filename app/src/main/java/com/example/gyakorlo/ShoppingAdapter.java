package com.example.gyakorlo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ShoppingItem> shoppingList;

    public ShoppingAdapter(Context context, ArrayList<ShoppingItem> shoppingList) {
        this.context = context;
        this.shoppingList = shoppingList;
    }

    @Override
    public int getCount() {
        return shoppingList.size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shopping_item, parent, false);
        }

        ShoppingItem item = shoppingList.get(position);
        TextView nameTextView = convertView.findViewById(R.id.itemName);
        TextView quantityTextView = convertView.findViewById(R.id.itemQuantity);

        nameTextView.setText(item.getName());
        quantityTextView.setText(String.valueOf(item.getQuantity()));

        return convertView;
    }
}
