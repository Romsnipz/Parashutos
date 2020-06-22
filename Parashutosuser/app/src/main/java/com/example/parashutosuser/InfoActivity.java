package com.example.parashutosuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parashutosuser.rest.DTOs.InfoHTTPDto;
import com.example.parashutosuser.rest.DTOs.UserHTTPDto;
import com.example.parashutosuser.rest.LoginApi;
import com.example.parashutosuser.rest.NetworkService;

import java.net.HttpURLConnection;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {

    private EditText editTextNick2;
    private EditText editSurName;
    private EditText editFirstName;
    private EditText editSecondName;
    private EditText editTextDate;
    private EditText editCity;
    private EditText editDropzone;
    private EditText editQuantity;
    private Button buttonsave;
    private Button buttonedit;
    private Button buttoncancel2;


    Bundle savedInstanceState;
    private List<EditText> infoTextEdits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.info_activity);

        editTextNick2 = (EditText) findViewById(R.id.editTextNick2);
        UserHTTPDto user = (UserHTTPDto) getIntent().getSerializableExtra("user");
        editTextNick2.setText(user.getUserNickname());
        editTextNick2.setEnabled(false);

        InfoHTTPDto info = (InfoHTTPDto) getIntent().getSerializableExtra("info");
        editSurName = (EditText) findViewById(R.id.editSurName);
        editSurName.setText(info.getSurName());
        editFirstName = (EditText) findViewById(R.id.editFirstName);
        editFirstName.setText(info.getFirstName());
        editSecondName = (EditText) findViewById(R.id.editSecondName);
        editSecondName.setText(info.getSecondName());
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        String date = null;
        if (info.getBirthday() != null) {
            SimpleDateFormat datebirz = new SimpleDateFormat("dd.mm.yyyy");
            try {
                date = datebirz.format(info.getBirthday());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        editTextDate.setText(date);
        editCity = (EditText) findViewById(R.id.editCity);
        editCity.setText(info.getCity());
        editDropzone = (EditText) findViewById(R.id.editDropzone);
        editDropzone.setText(info.getDropzone());
        editQuantity = (EditText) findViewById(R.id.editQuantity);
        editQuantity.setText(info.getQuantity());
        buttonsave = (Button) findViewById(R.id.buttonsave);
        buttonedit = (Button) findViewById(R.id.buttonedit);
        buttonedit.requestFocus();
        buttoncancel2 = (Button) findViewById(R.id.buttoncancel2);

        editTextList();
        checkTextEnable(false);

        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttoncancel2.setClickable(true);
                checkTextEnable(false);

                InfoHTTPDto request = new InfoHTTPDto();
                request.setUserNickname(user.getUserNickname());
                request.setSurName(editSurName.getText().toString());
                request.setFirstName(editFirstName.getText().toString());
                request.setSecondName(editSecondName.getText().toString());

                Date date = null;
                if (!editTextDate.getText().toString().equals("")) {
                    SimpleDateFormat datebirz = new SimpleDateFormat("dd.mm.yyyy");
                    try {
                        date = datebirz.parse(editTextDate.getText().toString());
                    } catch (ParseException e) {
                        Toast.makeText(InfoActivity.this, getText(R.string.dateex),
                                Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        return;
                    }
                }
                request.setBirthday(date != null ? date.getTime() : null);

                request.setCity(editCity.getText().toString());
                request.setDropzone(editDropzone.getText().toString());
                request.setQuantity(editQuantity.getText().toString());

                doSave(request);
            }
        });

        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttoncancel2.setClickable(false);
                checkTextEnable(true);

            }
        });

        buttoncancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentgoto = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intentgoto);
            }
        });

    }

    private void doSave (InfoHTTPDto request) {
        LoginApi loginApi = NetworkService.getInstance().getLoginApi();
        Call call = loginApi.save(request);
        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (HttpURLConnection.HTTP_OK != response.code()) {
                    Toast.makeText(InfoActivity.this, getText(R.string.ipdead),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Saveclass.setInfo(request);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(InfoActivity.this, getText(R.string.ipdead),
                        Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }

    public void editTextList() {
        infoTextEdits = Arrays.asList(
            editSurName,
            editFirstName,
            editSecondName,
            editTextDate,
            editCity,
            editDropzone,
                editQuantity
        );
    }

    public void checkTextEnable(boolean check) {
        if (!check) {
            infoTextEdits.forEach(i -> {
                i.setEnabled(false);
            });
        } else {
            infoTextEdits.forEach(i -> {
                i.setEnabled(true);
            });
        }
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
                Intent intent = new Intent(InfoActivity.this, RegActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                Intent intent1 = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
