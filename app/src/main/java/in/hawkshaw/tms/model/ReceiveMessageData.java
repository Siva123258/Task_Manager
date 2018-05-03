package in.hawkshaw.tms.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class ReceiveMessageData {
    String url;
    RequestQueue requestQueue;
    public ReceiveMessageData(Context context,String task_id){
        requestQueue= Volley.newRequestQueue(context);
        url="http://192.168.1.5/tms/receivemessage.php?task_id="+task_id;
    }

    public List<MessageData> getJsonData(){
        final List<MessageData> messageList = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    MessageData td;
                    for (int i = 0; i < response.length(); i++) {

                        JSONObject jb = response.getJSONObject(i);
                        String message = jb.getString("reply");
                        String sender = jb.getString("username");
                        //store them in list
                        td= new MessageData(message,sender);
                        messageList.add(td);
                    }
                } catch (Exception e) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error","Cannot parse the list");
            }
        });
        return messageList;
    }
}
