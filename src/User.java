import java.util.ArrayList;
import java.util.List;

//That is my public class User
public class User {

    // Here I declare the private variable userId
    private String userId;

    // That is my constructor that takes userId as this specific userId
    public User(String userId){
        this.userId = userId;
    }

    // Here is my getter for the userId
    public String getUserId(){
        return userId;
    }

    //That is the method getMessages, which is returning me back list of messages, which were wrote by specific user (this.userId)
    public List<Message> getMessages(List<Message> allMessages){
        List<Message> result = new ArrayList<>();

        //Inside the for-each loop program is checking each message, that userId equals this.userId, and if yes it is adding to the list of messages
        for (Message message : allMessages){
            if (message.getUser().getUserId().equals(this.userId)){ /* getUser still needs to be defined  */
                result.add(message);
            }
        }
        return result;
    }
}
