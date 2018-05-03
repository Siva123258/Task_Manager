package in.hawkshaw.tms.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.hawkshaw.tms.R;
import in.hawkshaw.tms.model.TaskData;

/**
 * Created by G.SivaKumar on 30-04-2018.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder>{

        List<TaskData> tasklist;
        Context context;
        public TaskAdapter(List<TaskData> e, Context context){
            tasklist=e;
            this.context=context;
        }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView task_title,description,date;
        public MyViewHolder(View view){
            super(view);
            view.setOnClickListener(this);
            task_title=view.findViewById(R.id.task_title);
            description=view.findViewById(R.id.description);
            date=view.findViewById(R.id.date);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,MessageActivity.class);
            intent.putExtra("task_id",tasklist.get(getPosition()).getTask_id());
            context.startActivity(intent);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasklistrow,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            TaskData td = tasklist.get(position);
            holder.task_title.setText(td.getTask_title());
            holder.description.setText(td.getDescription());
            holder.date.setText(td.getDate());
    }

    @Override
    public int getItemCount() {
        return tasklist.size();
    }
}
