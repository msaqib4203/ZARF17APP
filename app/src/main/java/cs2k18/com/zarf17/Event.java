package cs2k18.com.zarf17;

/**
 * Created by MSaqib on 14-04-2017.
 */

public class Event {
    public String image_url;
    public String name;


    public Event(String name, String image_url) {
        int n = image_url.length();

        this.name = name;
        //this.image_url = image_url;

        this.image_url = "https://msaqib.000webhostapp.com/events/" + this.name.replaceAll(" ", "_").toLowerCase() + ".jpg";
    }
}
