package com.example.parashutosuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MathmodActivity extends AppCompatActivity {

    private ImageView imageViewNebo;
    private ImageView imageViewPlane;

    Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.mathmod_activity);

        imageViewNebo = (ImageView) findViewById(R.id.imageViewNebo);
        imageViewPlane = (ImageView) findViewById(R.id.imageViewPlane);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings1:
                Intent intent = new Intent(MathmodActivity.this, RegActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                Intent intent1 = new Intent(MathmodActivity.this, MainActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
