package com.udacity.android.basics.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity = 0;
    private TextView quantityTextView;
    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = findViewById(R.id.quantity_text_view);
        priceTextView = findViewById(R.id.price_text_view);
    }

    /**
     * This method is called when plus button is clicked
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
     }

    /**
     * This method is called when minus button is clicked
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = quantity * 50;
        String message = getString(R.string.total) + NumberFormat.getCurrencyInstance().format(price);
        message = message + getString(R.string.thank_you);
        displayMessage(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityTextView.setText(String.format(Locale.getDefault(), "%d", number));
    }

    /**
     * This method displays the given message on the screen
     */
    private void displayMessage(String message) {
        priceTextView.setText(message);
    }
}
