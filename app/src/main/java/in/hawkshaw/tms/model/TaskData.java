package in.hawkshaw.tms.model;

/**
 * Created by G.SivaKumar on 30-04-2018.
 */
public class TaskData {
    private String task_title,description,date,fromid,toid,task_id;

    public TaskData(String task_title, String description, String date, String fromid, String toid, String task_id) {
        this.task_title = task_title;
        this.description = description;
        this.date = date;
        this.fromid = fromid;
        this.toid = toid;
        this.task_id = task_id;
    }

    public TaskData(String task_title, String description, String toid) {
        this.task_title = task_title;
        this.description = description;
        this.toid = toid;
    }

    public TaskData(String task_id, String task_title, String description, String date) {
        this.task_id=task_id;
        this.task_title = task_title;
        this.description = description;
        this.date = date;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
