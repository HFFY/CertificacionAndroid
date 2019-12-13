package com.example.kenkogym.userCreation.view;

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
import android.widget.Toast;

import com.example.kenkogym.R;
import com.example.kenkogym.login.view.LoginActivity;
import com.example.kenkogym.login.viewModel.LoginViewModel;
import com.example.kenkogym.userCreation.viewModel.UserCreationViewModel;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.userLogged;

public class UserCreationActivity extends AppCompatActivity {


    private Context context;
    private UserCreationViewModel viewModel;
    private ProgressDialog loadingDialog;

    EditText editTextUser, editTextEmail, editTextPssw, editTextPsswdConfirmation;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        getSupportActionBar().hide();
        viewModel = new ViewModelProvider(this).get(UserCreationViewModel.class);
        this.context = this;
        editTextUser = findViewById(R.id.edit_creation_user);
        editTextEmail = findViewById(R.id.edit_creation_email);
        editTextPssw = findViewById(R.id.edit_creation_password);
        editTextPsswdConfirmation = findViewById(R.id.edit_creation_password_confirmation);
        buttonSend = findViewById(R.id.button_creation_send);
        initEvents();
    }

    private void initEvents() {
        this.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                String user = editTextUser.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPssw.getText().toString();
                String passwordconfimation = editTextPsswdConfirmation.getText().toString();
                if (!email.isEmpty() && !password.isEmpty() && !user.isEmpty() && !passwordconfimation.isEmpty()) {
                    if (email.contains("@")) {
                        if (password.equals(passwordconfimation)) {
                            LiveData<Base> result = viewModel.createUser(user,email,password);
                            result.observe(UserCreationActivity.this, new Observer<Base>() {
                                @Override
                                public void onChanged(Base base) {
                                    hideLoading();
                                    if (base.isSuccess()) {
                                        Log.e("Sucess","La logro");
                                        userLogged userLogged = (userLogged) base.getData();

                                        Toast.makeText(context,
                                                "Usuario Creado",
                                                Toast.LENGTH_SHORT)
                                                .show();

                                        Intent intent = new Intent(context, LoginActivity.class);
                                        startActivity(intent);
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
                                    "Contrasenas no iguales",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }

                    } else {
                        editTextPssw.setError(getString(R.string.login_invalid_email));
                        Toast.makeText(context,
                                "Correo Incorrecto",
                                Toast.LENGTH_SHORT)
                                .show();
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
