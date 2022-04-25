import java.util.ArrayList;

public class Gallery {

    private String name;
    private double till;
    private ArrayList<Artwork> artworks;

    public Gallery(String name) {
        this.name = name;
        this.artworks = new ArrayList<>();
        this.till = 0;
    }

    public void sellArtwork(Customer customer, Artwork artwork){
        if(customer.canBuy(artwork) == true){
            customer.buyArtwork(artwork);
            this.artworks.remove(artwork);
            setTill(this.till + artwork.getPrice());
        }
    }

    public double calculateArtworkValue(){
        double total = 0;
        for(Artwork artwork : this.artworks){
            total += artwork.getPrice();
        }
        return total;
    }

    public int artworkCount(){
        return this.artworks.size();
    }

    public void addArtwork(Artwork artwork){
        this.artworks.add(artwork);
    }

//    GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

    public ArrayList<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(ArrayList<Artwork> artworks) {
        this.artworks = artworks;
    }
}
