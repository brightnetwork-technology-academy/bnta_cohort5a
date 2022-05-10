import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {

    private String name;
    private double wallet;
    private ArrayList<Artwork> customerArtwork;

    public Customer(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
        this.customerArtwork = new ArrayList<>();
    }

    public boolean canBuy(Artwork artwork){ //customer1.canBuy(artwork)
        if( artwork.getPrice() <= this.wallet){
            return true;
        }
        return false;
    }

    public void buyArtwork(Artwork artwork){
        this.wallet -= artwork.getPrice();
        this.customerArtwork.add(artwork);
    }

    public int getArtworkCount(){
        return this.customerArtwork.size();
    }

//    GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Artwork> getCustomerArtwork() {
        return customerArtwork;
    }

    public void setCustomerArtwork(ArrayList<Artwork> customerArtwork) {
        this.customerArtwork = customerArtwork;
    }
}
