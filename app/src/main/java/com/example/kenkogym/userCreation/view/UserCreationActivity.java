package com.example.kenkogym.userCreation.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.kenkogym.R;
import com.example.kenkogym.login.view.LoginActivity;
import com.example.kenkogym.userCreation.viewModel.UserCreationViewModel;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;
import com.example.kenkogym.utils.models.types.enumUser;
import com.example.kenkogym.utils.models.userLogged;

import java.util.ArrayList;

public class UserCreationActivity extends AppCompatActivity {


    private Context context;
    private UserCreationViewModel viewModel;
    private ProgressDialog loadingDialog;
    private CheckBox checkBoxTrainer;

    EditText editTextUserName, editTextUserWeight, editTextUserHeight, editTextUserAge, editTextEmail, editTextPssw, editTextPsswdConfirmation;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        getSupportActionBar().hide();
        viewModel = new ViewModelProvider(this).get(UserCreationViewModel.class);
        this.context = this;
        editTextUserName = findViewById(R.id.edit_creation_user_name);
        editTextUserWeight = findViewById(R.id.edit_user_weight);
        editTextUserHeight = findViewById(R.id.edit_user_height);
        editTextUserAge = findViewById(R.id.edit_user_height);
        editTextEmail = findViewById(R.id.edit_creation_email);
        editTextPssw = findViewById(R.id.edit_creation_password);
        editTextPsswdConfirmation = findViewById(R.id.edit_creation_password_confirmation);
        buttonSend = findViewById(R.id.button_creation_send);
        checkBoxTrainer = findViewById(R.id.check_im_trainer);
        initEvents();
    }

    private void initEvents() {
        this.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                String userName = editTextUserName.getText().toString();
                String userWeigth = editTextUserWeight.getText().toString();
                String userHeigth = editTextUserHeight.getText().toString();
                String userAge = editTextUserAge.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPssw.getText().toString();
                String passwordconfimation = editTextPsswdConfirmation.getText().toString();
                enumUser type=enumUser.STUDENT;
                if (!email.isEmpty() && !password.isEmpty() &&  !userName.isEmpty() && !userWeigth.isEmpty() &&
                        !userHeigth.isEmpty() && !userAge.isEmpty() && !passwordconfimation.isEmpty()) {
                    if (email.contains("@")) {
                        if (password.equals(passwordconfimation)) {
                            if(checkBoxTrainer.isChecked()){
                                type=enumUser.TRAINER;
                            }
                            else{
                                type=enumUser.STUDENT;
                            }

                            LiveData<Base> result = viewModel.createUser(email, password);
                            result.observe(UserCreationActivity.this, new Observer<Base>() {
                                @Override
                                public void onChanged(Base base) {
                                    hideLoading();
                                    if (base.isSuccess()) {
                                        Log.e("Sucess", "La logro");
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
                ArrayList<String> list=new ArrayList<>();
                User user = new User(type,userName,email,password,Integer.parseInt(userAge),Integer.parseInt(userWeigth),Integer.parseInt(userHeigth), list);
                viewModel.insertUser(user);
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

    private void hideLoading() {
        loadingDialog.dismiss();
        loadingDialog.cancel();
    }
}
