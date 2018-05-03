package in.hawkshaw.tms.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import in.hawkshaw.tms.R;
import in.hawkshaw.tms.model.MessageData;
import in.hawkshaw.tms.model.ReceiveMessageData;
import in.hawkshaw.tms.model.SendMessageData;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class MessageActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    MessageAdapter adapter;
    Button send;
    EditText message;
    List<MessageData> messageDataList ;
    String task_id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox);
        recyclerView=findViewById(R.id.reyclerview_message_list);
        task_id = getIntent().getStringExtra("task_id");
        send=findViewById(R.id.button_chatbox_send);
        message=findViewById(R.id.edittext_chatbox);
        send.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ReceiveMessageData messageData = new ReceiveMessageData(this, task_id);
        messageDataList=messageData.getJsonData();
        adapter = new MessageAdapter(messageDataList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        MessageData data = new MessageData(task_id,message.getText().toString());
        SendMessageData sendMessageData = new SendMessageData(this,data);
        sendMessageData.getConfirmation();
        message.setText("");
        messageDataList.add(data);
        adapter.notifyDataSetChanged();
    }

}
