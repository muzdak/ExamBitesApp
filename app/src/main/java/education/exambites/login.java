package education.exambites;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import education.exambites.R;

public class login extends AppCompatActivity implements View.OnClickListener {
    TextView already_account;
    EditText name, email, password, phone;
    Button login;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public Button btn1;
    public Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        fun();
        //getting reference of firebase for authetication
        mAuth = FirebaseAuth.getInstance();
        //these are the ids of sigup page

        email = (EditText) findViewById(R.id.email_id);
        password = (EditText) findViewById(R.id.password_id);

        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(final View view) {
        //getting text from EditText fields through respective ids

        String email1 = email.getText().toString().trim();
        String password1 = password.getText().toString().trim();



        if (email1.isEmpty()) {
            email.setError("Email must required");
            email.requestFocus();
            return;
        }

        if (password1.isEmpty()) {
            password.setError("Password can't be empty");
            password.requestFocus();
            return;
        }
        //empty field check validation finished

        if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            email.setError("Please enter valid email address");
            email.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("MSG", "signInWithEmail:onComplete:" + task.isSuccessful());
                        if(task.isSuccessful())
                        {
                            Toast.makeText(login.this, "Login Successfully.", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(login.this,MainActivity.class));
                            finish();
                            progressBar.setVisibility(View.GONE);
                        }
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("MSG", "signInWithEmail:failed", task.getException());
                            Toast.makeText(login.this, "Authentication Failed (Incorrect Email or Password)",
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                        // ...
                    }
                });
    }

    public void fun() {
        //from login to signup screen
        btn1 = (Button) findViewById(R.id.btnSignup);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(login.this, signup.class);
                startActivity(go);
            }

        });
    }
}