package com.example.kenkogym.userCreation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.kenkogym.R;

public class UserCreationActivity extends AppCompatActivity {

    EditText editTextUser, editTextEmail, editTextPssw, editTextPsswdConfirmation;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        editTextUser = findViewById(R.id.edit_creation_user);
        editTextEmail = findViewById(R.id.edit_creation_email);
        editTextPssw = findViewById(R.id.edit_creation_password);
        editTextPsswdConfirmation = findViewById(R.id.edit_creation_password_confirmation);
        buttonSend = findViewById(R.id.button_creation_send);
    }
}
