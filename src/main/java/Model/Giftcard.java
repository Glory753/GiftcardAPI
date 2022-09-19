package Model;

public class Giftcard {

    public String name;

    public int giftID;

    public String description;

    public String url;

    public Giftcard() {

    }

    public Giftcard(String name, int giftID, String description, String url) {
        this.name = name;
        this.giftID = giftID;
        this.description = description;
        this.url = url;
    }

    public String toString() {return "Giftcard {" +
            "name=" + name + '\'' +
            "gift id" + giftID + '\'' +
            "description" + description + '\'' +
            "url" + url + '\'' +
            "}\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGiftID() {
        return giftID;
    }

    public void setGiftID(int giftID) {
        this.giftID = giftID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
