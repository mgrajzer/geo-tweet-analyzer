import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


// That is mine Main class, where I am reading and parsing the CSV
public class Main {
    public static void main(String[] args) {
        // Here I create new list that will contain all objects of a class Message
        List<Message> messages = new ArrayList<>();
        String line;
        // This method will read the file line by line
        try (BufferedReader br = new BufferedReader(new FileReader("twitter.csv"))) {
            // here I say that we should skip the first part
            br.readLine();
            while ((line = br.readLine()) != null) {
                //This part is new since last time, and it allows to parse not clean data as we want to have it
                String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                // Here I declare which column has which vales in our java project
                String messageId = parts[1];
                String text = parts[3].replaceAll("^\"|\"$", "");
                String userId = parts[4];
                //Here they are this order, since latitude we use first, and longitude as second
                double lat = Double.parseDouble(parts[6]);
                double lon = Double.parseDouble(parts[5]);
                String emotion = parts[7].replaceAll("^\"|\"$", "");

                // Here I create new objects during each iteration, and assign the values that were read from the CSV
                User user = new User(userId);
                Point location = new Point(lat, lon);
                Message message = new Message(messageId, text, location, emotion, user);

                //And here I add that to the array "message", plus I display it in a nice for user way
                messages.add(message);
                System.out.println(messageId + " | " + text + " | " + userId + " | " + lat + " | " + lon + " | " + emotion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Here I chose random userId from the list to check how does it all work
        User testUser = new User("36277818");

        // I am creating the list, which will check in the all messages these, that were wrote by this userId
        List<Message> userMessages = testUser.getMessages(messages);
        System.out.println("***  Check was done for the user with userID: " + testUser.getUserId() + "   ***");
        for (Message m : userMessages) {
            System.out.println("Message: " + m.getText() + ", Location: :" + m.getLocation().getLatitude() + ", "+ m.getLocation().getLongitude()  + ", Sentiment: " + m.getEmotion());
        }
        // Here I create new point, which is the Boloco - 50 Congress Street - Burrito Restaurant
        Point center = new Point(42.3579707,-71.0564778);

        // I set the radius
        double radius = 0.00040;
        // And it will display a list of messages, that were wrote withing this radius
        List<Message> nearby = center.search(radius, messages);
        System.out.println("***   We found " + nearby.size() + " tweets near the 50 Congress Street - Burrito Restaurant:   ***");
        for (Message m : nearby) {
            System.out.println(m.getUser() + "  wrote: " + m.getText() + " with the " + m.getEmotion() + " sentiment.");
        }
    }
}