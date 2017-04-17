package com.example.android.emax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

/**
 * sign up page
 */
public class SignUpActivity extends AppCompatActivity {

    private Button button;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean b, checked = true;
    private TextView tv;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        tv = (TextView) findViewById(R.id.tv_custom);
        tv.setText("Signup");
        button = (Button) findViewById(R.id.btn_SignUpPage);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                b = checkValidation();
                if (b == checked) {
                    Intent intent = new Intent();
                    setResult(RESULT_FIRST_USER, intent);
                    finish();

                } else {
                    Toast.makeText(SignUpActivity.this, "enter detials", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    /**
     *
     * @return email and password after validation
     */
    private boolean checkValidation() {
        EditText viewEmail = (EditText) findViewById(R.id.ed_email_Sign_up);
        email = viewEmail.getText().toString();

        EditText viewPassword = (EditText) findViewById(R.id.ed_password_signUp);
        password = viewPassword.getText().toString();

        EditText viewConfirmPassword = (EditText) findViewById(R.id.ed_confirmPassword);
        confirmPassword = viewConfirmPassword.getText().toString();
        if (isValidEmail(email)) {
            if (checkpassword(password, confirmPassword)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     *
     * @param p1  password
     * @param p2 confirmpassword
     * @return  after checking
     */
    public Boolean checkpassword(final String p1, final String p2) {
        if (p1.contentEquals(p2)) {
            return true;

        } else {
            String text = "Enter password correctly ";
            Toast toast = makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }

    /**
     *
     * @param emailm email is passed
     * @return email after validation
     */
    private boolean isValidEmail(final String emailm) {
        return Patterns.EMAIL_ADDRESS.matcher(emailm).matches();
    }
}
