package com.example.labtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name,email,mobile,id;
    private CheckBox c1,c2,c3;
    private RadioGroup RG_1;
    private Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.s_name);
        email = findViewById(R.id.s_email);
        mobile = findViewById(R.id.s_mobile);
        id = findViewById(R.id.s_id);

        c1 = findViewById(R.id.ragular);
        c2 = findViewById(R.id.gold);
        c2 = findViewById(R.id.platinum);

        RG_1 = findViewById(R.id.gander);

        submit_btn = findViewById(R.id.submit);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_name = name.getText().toString();
                String input_email = email.getText().toString();
                String input_mobile = mobile.getText().toString();
                String input_id = id.getText().toString();

                if(!validateUserName()){
                    return;
                }
                else if(!validateUserId()){
                    return;
                }
                else if(!validateUseremail()){
                    return;
                }
                else if(!validateUserMobile()){
                    return;
                }
                else{

                }


            }
        });


    }

    private boolean validateUserName() {
        String user_name = name.getText().toString();

        if (user_name.isEmpty()) {
            name.requestFocus();
            name.setError("name cannot be empty");
            return false;
        } else if (!user_name.matches("^[a-zA-Z][a-zA-Z\\s]*$")) {
            name.requestFocus();
            name.setError("Name can only contain alphabets");
            return false;
        } else {
            name.setError(null);
            return true;
        }

    }

    public boolean validateUseremail () {
        String user_email = email.getText().toString();
        if (user_email.isEmpty()) {
            email.requestFocus();
            email.setError("Email cannot be empty");
            return false;
        }
        // Check if the email format is valid
         if (!user_email.matches("^cse_[0-9]{16}@lus\\.ac\\.bd$")) {
            email.requestFocus();
            email.setError("Invalid email format");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validateUserMobile() {
        String user_mobile = mobile.getText().toString();

        if (user_mobile.isEmpty()) {
            mobile.requestFocus();
            mobile.setError("mobile cannot be empty");
            return false;
        }

        else if (!user_mobile.matches("^\\+880\\d{10}$")) {
            mobile.requestFocus();
            mobile.setError("number start with +880...");
            return false;
        }
        else {
            mobile.setError(null);
            return true;
        }
    }

    private boolean validateUserId() {
        String user_mobile = mobile.getText().toString();

        if (user_mobile.isEmpty()) {
            mobile.requestFocus();
            mobile.setError("Id cannot be empty");
            return false;
        }


        else {
            mobile.setError(null);
            return true;
        }
    }
}