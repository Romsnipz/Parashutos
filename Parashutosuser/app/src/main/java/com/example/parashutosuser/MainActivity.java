package com.example.parashutosuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonweather;
    private Button buttonjump;
    private Button buttoninfo;
    private Button buttonhistory;

    Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_main);

        buttonweather = (Button) findViewById(R.id.buttonweather);
        buttonjump = (Button) findViewById(R.id.buttonjump);
        buttoninfo = (Button) findViewById(R.id.buttoninfo);
        buttonhistory = (Button) findViewById(R.id.buttonhistory);

        buttonweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

        buttonjump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MathmodActivity.class);
                startActivity(intent);
            }
        });

        buttoninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("user", Saveclass.getUser());
                intent.putExtra("info", Saveclass.getInfo());
                startActivity(intent);
            }
        });

        buttonhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings1:
                Intent intent = new Intent(MainActivity.this, RegActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
