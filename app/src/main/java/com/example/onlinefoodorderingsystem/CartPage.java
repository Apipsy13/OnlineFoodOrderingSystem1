package com.example.onlinefoodorderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class CartPage extends Activity {

    private ListView cartListView;
    private Button btnProceedToPayment;
    private ArrayList<String> cartItems; // List to hold items in the cart

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        btnProceedToPayment = findViewById(R.id.btnProceedToPayment);

        // Get the cart items passed from MenuPage
        Intent intent = getIntent();
        cartItems = intent.getStringArrayListExtra("cartItems");

        // If no items in the cart, initialize an empty list
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        // Set up ArrayAdapter to display cart items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(adapter);

        // Navigate to PaymentPage when clicked
        btnProceedToPayment.setOnClickListener(v -> {
            Intent paymentIntent = new Intent(CartPage.this, PaymentPage.class);
            paymentIntent.putStringArrayListExtra("cartItems", cartItems); // Pass cart items to PaymentPage
            startActivity(paymentIntent);
        });
    }
}
