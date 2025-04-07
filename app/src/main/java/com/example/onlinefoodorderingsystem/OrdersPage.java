package com.example.onlinefoodorderingsystem;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class OrdersPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private List<String> items; // Adjust the data type as necessary

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        recyclerView = findViewById(R.id.recyclerViewOrders);
        items = new ArrayList<>(); // Populate your list
        // Example data - replace this with your actual data source
        items.add("Pizza");
        items.add("Burger");
        items.add("Pasta");

        orderAdapter = new OrderAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderAdapter);
    }

    class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
        private List<String> items;

        OrderAdapter(List<String> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
            return new OrderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
            String item = items.get(position);
            holder.textItemName.setText(item);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class OrderViewHolder extends RecyclerView.ViewHolder {
            TextView textItemName;
            Button buttonAddToCart;

            public OrderViewHolder(@NonNull View itemView) {
                super(itemView);
                textItemName = itemView.findViewById(R.id.textItemName);
                buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart);
            }
        }
    }
}

