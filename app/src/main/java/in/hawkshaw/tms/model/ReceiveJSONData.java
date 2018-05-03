package in.hawkshaw.tms.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.hawkshaw.tms.view.TaskAdapter;

/**
 * Created by G.SivaKumar on 30-04-2018.
 */
public class ReceiveJSONData {
     String url;
    RequestQueue requestQueue;
    RecyclerView view;
    Context context;
    public ReceiveJSONData(Context context, String fromid, RecyclerView view){
        this.context=context;
        requestQueue=Volley.newRequestQueue(context);
            url="http://192.168.1.5/tms/receivetasklist.php?fromid="+fromid;
            this.view=view;
    }

    public List<TaskData> getJsonData(){
        final List<TaskData> taskData = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,"http://192.168.1.5/tms/receivetasklist.php?fromid=gsiva97",null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    TaskData td;
                    for (int i = 0; i < response.length(); i++) {
                        Log.d("getting ","inside");
                        JSONObject jb = response.getJSONObject(i);
                        String task_id=jb.getString("task_id");
                        String task_title = jb.getString("task_title");
                        String description = jb.getString("description");
                        String date = jb.getString("date");
                        //store them in list

                        td= new TaskData(task_id,task_title,description,date);
                        Log.d("json",td.toString());
                        taskData.add(td);
                    }
                } catch (Exception e) {
                    Log.d("exception",e.getMessage());
                }
                Log.d("response",taskData.toString());
                TaskAdapter tk = new TaskAdapter(taskData,context);
                view.setAdapter(tk);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error","Cannot parse the list");
            }
        });
        requestQueue.add(jsonArrayRequest);
        return taskData;
    }
}
