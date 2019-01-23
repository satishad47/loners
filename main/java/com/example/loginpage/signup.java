package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private EditText fname, lname, mail, mbl, pwd, cnfpwd;
    private TextView Sign_up;
    public Button sbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fname = (EditText) findViewById(R.id.etname);
        lname = (EditText) findViewById(R.id.etname2);
        mail = (EditText) findViewById(R.id.etmail);
        mbl = (EditText) findViewById(R.id.etmbl);
        pwd = (EditText) findViewById(R.id.etpwd);
        cnfpwd = (EditText) findViewById(R.id.etcnfpwd);
        sbt = (Button) findViewById(R.id.btn);

        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(fname.getText().toString(), lname.getText().toString(), mail.getText().toString(), mbl.getText().toString(), pwd.getText().toString(), cnfpwd.getText().toString());
            }
        });
    }

    private void validate(String fname, String lname, String mail, String mbl, String pwd, String cnfpwd) {
        if (!(fname.isEmpty()) && !(lname.isEmpty()) && !(mail.isEmpty()) && !(mbl.isEmpty()) && !(pwd.isEmpty()) && !(cnfpwd.isEmpty())) {
            if (pwd.equals(cnfpwd) == true) {
                Intent intent = new Intent(signup.this, userprofile.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "re enter the password", Toast.LENGTH_SHORT).show();
            }
        }

    }
}

