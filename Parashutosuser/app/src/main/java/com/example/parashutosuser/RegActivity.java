package com.example.parashutosuser;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.parashutosuser.rest.DTOs.LoginPair;
import com.example.parashutosuser.rest.DTOs.UserHTTPDto;
import com.example.parashutosuser.rest.LoginApi;
import com.example.parashutosuser.rest.NetworkService;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegActivity extends AppCompatActivity {

    private EditText editEmailAddress;
    private EditText editTextNick;
    private EditText editTextPassword;
    private Button buttonok;
    private Button buttoncancel;
    private Button buttonreg;
    private Button buttongoodreg;
    private Switch switchopen;
    private ProgressBar progressBarOk;

    Bundle savedInstanceState;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.reg_activity);

        editEmailAddress = (EditText) findViewById(R.id.editEmailAddress);
        editTextNick = (EditText) findViewById(R.id.editTextNick);
        editTextNick.setVisibility(View.GONE);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonok = (Button) findViewById(R.id.buttonok);
        buttonreg = (Button) findViewById(R.id.buttonreg);
        buttoncancel = (Button) findViewById(R.id.buttoncancel);
        buttongoodreg = (Button) findViewById(R.id.buttongoodreg);
        buttongoodreg.setVisibility(View.GONE);
        switchopen = (Switch) findViewById(R.id.switchopen);

        progressBarOk = (ProgressBar) findViewById(R.id.progressBarOk);
        progressBarOk.setVisibility(View.GONE);

        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = editEmailAddress.getText().toString();
                String userPassword = editTextPassword.getText().toString();
                doLogin(userEmail, userPassword);
            }
        });

        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    editTextNick.setVisibility(View.VISIBLE);
                    buttongoodreg.setVisibility(View.VISIBLE);
                    buttonreg.setText(getResources().getString(R.string.back));
                    buttonok.setClickable(false);
                    flag = false;
                } else {
                    buttonreg.setText(getResources().getString(R.string.registration_button));
                    buttongoodreg.setVisibility(View.GONE);
                    editTextNick.setVisibility(View.GONE);
                    buttonok.setClickable(true);
                    flag = true;
                }
            }
        });

        buttongoodreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserHTTPDto request = new UserHTTPDto();
                request.setUserEmail(editEmailAddress.getText().toString());
                request.setUserNickname(editTextNick.getText().toString());
                request.setUserPassword(editTextPassword.getText().toString());

                doRegistration(request);

                buttonreg.setText(getResources().getString(R.string.registration_button));
                buttongoodreg.setVisibility(View.GONE);
                editTextNick.setVisibility(View.GONE);
                buttonok.setClickable(true);
            }
        });

        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    buttonreg.setText(getResources().getString(R.string.registration_button));
                    buttongoodreg.setVisibility(View.GONE);
                    editTextNick.setVisibility(View.GONE);
                    buttonok.setClickable(true);
                    flag = true;
                }
            }
        });

        switchopen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    private void doLogin(String userEmail, String userPassword) {
        progressBarOk.setVisibility(View.VISIBLE);
        LoginApi loginApi = NetworkService.getInstance().getLoginApi();
        Call call = loginApi.login(userEmail, userPassword);
        call.enqueue(new Callback<LoginPair>() {
            @Override
            public void onResponse(@NonNull Call<LoginPair> call, @NonNull Response<LoginPair> response) {
                progressBarOk.setVisibility(View.GONE);
                if (HttpURLConnection.HTTP_OK != response.code()) {
                    Toast.makeText(RegActivity.this, getText(R.string.ipdead),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                LoginPair pair = response.body();
                String status = pair.getStatus();
                if (status.equals(LoginStatusEnum.SUCCES.getStatus())) {
                    Saveclass.setUser(pair.getUser());
                    Saveclass.setInfo(pair.getInfo());
                    Intent intent = new Intent(RegActivity.this, MainActivity.class);
                    intent.putExtra("user", Saveclass.getUser());
                    intent.putExtra("info", Saveclass.getInfo());
                    startActivity(intent);
                } else if (status.equals(LoginStatusEnum.CLIENT_NOT_FOUND.getStatus())) {
                    Toast.makeText(RegActivity.this, getText(R.string.user_not_found),
                            Toast.LENGTH_SHORT).show();
                } else if (status.equals(LoginStatusEnum.INCORRECT_PASSWORD.getStatus())) {
                    Toast.makeText(RegActivity.this, getText(R.string.incorrect_password),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                progressBarOk.setVisibility(View.GONE);
                Toast.makeText(RegActivity.this, getText(R.string.ipdead),
                        Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void doRegistration(UserHTTPDto request) {
        progressBarOk.setVisibility(View.VISIBLE);
        LoginApi loginApi = NetworkService.getInstance().getLoginApi();
        Call call = loginApi.registeration(request);
        call.enqueue(new Callback<LoginPair>() {
            @Override
            public void onResponse(Call<LoginPair> call, Response<LoginPair> response) {
                progressBarOk.setVisibility(View.GONE);
                if (HttpURLConnection.HTTP_OK != response.code()) {
                    Toast.makeText(RegActivity.this, getText(R.string.ipdead),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<LoginPair> call, Throwable t) {
                progressBarOk.setVisibility(View.GONE);
                Toast.makeText(RegActivity.this, getText(R.string.ipdead),
                        Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

}
