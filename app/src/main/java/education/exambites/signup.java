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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

import education.exambites.R;

public class signup extends AppCompatActivity implements View.OnClickListener {
    TextView already_account;
    EditText name,email,password,phone;
    Button signupBtn;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        //getting reference of firebase for authetication
        mAuth = FirebaseAuth.getInstance();
        //these are the ids of sigup page
        name = (EditText) findViewById(R.id.name_id);
        email = (EditText) findViewById(R.id.email_id);
        password = (EditText) findViewById(R.id.password_id);
        phone = (EditText) findViewById(R.id.phone_id);
        already_account = (TextView) findViewById(R.id.already);
        signupBtn = (Button) findViewById(R.id.btnsignupid);
        signupBtn.setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(final View view) {
        //getting text from EditText fields through respective ids
        String name1= name.getText().toString().trim();
        String email1= email.getText().toString().trim();
        String password1= password.getText().toString().trim();
        String phone1= phone.getText().toString().trim();

        if(name1.isEmpty())
        {
            name.setError("Name can't be empty");
            name.requestFocus();
            return;
        }

        if(email1.isEmpty())
        {
            email.setError("Email must required");
            email.requestFocus();
            return;
        }

        if(password1.isEmpty())
        {
            password.setError("Password can't be empty");
            password.requestFocus();
            return;
        }

        if(phone1.isEmpty())
        {
            phone.setError("Phone no. can't be empty");
            phone.requestFocus();
            return;
        }
        //empty field check validation finished

        if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches())
        {
            email.setError("Please enter valid email address");
            email.requestFocus();
            return;
        }
        if(password1.length()<6)
        {
            password.setError("Password must contain 6 character");
            password.requestFocus();
            return ;
        }
        if(phone1.length()>11)
        {
            phone.setError("Please Enter Valid Number (e.g 03001234567)");
            phone.requestFocus();
            return;
        }
        if(name.length()>23)
        {
            name.setError("please write short name");
            name.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("MSG", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if(task.isSuccessful())
                        {
                            Toast.makeText(signup.this, "User Register Successfully.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(signup.this,login.class);
                            startActivity(intent);
                            finish();
                            progressBar.setVisibility(View.GONE);
                        }


                        if(task.getException() instanceof FirebaseAuthUserCollisionException)
                        {
                            Toast.makeText(signup.this, "User Already Exist",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(signup.this, "Authentication Failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });


    }

}
