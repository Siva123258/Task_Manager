package in.hawkshaw.tms.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import in.hawkshaw.tms.R;
import in.hawkshaw.tms.model.ReceiveJSONData;
import in.hawkshaw.tms.model.SendTaskData;
import in.hawkshaw.tms.model.TaskData;

/**
 * Created by G.SivaKumar on 30-04-2018.
 */
public class DashBoard extends AppCompatActivity implements TaskFragment.NoticeDialogListener{
    private List<TaskData> taskDataList;
    RecyclerView recyclerView;
    TaskAdapter tk;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    public void addTask(MenuItem mi){
            // Initialize the fragment

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        recyclerView=findViewById(R.id.recycler_task);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ReceiveJSONData list = new ReceiveJSONData(getApplicationContext(),getSharedPreferences(MainActivity.PREF_NAME,MODE_PRIVATE).getString("username",""),recyclerView);
        taskDataList=list.getJsonData();

        //Use Item Decoration
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        View view = dialog.getView();
        EditText e1=view.findViewById(R.id.title);
        EditText e2=view.findViewById(R.id.description);
        EditText e3=view.findViewById(R.id.toid);
        TaskData data = new TaskData(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
        data.setFromid(getSharedPreferences(MainActivity.PREF_NAME,MODE_PRIVATE).getString("username",""));
        SendTaskData data1 = new SendTaskData(getApplicationContext(),data);
        data1.getConfirmation();
        taskDataList.add(data);
        tk.notifyDataSetChanged();
        dialog.dismiss();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
            dialog.dismiss();
    }
}
