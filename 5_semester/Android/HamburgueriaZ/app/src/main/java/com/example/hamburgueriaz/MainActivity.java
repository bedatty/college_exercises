package com.example.hamburgueriaz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 0;
    private TextView tvQuantity;
    private EditText edtCustomerName;
    private CheckBox cbBacon, cbCheese, cbOnion;
    private TextView tvOrderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnSendOrder = findViewById(R.id.btnSendOrder);
        tvQuantity = findViewById(R.id.tvQuantity);
        edtCustomerName = findViewById(R.id.etCustomerName);
        cbBacon = findViewById(R.id.cbBacon);
        cbCheese = findViewById(R.id.cbCheese);
        cbOnion = findViewById(R.id.cbOnion);
        tvOrderSummary = findViewById(R.id.tvOrderSummary);

        btnAdd.setOnClickListener(v -> incrementQuantity());
        btnSubtract.setOnClickListener(v -> decrementQuantity());
        btnSendOrder.setOnClickListener(v -> sendOrder());
    }

    private void incrementQuantity() {
        quantity++;
        updateQuantity();
    }

    private void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
            updateQuantity();
        }
    }

    private void updateQuantity() {
        tvQuantity.setText(String.valueOf(quantity));
    }

    private void sendOrder() {
        String customerName = edtCustomerName.getText().toString().trim();
        boolean hasBacon = cbBacon.isChecked();
        boolean hasCheese = cbCheese.isChecked();
        boolean hasOnion = cbOnion.isChecked();

        if (customerName.isEmpty()) {
            Toast.makeText(this, "Por favor, informe seu nome antes de enviar.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (quantity <= 0) {
            Toast.makeText(this, "A quantidade deve ser maior que zero.", Toast.LENGTH_SHORT).show();
            return;
        }

        double totalPrice = calculatePrice(hasBacon, hasCheese, hasOnion, quantity);

        String summary = "Nome do cliente: "+customerName + "\n" +
                "Tem Bacon? "+(hasBacon?"Sim":"Não") + "\n" +
                "Tem Queijo? "+(hasCheese?"Sim":"Não") + "\n" +
                "Tem Onion Rings? "+(hasOnion?"Sim":"Não") + "\n" +
                "Quantidade: "+quantity + "\n" +
                "Preço final: R$ "+String.format("%.2f", totalPrice);

        tvOrderSummary.setText(summary);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pedidos@hamburgueriaz.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido de "+customerName);
        intent.putExtra(Intent.EXTRA_TEXT, summary);

        try {
            startActivity(Intent.createChooser(intent, "Escolha o app de e-mail"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Nenhum app de e-mail encontrado!", Toast.LENGTH_SHORT).show();
        }
    }

    private double calculatePrice(boolean bacon, boolean cheese, boolean onion, int qty) {
        double basePrice = 20;
        double extras = 0;

        if (bacon) extras += 2;
        if (cheese) extras += 2;
        if (onion) extras += 3;

        return (basePrice + extras) * qty;
    }
}
