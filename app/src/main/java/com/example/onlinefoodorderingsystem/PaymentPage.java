package com.example.onlinefoodorderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class PaymentPage extends Activity {

    private RadioGroup paymentMethodGroup;
    private Button btnSubmitPayment;
    private ArrayList<String> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Get the cart items passed from CartPage
        Intent intent = getIntent();
        cartItems = intent.getStringArrayListExtra("cartItems");

        paymentMethodGroup = findViewById(R.id.paymentMethodGroup);
        btnSubmitPayment = findViewById(R.id.btnSubmitPayment);

        // Handle the submit payment button click
        btnSubmitPayment.setOnClickListener(v -> {
            int selectedId = paymentMethodGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);

            if (selectedId == -1) {
                // No payment method selected
                Toast.makeText(PaymentPage.this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            } else {
                String selectedPaymentMethod = selectedRadioButton.getText().toString();
                Toast.makeText(PaymentPage.this, "Payment Method: " + selectedPaymentMethod, Toast.LENGTH_SHORT).show();

                // After payment selection, go to order confirmation page
                Intent orderIntent = new Intent(PaymentPage.this, OrderConfirmationPage.class);
                orderIntent.putStringArrayListExtra("cartItems", cartItems);
                orderIntent.putExtra("paymentMethod", selectedPaymentMethod); // Pass payment method
                startActivity(orderIntent);
            }
        });
    }
}
