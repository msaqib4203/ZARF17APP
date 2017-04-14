package cs2k18.com.zarf17;

/**
 * Created by MSaqib on 09-04-2017.
 */

public class Member {

    public String name;
    public String post;
    public String url;
    public String contact;

    Member(String a, String b, int c, String d) {
        this.name = a;
        this.post = b;
        this.url = "http://msaqib.gq/team/" + String.valueOf(c) + ".jpg";
        this.contact = d;
    }
}
