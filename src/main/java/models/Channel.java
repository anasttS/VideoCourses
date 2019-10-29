package models;

public class Channel {
    private int owner_id;
    private String name;
    private int playlist_id;

    public Channel(int owner_id, String name) {
        this.owner_id = owner_id;
        this.name = name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
