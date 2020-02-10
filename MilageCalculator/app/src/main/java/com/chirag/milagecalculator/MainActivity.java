package com.chirag.milagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText price , distance , fuel;
    public Button btn;
    public TextView res1,res2,res3;
    public double total_fuel_price,Mileage,one_km;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        price=findViewById(R.id.fp);
        distance=findViewById(R.id.tk);
        fuel=findViewById(R.id.tf);
        btn=findViewById(R.id.calculate);
        res1=findViewById(R.id.result1);
        res2=findViewById(R.id.result2);
        res3=findViewById(R.id.result3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(price.getText().toString().equals("")||distance.getText().toString().equals("")||fuel.getText().toString().equals("")){
                    res1.setText("Total Fuel Price = ");
                    res2.setText("Mileage = ");
                    res3.setText("1 KM = ");
                    Toast.makeText(MainActivity.this,"Please enter price distance and fuel quantity",Toast.LENGTH_LONG).show();
                }
                else{
                    res3.setText("");
                    res2.setText("");
                    res1.setText("");
                    total_fuel_price=Double.parseDouble(price.getText().toString())*Double.parseDouble(fuel.getText().toString());
                    Mileage=Double.parseDouble(distance.getText().toString())/Double.parseDouble(fuel.getText().toString());
                    one_km=Double.parseDouble(price.getText().toString())/Mileage;
                    res1.append("Total Fuel Price = "+String.valueOf(total_fuel_price)+" RS");
                    res2.append("Mileage = "+String.valueOf(Mileage)+" Kmpl ");
                    res3.append("1 KM = "+String.valueOf(one_km)+" RS ");
                }
            }
        });
    }
}
