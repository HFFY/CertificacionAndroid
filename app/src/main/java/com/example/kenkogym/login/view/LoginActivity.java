package com.example.kenkogym.login.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
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
import com.example.kenkogym.mussles.viewModel.MusselsViewModel;
import com.example.kenkogym.userCreation.view.UserCreationActivity;
import com.example.kenkogym.userMain.view.UserMainActivity;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.Exercise;
import com.example.kenkogym.utils.models.types.enumExercise;
import com.example.kenkogym.utils.models.userLogged;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG = LoginActivity.class.getSimpleName();
    private static final String SHARED = "SharedKenko";
    private static final String SHARED_BOOL = "SharedKenkoBool";
    private Context context;

    private LoginViewModel viewModel;
    private MusselsViewModel localViewModel;
    private ProgressDialog loadingDialog;
    String mail = "";

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
        localViewModel = new ViewModelProvider(this).get(MusselsViewModel.class);

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

        checkSaredPreferences();
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

                                    mail = emailEditText.getText().toString();
                                    Intent intent = new Intent(context, UserMainActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("Email",mail);
                                    intent.putExtras(bundle);
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
        loadingDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        registerText.setEnabled(false);
        loadingDialog.setMax(100);
        loadingDialog.setProgress(0);
        loadingDialog.show();

    }

    private void hideLoading(){
        loadingDialog.dismiss();
        registerText.setEnabled(true);
        loadingDialog.cancel();
    }

    private void checkSaredPreferences(){
        SharedPreferences prefs = getSharedPreferences(SHARED, MODE_PRIVATE);
        Boolean hasShared = prefs.getBoolean(SHARED_BOOL,false);
        if(!hasShared){
            SharedPreferences.Editor settingsEditor = prefs.edit();
            settingsEditor.putBoolean(SHARED_BOOL,true);
            settingsEditor.commit();
            insertToDataBase();
        }
    }


    private void insertToDataBase(){
        Exercise ex1= new Exercise("1","Abdominales", enumExercise.ABS,1);
        Exercise ex2= new Exercise("2","Flexiones", enumExercise.ABS,2);
        Exercise ex3= new Exercise("3","Pesas", enumExercise.BICEP,3);
        Exercise ex4= new Exercise("4","Mancuernas", enumExercise.BICEP,4);
        Exercise ex5= new Exercise("5","Cuadriceps", enumExercise.LEGS,5);
        Exercise ex6= new Exercise("6","Bicicleta", enumExercise.CARDIO,6);
        Exercise ex7= new Exercise("7","Triceps", enumExercise.ARMS,7);
        Exercise ex8= new Exercise("8","Resistencia", enumExercise.BACK,8);
        localViewModel.registerExercise(ex1);
        localViewModel.registerExercise(ex2);
        localViewModel.registerExercise(ex3);
        localViewModel.registerExercise(ex4);
        localViewModel.registerExercise(ex5);
        localViewModel.registerExercise(ex6);
        localViewModel.registerExercise(ex7);
        localViewModel.registerExercise(ex8);
    }
}
