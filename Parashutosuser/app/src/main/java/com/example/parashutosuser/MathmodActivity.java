package com.example.parashutosuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathmodActivity extends AppCompatActivity {

    private ImageView imageViewNebo;
    private ImageView imageViewPlane;
    private EditText editTextMassa;
    private EditText editTextMassa2;
    private EditText editTextRost;
    private EditText editTextHightmax;
    private EditText editTextTime;
    private TextView textViewOtvet;
    private TextView textViewResult;
    private ImageButton imageButtonOtvet;
    private Spinner spinner;

    double Cx;

    Bundle savedInstanceState;
    private List<EditText> mathEdits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.mathmod_activity);

        imageViewNebo = (ImageView) findViewById(R.id.imageViewNebo);
        imageViewPlane = (ImageView) findViewById(R.id.imageViewPlane);
        editTextMassa = (EditText) findViewById(R.id.editTextMassa);
        editTextMassa2 = (EditText) findViewById(R.id.editTextMassa2);
        editTextRost = (EditText) findViewById(R.id.editTextRost);
        editTextHightmax = (EditText) findViewById(R.id.editTextHightmax);
        editTextTime = (EditText) findViewById(R.id.editTextTime);
        textViewOtvet = (TextView) findViewById(R.id.textViewOtvet);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        imageButtonOtvet = (ImageButton) findViewById(R.id.imageButtonOtvet);
        spinner = (Spinner) findViewById(R.id.spinner);

        editTextList2();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Cx = 0.0975;
                } else if (position == 1) {
                    Cx = 0.195;
                } else {
                    Cx = 0.2125;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        imageButtonOtvet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkOnNull()) {
                    textViewResult.setText(R.string.incorrect);
                    textViewOtvet.setText(R.string.incorrect);
                    return;
                }

                double maxSpeed, hightOpen;
                double St, G, a, hightMaxSpeed, timeHMS, timeCritOpen;
                double MassaP, Massa2E, Rost, Hightmax, Time;
                final double g = 9.81;
                final double p = 1.25;

                String MP = editTextMassa.getText().toString();
                String M2E = editTextMassa2.getText().toString();
                String Rs = editTextRost.getText().toString();
                String Hm = editTextHightmax.getText().toString();
                String T = editTextTime.getText().toString();

                MassaP = Double.parseDouble(MP);
                Massa2E = Double.parseDouble(M2E);
                Rost = Double.parseDouble(Rs);
                Hightmax = Double.parseDouble(Hm);
                Time = Double.parseDouble(T);

                St = Math.pow(Rost,2);
                G = (MassaP + Massa2E)*g;

                maxSpeed = Math.sqrt((2*G)/(p*Cx*St));

                a = g - g*(p*Cx*St);

                if (Hightmax >= 200 && Hightmax < 1000) {
                    timeCritOpen = Math.sqrt(2*(Hightmax-200)/a);
                    String TT = String.format("%.2f", timeCritOpen);
                    if (timeCritOpen > Time) {
                        textViewResult.setText("Максимальная скорость не будет достигнута. Крайнее время открытия через " + TT + " c" );
                    } else {
                        textViewResult.setText("Максимальная скорость не будет достигнута. С вашим временем полёт будет до земли. Крайнее время открытия через " + TT + " c");
                    }
                } else if (Hightmax >= 1000 && Hightmax < 2000) {
                    timeHMS = 12;
                    timeCritOpen = Math.sqrt(2*(Hightmax-300)/a);
                    String TT = String.format("%.2f", timeCritOpen);
                    hightMaxSpeed = Hightmax - a * Math.pow(timeHMS,2)/2;
                    String HMS = String.format("%.2f", hightMaxSpeed);
                    if (timeCritOpen > Time) {
                        textViewResult.setText("Максимальная скорость будет достигнута на высоте " + HMS + " м " + "Крайнее время открытия через " + TT + " c");
                    } else {
                        textViewResult.setText("Максимальная скорость будет достигнута на высоте " + HMS + " м " + "С вашим временем полёт будет до земли. Крайнее время открытия через " + TT + " c");
                    }
                } else if (Hightmax >= 2000 && Hightmax < 4000) {
                    timeHMS = 12.5;
                    timeCritOpen = Math.sqrt(2*(Hightmax-350)/a);
                    String TT = String.format("%.2f", timeCritOpen);
                    hightMaxSpeed = Hightmax - a * Math.pow(timeHMS,2)/2;
                    String HMS = String.format("%.2f", hightMaxSpeed);
                    if (timeCritOpen > Time) {
                        textViewResult.setText("Максимальная скорость будет достигнута на высоте " + HMS + " м " + "Крайнее время открытия через " + TT + " c");
                    } else {
                        textViewResult.setText("Максимальная скорость будет достигнута на высоте " + HMS + " м " + "С вашим временем полёт будет до земли. Крайнее время открытия через " + TT + " c");
                    }
                } else if (Hightmax >= 4000){
                    timeHMS = 14;
                    timeCritOpen = Math.sqrt(2*(Hightmax-400)/a);
                    String TT = String.format("%.2f", timeCritOpen);
                    hightMaxSpeed = Hightmax - a * Math.pow(timeHMS,2)/2;
                    String HMS = String.format("%.2f", hightMaxSpeed);
                    if (timeCritOpen > Time) {
                        textViewResult.setText("Максимальная скорость будет достигнута на высоте " + HMS + " м " + "Крайнее время открытия через " + TT + " c");
                    } else {
                        textViewResult.setText("Максимальная скорость будет достигнута на высоте " + HMS + " м " + "С вашим временем полёт будет до земли. Крайнее время открытия через " + TT + " c");
                    }
                } else {
                    Toast.makeText(MathmodActivity.this, getText(R.string.incorrect),
                            Toast.LENGTH_SHORT).show();
                }

                String MS = String.format("%.2f", maxSpeed);

                textViewOtvet.setText(MS + " м/с");
            }
        });
    }

    public void editTextList2() {
        mathEdits = Arrays.asList(
                editTextMassa,
                editTextMassa2,
                editTextHightmax,
                editTextTime
        );
    }

    public boolean checkOnNull() {
        for (EditText i : mathEdits) {
            if (i.getText().toString().equals("")) {
                return false;
            }
        }
        return true;
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
