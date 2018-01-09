package com.chian.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddrActivity extends AppCompatActivity {

    private Spinner County;
    private Spinner area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        County = (Spinner) findViewById(R.id.County);
        area = (Spinner) findViewById(R.id.area);
        final ArrayList<String> data2 = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, new String[]{"基隆市", "新北市", "台北市"});
        County.setAdapter(adapter);
        County.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        String[] data = null;
                        if (position == 0){
                            data = new String[]{"中正區","暖暖區","八堵區"};
                    }
                        if (position == 1){
                            data = new String[]{"永和區","板橋區","新莊區"};
                        }
                        if (position == 2){
                            data = new String[]{"信義區","大安區","士林區"};
                        }
        ArrayAdapter adapter1 = new ArrayAdapter(AddrActivity.this, android.R.layout.simple_list_item_1,data);
                        area.setAdapter(adapter1);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );

    }
    public void add (View view){
        Intent intent = new Intent(this, AddrActivity.class);
        startActivity(intent);
        int age = Integer.parseInt(County.getSelectedItem().toString());
    }
}
