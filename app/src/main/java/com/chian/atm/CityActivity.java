package com.chian.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView city;
    private String[] cities;
    public static final String TAG = CityActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        city = (ListView) findViewById(R.id.city);
        cities = new String[]{"基隆市", "新北市" , "台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        city.setAdapter(adapter);
        city.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d(TAG, "onItemClick: " + position + "/" + cities[position]);
        String[] data = null;
        if (position == 0){
            data = new String[]{"中正區","暖暖區","八堵區"};
        }
        

    }
}
