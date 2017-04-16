package cs2k18.com.zarf17;

/**
 * Created by MSaqib on 12-04-2017.
 */

public class Developer {

    public String image;
    public String facebook_url;
    public String github_url;
    public String name;

    public Developer(String a, int b, String c, String d) {
        name = a;
        image = "https://msaqib.000webhostapp.com/developers/" + a.replaceAll(" ", "_").toLowerCase() + ".jpg";
        facebook_url = c;
        github_url = d;
    }

}
