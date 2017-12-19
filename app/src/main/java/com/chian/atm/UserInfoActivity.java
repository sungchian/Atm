package com.chian.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private static final String TAG = UserInfoActivity.class.getSimpleName();
    private EditText edName;
    private EditText edPhone;
    private Spinner ages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edName = (EditText) findViewById(R.id.ed_name);
        edPhone = (EditText) findViewById(R.id.ed_phone);
        String name = getSharedPreferences("info", MODE_PRIVATE).getString("NAME","");
        String phone = getSharedPreferences("info", MODE_PRIVATE).getString("PHONE","");
        edName.setText(name);
        edPhone.setText(phone);
        ages = (Spinner) findViewById(R.id.ages);
        ArrayList<String> data = new ArrayList<>();
    //   for(int i = 15; i<=40; i++){
    //        data.add(i + "");
    //    }
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.ages, android.R.layout.simple_list_item_1);
        ages.setAdapter(adapter);
    }
    public void ok(View view){
        Log.d(TAG, "ok: " + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        String name = edName.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", name);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}
