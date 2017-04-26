package com.example.mitzicubedo.store.activites;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mitzicubedo.store.R;
import com.example.mitzicubedo.store.activites.detail.DetailActivity;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addItem;
    private FloatingActionButton sendOrder;
    private RecyclerView itemRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItem = (FloatingActionButton) findViewById(R.id.add);
        sendOrder = (FloatingActionButton) findViewById(R.id.send_order);
        itemRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}
