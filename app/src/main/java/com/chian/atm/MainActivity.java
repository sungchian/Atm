package com.chian.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_LOGIN = 102;
    private final static int REQUST_USERINFO = 105;
    boolean logan = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_LOGIN:
                if (resultCode == RESULT_OK){
                    String userid = data.getStringExtra("EXTRA_USERID");
                    Toast.makeText(this, "Login userid: "+userid,Toast.LENGTH_LONG).show();
                    getSharedPreferences("atm", MODE_PRIVATE)
                            .edit()
                            .putString("USERID", userid)
                            .apply();
                    }else{
                    finish();
                }
                break;
            case REQUST_USERINFO:
                if (requestCode == RESULT_OK){
                    String name = data.getStringExtra("EXTRA_NAME");
                    String phone = data.getStringExtra("EXTRA_PHONE");
                    Toast.makeText(this, "NICKNAME: "+name,Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "PHONE: "+phone,Toast.LENGTH_LONG).show();
                }
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logan){
            Intent intent = new Intent(this , LoginActivity.class);
            startActivityForResult(intent, REQUEST_LOGIN);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
