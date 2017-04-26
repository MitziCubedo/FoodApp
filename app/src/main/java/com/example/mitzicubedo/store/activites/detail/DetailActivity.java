package com.example.mitzicubedo.store.activites.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mitzicubedo.store.R;
import com.example.mitzicubedo.store.activites.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MitziCubedo on 20/04/17.
 */

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_TODO_KEY = "STORE";
    int total;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setViews();
        populatePizzaType();

        sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = 0;

                if(!(String.valueOf(pizzaQuantity.getText()).isEmpty())) {
                    if (String.valueOf(pizzaSize.getSelectedItem()).equals("small")) {
                        total += (79 * Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                    } else if (String.valueOf(pizzaSize.getSelectedItem()).equals("medium")) {
                        total += (99 * Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                    } else {
                        total += (109 * Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                    }

                }
                if(!(String.valueOf(sodaQuantity.getText()).isEmpty())){
                    if (String.valueOf(sodaSize.getSelectedItem()).equals("small")) {
                        total += (19 * Integer.parseInt(String.valueOf(sodaQuantity.getText())));
                    } else if (String.valueOf(sodaSize.getSelectedItem()).equals("medium")) {
                        total += (29 * Integer.parseInt(String.valueOf(sodaQuantity.getText())));
                    } else {
                        total += (39 * Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                    }
                }
                Toast.makeText(DetailActivity.this,
                        "Thank you for you order, your total is "+ total + "pesos.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);

            }


        });


        /*addPizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = 0;
                if(String.valueOf(pizzaSize.getSelectedItem()).equals("small")){
                    total = (79*Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                }else if(String.valueOf(pizzaSize.getSelectedItem()).equals("medium")){
                    total = (99*Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                } else{
                    total = (109*Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                }
                Toast.makeText(DetailActivity.this,
                        "Thanks, you've ordered:\n" + pizzaQuantity.getText() + " " + String.valueOf(pizzaSize.getSelectedItem()) + " " + String.valueOf(pizzaType.getSelectedItem()) + " pizza(s).\n"
                        + "Your total is "+ total + "pesos.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);

            }


        });

        addSodaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(String.valueOf(sodaSize.getSelectedItem()).equals("small")){
                    total = (19*Integer.parseInt(String.valueOf(sodaQuantity.getText())));
                }else if(String.valueOf(sodaSize.getSelectedItem()).equals("medium")){
                    total = (29*Integer.parseInt(String.valueOf(sodaQuantity.getText())));
                } else{
                    total = (39*Integer.parseInt(String.valueOf(pizzaQuantity.getText())));
                }
                Toast.makeText(DetailActivity.this,
                        "Thanks, you've ordered:\n" + sodaQuantity.getText() + " " + String.valueOf(sodaSize.getSelectedItem()) + " " + String.valueOf(sodaFlavor.getSelectedItem()) + " soda(s).\n"
                                + "Your total is "+ total + "pesos.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }

        });*/
    }

    private TextView pizzaLabel;
    private Spinner pizzaType;
    private Spinner pizzaSize;
    private EditText pizzaQuantity;
    private CardView pizzaCardView;
    private TextView pizzaTypeLabel;
    private TextView pizzaSizeLabel;
    private TextView pizzaQuantityLabel;
    private Button addPizzaButton;

    private CardView sodaCardView;
    private Spinner sodaFlavor;
    private Spinner sodaSize;
    private TextView sodaLabel;
    private EditText sodaQuantity;
    private TextView sodaFlavorLabel;
    private TextView sodaSizeLabel;
    private TextView sodaQuantityLabel;
    private Button addSodaButton;
    private FloatingActionButton sendOrder;

    private void setViews() {
        pizzaCardView = (CardView) findViewById(R.id.pizza_cardView);
        pizzaLabel = (TextView) findViewById(R.id.pizza_label);
        pizzaQuantity = (EditText) findViewById(R.id.pizza_quantity);
        pizzaTypeLabel = (TextView) findViewById(R.id.pizza_type_label);
        pizzaSizeLabel = (TextView) findViewById(R.id.pizza_size_label);
        pizzaQuantityLabel = (TextView) findViewById(R.id.pizza_quantity_label);
        //addPizzaButton = (Button) findViewById(R.id.add_pizza);


        sodaCardView = (CardView) findViewById(R.id.soda_cardView);
        sodaLabel = (TextView) findViewById(R.id.soda_label);
        sodaQuantity = (EditText) findViewById(R.id.soda_quantity);
        sodaFlavorLabel = (TextView) findViewById(R.id.soda_flavor_label);
        sodaSizeLabel = (TextView) findViewById(R.id.soda_size_label);
        sodaQuantityLabel = (TextView) findViewById(R.id.soda_quantity_label);
        //addSodaButton = (Button) findViewById(R.id.add_soda);

        sendOrder = (FloatingActionButton) findViewById(R.id.send_order);

    }

    public void populatePizzaType() {
        pizzaSize = (Spinner) findViewById(R.id.pizza_size);
        List<String> pizzaSizeList = new ArrayList<String>();
        pizzaSizeList.add("small");
        pizzaSizeList.add("medium");
        pizzaSizeList.add("big");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, pizzaSizeList);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pizzaSize.setAdapter(dataAdapter1);

        pizzaType = (Spinner) findViewById(R.id.pizza_type);
        List<String> pizzaTypeList = new ArrayList<String>();
        pizzaTypeList.add("italian");
        pizzaTypeList.add("hawaiian");
        pizzaTypeList.add("mexican");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, pizzaTypeList);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pizzaType.setAdapter(dataAdapter2);

        sodaFlavor = (Spinner) findViewById(R.id.soda_flavor);
        List<String> sodaFlavorList = new ArrayList<String>();
        sodaFlavorList.add("sprite");
        sodaFlavorList.add("coke");
        sodaFlavorList.add("mountain dew");
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sodaFlavorList);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sodaFlavor.setAdapter(dataAdapter3);

        sodaSize = (Spinner) findViewById(R.id.soda_size);
        List<String> sodaSizeList = new ArrayList<String>();
        sodaSizeList.add("small");
        sodaSizeList.add("medium");
        sodaSizeList.add("big");
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sodaSizeList);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sodaSize.setAdapter(dataAdapter4);
    }
}
