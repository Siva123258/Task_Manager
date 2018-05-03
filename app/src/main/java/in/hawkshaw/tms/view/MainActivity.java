package in.hawkshaw.tms.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import in.hawkshaw.tms.R;
import in.hawkshaw.tms.model.LoginCheck;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String PREF_NAME="logindetails";
    TextView sign_up;
    EditText username,password;
    ImageView user_error,pass_error;
    Button login;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences=getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        if(preferences.contains("username")){
            Intent intent = new Intent(getApplicationContext(),DashBoard.class);
            startActivity(intent);
        }
        else {
            setContentView(R.layout.activity_main);
            username=findViewById(R.id.username);
            password=findViewById(R.id.password);
            login=findViewById(R.id.button_login);
            user_error=findViewById(R.id.image_user_error);
            pass_error=findViewById(R.id.image_pass_error);
            sign_up=findViewById(R.id.sign_up);
            sign_up.setOnClickListener(this);
            login.setOnClickListener(this);
            username.setText("gsiva97");
            password.setText("siva123");

        }

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_login:
                                if(username.getText().toString().isEmpty()){
                                        user_error.setVisibility(View.VISIBLE);
                                }
                                else if(password.getText().toString().isEmpty()){
                                        pass_error.setVisibility(View.VISIBLE);
                                }
                                else {

                                    LoginCheck loginCheck = new LoginCheck(getApplicationContext(),username.getText().toString(),password.getText().toString());
                                    loginCheck.execute();
                                }
                                break;

            case R.id.sign_up:
                                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                break;
        }
    }
}
