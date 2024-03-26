package com.example.secondapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String login = "admin";
    private String password = "admin";
    private TextView textWelcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonSignUp = findViewById(R.id.btn_signup);
        editTextEmail.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);
        textWelcome = findViewById(R.id.text_welcome);




        buttonSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String pass = editTextPassword.getText().toString();
                if (email.equals(login)  && pass.equals(password)){
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    hideAllViewsExceptOne(textWelcome);
                }else{
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkField();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void checkField(){
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonSignup = findViewById(R.id.btn_signup);

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            buttonSignup.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.orange));
        }else{
            buttonSignup.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.grey));
        }
    }
    private void hideAllViewsExceptOne(TextView textViewToKeepVisible) {
        ViewGroup mainLayout = findViewById(R.id.main);
        for (int i = 0; i < mainLayout.getChildCount(); i++) {
            View childView = mainLayout.getChildAt(i);
            if (childView == textViewToKeepVisible) {
                childView.setVisibility(View.VISIBLE);
            } else {
                childView.setVisibility(View.GONE);
            }
        }
    }

}

