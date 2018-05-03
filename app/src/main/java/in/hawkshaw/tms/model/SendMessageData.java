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
public class SendMessageData {
    Context context;
    String url,confirmation;
    public  SendMessageData(Context context,MessageData data){
        this.context=context;
        url="http://192.18.5.1/tms/addmessage.php?task_id="+data.getId()+"&username="+data.getUser()+"&reply="+data.getMessage();
    }
    public String getConfirmation(){

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
        return confirmation;
    }
}
