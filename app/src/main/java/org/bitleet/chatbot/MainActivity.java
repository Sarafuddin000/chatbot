package org.bitleet.chatbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextEmail, editTextPassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.support.compat.R.layout.activity_main);

    editTextEmail = findViewById(R.id.editTextEmail);
    editTextPassword = findViewById(R.id.editTextPassword);
    progressBar = findViewById(R.id.progressbar);

        Button button = findViewById(R.id.buttonGoSignup);
        button.setOnClickListener(this);
    }


    private void userLogin() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is Required");
            editTextEmail.requestFocus();
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email address.");
            editTextEmail.requestFocus();
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password Required");
            editTextPassword.requestFocus();
        }

        if (password.length() < 6){
            editTextPassword.setError("Minimum Length of password should be 6.");
            editTextPassword.requestFocus();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonGoSignup:
                Intent SingupPage = new Intent(MainActivity.this, Signup.class);
                startActivity(SingupPage);
                break;

            case R.id.butonLogin:
                userLogin();
                break;
        }


    }
}
