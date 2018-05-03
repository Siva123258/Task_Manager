package in.hawkshaw.tms.model;

/**
 * Created by G.SivaKumar on 02-05-2018.
 */
public class MessageData {
    public String tasktitle,message,user,id;
   public MessageData(){

    }
   public MessageData(String message,  String user){
        this.message=message;
        this.user=user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
