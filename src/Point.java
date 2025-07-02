import java.util.ArrayList;
import java.util.List;

public class Point {

    //Firstly we declare two private variables

    private double latitude;
    private double longitude;

    //Here is my constructor

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // And here is my getter for this two variables

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // That is the method that calculates distance from this point to the input point
    public double distanceTo(Point input) {
        double dx = this.latitude - input.latitude;
        double dy = this.longitude - input.longitude;
        return Math.sqrt(dx * dx + dy * dy);
    }


    // SINCE LAST TIME: This method is creating list of messages based on radius
    public List<Message> search(double radius, List<Message> allMessages){
        List<Message> result = new ArrayList<>();
        for (Message message : allMessages){
            double distance = this.distanceTo(message.getLocation());
            if(distance <= radius){
                result.add(message);
            }
        }
        return result;
    }
}

