package com.example.kenkogym.login.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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

import com.example.kenkogym.R;
import com.example.kenkogym.login.viewModel.LoginViewModel;
import com.example.kenkogym.main.view.MainActivity;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.userLogged;
//import com.google.gson.Gson;

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
        this.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(LOG, "Click en boton");
                final String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                Log.e(LOG, "email" + email);

                if (!email.isEmpty() && !password.isEmpty()) {
                    if (!email.contains("@")) {
                        emailEditText.setError(getString(R.string.login_invalid_email));
                    }

                    //new LongLogin().execute(new UserAux(email, password));
                    showLoading();
                    LiveData<Base> result = viewModel.login(email, password);
                    result.observe(LoginActivity.this, new Observer<Base>() {
                        @Override
                        public void onChanged(Base base) {
                            if (base.isSuccess()) {
                                userLogged userLogged = (userLogged) base.getData();
                                //String json = new Gson().toJson(userLogged);

                                Toast.makeText(context,
                                        getString(R.string.login_welcome, userLogged.getEmail()),
                                        Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent = new Intent(context, MainActivity.class);
                                //intent.putExtra(Constants.INTENT_KEY_USER_LOGGED, json);
                                startActivity(intent);

                                //executeLongAction();

                            } else {
                                Toast.makeText(context,
                                        base.getMessage(),
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
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
}
