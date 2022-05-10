import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GalleryTest {

    Gallery gallery;
    Artist rachelRuysch;
    Artist vincentVanGogh;
    Artwork flowersInAVase;
    Artwork irises;
    Customer customer;

    @BeforeEach
    public void setUp(){
        gallery = new Gallery("Bright Artwork");
        rachelRuysch = new Artist("Rachel Ruysch");
        flowersInAVase = new Artwork("Flowers In a Glass Vase with a Cricket in a Niche", rachelRuysch, 10_000_000, 786);
        vincentVanGogh = new Artist("Vincent van Gogh");
        irises = new Artwork("Irises", vincentVanGogh, 12_000_000, 885 );
        gallery.addArtwork(flowersInAVase);
        gallery.addArtwork(irises);
        customer = new Customer("Peggy Guggenheim", 30_000_000);
    }

    @Test
    public void galleryCanSellArt(){
        gallery.sellArtwork(customer, flowersInAVase);
        assertThat(gallery.artworkCount()).isEqualTo(1); // check no. of artwork has reduced by 1
        assertThat(gallery.getTill()).isEqualTo(10_000_000); // check gallery till is up to 10mil
        assertThat(customer.getWallet()).isEqualTo(20_000_000); // check customer wallet has reduced to 20
        assertThat(customer.getArtworkCount()).isEqualTo(1); //check customer artwork count has increased by 1
    }

    @Test
    public void canCalculateArtValue(){
        double result = gallery.calculateArtworkValue();
        assertThat(result).isEqualTo(22_000_000);
    }

    @Test
    public void hasName(){
        assertThat(gallery.getName()).isEqualTo("Bright Artwork");
    }

    @Test
    public void tillStartsAtZero(){
        assertThat(gallery.getTill()).isEqualTo(0);
    }

}
