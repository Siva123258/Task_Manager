package in.hawkshaw.tms.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class RegisterUser {
    String url;
    Context c;
    public RegisterUser(String username,String password,Context c){
        url="192.168.5.1/tms/registeruser.php?username="+username+"&password="+password;
        this.c=c;

    }
    public void sendRequest(){
        RequestQueue queue= Volley.newRequestQueue(c);
        StringRequest request= new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

}
