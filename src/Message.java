public class Message {

    // As always, I am declaring the new variables here, that are private
    private String messageId;
    private String text;
    private Point location;
    private String emotion;
    private User user;

    // Here as always I am setting, that exactly this variables are variables, so called setter
    public Message(String messageId, String text, Point location, String emotion, User user){
        this.messageId = messageId;
        this.text = text;
        this.location = location;
        this.emotion = emotion;
        this.user = user;
    }

    // And that are my getters, so I am able to get this values in different sections of the code
    public String getEmotion(){
        return emotion;
    }

    public Point getLocation(){
        return location;
    }

    public User getUser(){
        return user;
    }

    public String getText(){
        return text;
    }
}
