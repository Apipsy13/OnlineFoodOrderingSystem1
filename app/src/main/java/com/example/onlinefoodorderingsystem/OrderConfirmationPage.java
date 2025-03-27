package com.example.onlinefoodorderingsystem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderConfirmationPage extends Activity {

    private ListView orderConfirmationListView;
    private TextView tvConfirmationMessage, tvPaymentMethod;
    private Button btnGoToMenu, btnGoToHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        // Find views
        orderConfirmationListView = findViewById(R.id.orderConfirmationListView);
        tvConfirmationMessage = findViewById(R.id.tvConfirmationMessage);
        tvPaymentMethod = findViewById(R.id.tvPaymentMethod);
        btnGoToMenu = findViewById(R.id.btnGoToMenu);
        btnGoToHome = findViewById(R.id.btnGoToHome);  // New button

        // Get the cart items and payment method passed from PaymentPage
        Intent intent = getIntent();
        ArrayList<String> cartItems = intent.getStringArrayListExtra("cartItems");
        String paymentMethod = intent.getStringExtra("paymentMethod");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        // Set the confirmation message and selected payment method
        tvConfirmationMessage.setText("Thank you for your order!");
        tvPaymentMethod.setText("Payment Method: " + paymentMethod);

        // Set up ArrayAdapter to display cart items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        orderConfirmationListView.setAdapter(adapter);

        // Go back to MenuPage when clicked
        btnGoToMenu.setOnClickListener(v -> {
            Intent goToMenuIntent = new Intent(OrderConfirmationPage.this, MenuPage.class);
            startActivity(goToMenuIntent);
            finish(); // Close the OrderConfirmationPage
        });

        // Go back to HomePage when clicked
        btnGoToHome.setOnClickListener(v -> {
            Intent goToHomeIntent = new Intent(OrderConfirmationPage.this, HomePage.class);
            startActivity(goToHomeIntent);
            finish(); // Close the OrderConfirmationPage
        });
    }
}
