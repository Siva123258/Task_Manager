package in.hawkshaw.tms.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import in.hawkshaw.tms.R;
import in.hawkshaw.tms.model.TaskData;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class TaskFragment extends DialogFragment {
    public interface NoticeDialogListener{
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }
    NoticeDialogListener noticeDialogListener;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.add_task_fragment,null)).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    TaskFragment.this.getDialog().cancel();
            }
        });
            return builder.create();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            noticeDialogListener=(NoticeDialogListener)activity;

        }catch (ClassCastException e){

        }
    }
}
