import java.util.Random;

public class Artwork {

    private String title;
    private Artist artist;
    private double price;
    private int nft;

    public Artwork(String title, Artist artist, double price, int nft) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.nft = nft;
    }

//    GETTERS & SETTERS
    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public double getPrice() {
        return price;
    }

    public int getNft() {
        return nft;
    }

}
