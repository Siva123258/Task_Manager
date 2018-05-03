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
public class UsernameCheck {
    Context context;
    String url,confirmation;
    boolean result;
    public  UsernameCheck(Context context){
        this.context=context;
        url="http://192.18.5.1/tms/";
    }
    public boolean getConfirmation(){

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                confirmation = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        if(confirmation.equals("present")){
            return true;
        }
        else{
            return false;
        }
    }
}
