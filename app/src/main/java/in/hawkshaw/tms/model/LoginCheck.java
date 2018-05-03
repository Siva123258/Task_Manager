package in.hawkshaw.tms.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import in.hawkshaw.tms.view.DashBoard;
import in.hawkshaw.tms.view.MainActivity;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class LoginCheck extends AsyncTask<Void,Void,String>{
    Context context;
    String url,confirmation;
    String username,password,response;
    ProgressDialog progressDialog;
    public  LoginCheck(Context context,String username,String password){
        this.context=context;
        this.username=username;
        this.password=password;
        url="http://10.0.2.2/tms/checkpassword.php?username="+username+"&password="+password;
    }
    public String getConfirmation() {
        return response;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("http://192.168.1.5/tms/checkpassword.php?username="+username+"&password="+password);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response=reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("response",response);
        if(response.equals("verified")){
        SharedPreferences.Editor editor=context.getSharedPreferences(MainActivity.PREF_NAME,Context.MODE_PRIVATE).edit();
        editor.putString("username",username);
        editor.apply();
        context.startActivity(new Intent(context,DashBoard.class));
        }
        else {
            Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
        }
    }
}
