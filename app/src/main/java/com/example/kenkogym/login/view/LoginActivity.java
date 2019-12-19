package com.example.kenkogym.login.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.kenkogym.R;
import com.example.kenkogym.login.viewModel.LoginViewModel;
import com.example.kenkogym.userCreation.view.UserCreationActivity;
import com.example.kenkogym.userMain.view.UserMainActivity;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.userLogged;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG = LoginActivity.class.getSimpleName();

    private Context context;

    private LoginViewModel viewModel;
    private ProgressDialog loadingDialog;

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView registerText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Log.e(LOG, "creado");

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        this.context = this;
        initUI();
        initEvents();

        Intent intent = getIntent();
        if (intent.hasExtra("message")) {
            String message = intent.getStringExtra("message");
            Toast.makeText(this, // Context, origen
                    message, //Mensaje
                    Toast.LENGTH_SHORT) //Duración
                    .show();
        }
    }

    private void initUI() {
        this.emailEditText = findViewById(R.id.text_view_login_email);
        this.passwordEditText = findViewById(R.id.text_view_login_password);
        this.sendButton = findViewById(R.id.button_login_send);
        this.registerText = findViewById(R.id.text_view_login_create);
    }

    private void initEvents() {
        this.registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Registro","Click");
                Intent intent = new Intent(context, UserCreationActivity.class);
                startActivity(intent);
            }
        });


        this.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    if (!email.contains("@")) {
                        emailEditText.setError(getString(R.string.login_invalid_email));
                        Toast.makeText(context,
                                "Correo Incorrecto",
                                Toast.LENGTH_SHORT)
                                .show();
                    } else {

                        //new LongLogin().execute(new UserAux(email, password));
                        showLoading();
                        LiveData<Base> result = viewModel.login(email, password);
                        result.observe(LoginActivity.this, new Observer<Base>() {
                            @Override
                            public void onChanged(Base base) {
                                hideLoading();
                                if (base.isSuccess()) {
                                    userLogged userLogged = (userLogged) base.getData();
                                    //String json = new Gson().toJson(userLogged);

                                    Toast.makeText(context,
                                            getString(R.string.login_welcome, userLogged.getEmail()),
                                            Toast.LENGTH_SHORT)
                                            .show();

                                    Intent intent = new Intent(context, UserMainActivity.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(context,
                                            base.getMessage(),
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }
                        });
                    }
                } else {
                    Toast.makeText(context,
                            R.string.login_empty,
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void showLoading() {
        loadingDialog = new ProgressDialog(context);
        loadingDialog.setMessage("Loading");
        loadingDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        loadingDialog.setMax(100);
        loadingDialog.setProgress(0);
        loadingDialog.show();
    }

    private void hideLoading(){
        loadingDialog.dismiss();
        loadingDialog.cancel();
    }
}
