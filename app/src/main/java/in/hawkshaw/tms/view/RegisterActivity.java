package in.hawkshaw.tms.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import in.hawkshaw.tms.R;
import in.hawkshaw.tms.model.RegisterUser;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText username,password,repassword;
    ImageView user,pass,repass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.re_password);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        repass=findViewById(R.id.re_pass);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View v) {

                if(username.getText().toString().isEmpty()){
                    user.setVisibility(View.VISIBLE);
                }
                else if (password.getText().toString().isEmpty()||repassword.getText().toString().isEmpty()){
                    pass.setVisibility(View.VISIBLE);
                    repass.setVisibility(View.VISIBLE);
                }
                if (password.getText().toString().equals(repassword.getText().toString())){
                    // send to server
                    RegisterUser registerUser = new RegisterUser(username.getText().toString(),password.getText().toString(),getApplicationContext());
                    registerUser.sendRequest();
                    finish();
                }
                else{
                    pass.setVisibility(View.VISIBLE);
                    repass.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Password doesn't match",Toast.LENGTH_SHORT).show();
                }
    }
}
