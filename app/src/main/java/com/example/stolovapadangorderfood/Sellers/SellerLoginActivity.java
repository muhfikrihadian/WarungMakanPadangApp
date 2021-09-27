package com.example.stolovapadangorderfood.Sellers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stolovapadangorderfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SellerLoginActivity extends AppCompatActivity {
    private Button loginSellerButton, registerSellerButton;
    private EditText emailInput, passwordInput;
    private ProgressDialog loadingBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);

        mAuth = FirebaseAuth.getInstance();

        emailInput = (EditText) findViewById(R.id.seller_login_email);
        passwordInput = (EditText) findViewById(R.id.seller_login_password);
        loginSellerButton = (Button) findViewById(R.id.seller_login_btn);
        registerSellerButton = (Button) findViewById(R.id.seller_register_btn);
        loadingBar = new ProgressDialog(this);

        registerSellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerLoginActivity.this, SellerRegisterActivity.class);
                startActivity(intent);
            }
        });

        loginSellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginSeller();
            }
        });
    }

    private void loginSeller() {
        final String email = emailInput.getText().toString();
        final String password = passwordInput.getText().toString();

        if (!email.equals("") && !password.equals("")) {
            loadingBar.setTitle("Login Akun Penjual");
            loadingBar.setMessage("Tolong tunggu, sedang pengecekan.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(SellerLoginActivity.this, SellerHomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        loadingBar.dismiss();
                        Toast.makeText(SellerLoginActivity.this, "Email/Password Salah :(", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(SellerLoginActivity.this, "Tolong Lengkapi Form Login.", Toast.LENGTH_SHORT).show();
        }
    }
}
