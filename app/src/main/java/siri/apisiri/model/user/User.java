package siri.apisiri.model.user;

public class User {
    private String name;
    private String imageUrl;

    public User(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
