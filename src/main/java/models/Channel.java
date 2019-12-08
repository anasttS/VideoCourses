package models;

public class Channel {
    private int ownerId;
    private String name;
    private String img;


    public Channel(int ownerId, String name, String img) {
        this.ownerId = ownerId;
        this.name = name;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getownerId() {
        return ownerId;
    }

    public void setownerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
