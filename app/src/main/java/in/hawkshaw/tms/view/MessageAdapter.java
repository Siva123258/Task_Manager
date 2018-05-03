package in.hawkshaw.tms.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.hawkshaw.tms.R;
import in.hawkshaw.tms.model.MessageData;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class MessageAdapter  extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {
    private static final int MESSAGE_SENT=1;
    private static final int MESSAGE_RECEIVED=2;
    SharedPreferences sharedPreferences;
    List<MessageData> messageList;
    public MessageAdapter(List<MessageData> messageList, Context context){
        this.messageList=messageList;
        sharedPreferences=context.getSharedPreferences(MainActivity.PREF_NAME,Context.MODE_PRIVATE);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView message;
        public MyViewHolder(View itemView) {
            super(itemView);
            message=itemView.findViewById(R.id.text_message_body);
        }
    }
    @Override
    public int getItemViewType(int position){
        MessageData data;
            data=messageList.get(position);
            if(data.getUser().equals(sharedPreferences.getString("username",""))){
                return MESSAGE_SENT;
            }
            else{
                return MESSAGE_RECEIVED;
            }
    }
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view;
                if(viewType==MESSAGE_SENT){
                    view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent,parent,false);
                    return new MyViewHolder(view);
                }
                else {
                    view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received,parent,false);
                    return new MyViewHolder(view);
                }

    }

    @Override
    public void onBindViewHolder(MessageAdapter.MyViewHolder holder, int position) {
        MessageData data;
        data=messageList.get(position);
        holder.message.setText(data.getMessage());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
