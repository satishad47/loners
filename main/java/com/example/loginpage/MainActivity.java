

//my code
package com.example.loginpage;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private ImageView image;
    private EditText name;
    private EditText password;
    private TextView info,signin_button,forgot_button;
    private Button login;
    private int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image=(ImageView)findViewById(R.id.etimage);
        name=(EditText)findViewById(R.id.etname);
        password=(EditText)findViewById(R.id.etpassword);
        info=(TextView)findViewById(R.id.tvinfo);
        login=(Button)findViewById(R.id.btnlogin);
        signin_button=(TextView)findViewById(R.id.tvsign) ;
        forgot_button=(TextView)findViewById(R.id.tvforgot);

        //info.setText("no of attemps remaining:5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });

        signin_button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });

        forgot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,forgotpassword.class));
            }
        });





    }

    private void validate(String username,String userpassword)
    {
        boolean a ;int b;

        if(username.isEmpty()||userpassword.isEmpty())
        {
            Toast.makeText(this,"user name or password is empty",Toast.LENGTH_SHORT).show();
            return;
        }

        else if(username.equals("satish@gmail.com") && userpassword.equals("12345"))
        {


                Intent intent = new Intent(MainActivity.this, userprofile.class);
                startActivity(intent);return;
        }
        else if (username.equals("sanath@gmail.com") && userpassword.equals("12345"))
        {

                Intent intent = new Intent(MainActivity.this, org_profile.class);
                startActivity(intent);return;
        }

        else
        {
             if(a=username.lastIndexOf("@gmail.com")==-1)
            {
            Toast.makeText(this, "email should be of the format abc@bcd.com", Toast.LENGTH_LONG).show();
            }

            else {
                 counter--;
                 Toast.makeText(this, "wrong user name or password", Toast.LENGTH_SHORT).show();
                 info.setText("                        no of attemps left:" + counter);

                }
            if(counter==0)
            {
                login.setEnabled(false);
            }
        }


    }






}


