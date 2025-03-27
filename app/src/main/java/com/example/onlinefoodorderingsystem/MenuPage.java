// MenuPage.java
package com.example.onlinefoodorderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuPage extends Activity {

    private ArrayList<String> cartItems; // List to hold items added to the cart

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize cartItems list
        cartItems = new ArrayList<>();

        // Find menu item buttons
        Button btnAddPizza = findViewById(R.id.btnAddPizza);
        Button btnAddBurger = findViewById(R.id.btnAddBurger);
        Button btnAddSalad = findViewById(R.id.btnAddSalad);

        // Add Pizza to the cart
        btnAddPizza.setOnClickListener(v -> {
            cartItems.add("Pizza");
            Toast.makeText(MenuPage.this, "Pizza added to cart!", Toast.LENGTH_SHORT).show();
        });

        // Add Burger to the cart
        btnAddBurger.setOnClickListener(v -> {
            cartItems.add("Burger");
            Toast.makeText(MenuPage.this, "Burger added to cart!", Toast.LENGTH_SHORT).show();
        });

        // Add Salad to the cart
        btnAddSalad.setOnClickListener(v -> {
            cartItems.add("Salad");
            Toast.makeText(MenuPage.this, "Salad added to cart!", Toast.LENGTH_SHORT).show();
        });

        // Go to Cart Page
        Button btnGoToCart = findViewById(R.id.btnGoToCart);
        btnGoToCart.setOnClickListener(v -> {
            Intent intent = new Intent(MenuPage.this, CartPage.class);
            intent.putStringArrayListExtra("cartItems", cartItems); // Pass cart items to CartPage
            startActivity(intent);
        });
    }
}

