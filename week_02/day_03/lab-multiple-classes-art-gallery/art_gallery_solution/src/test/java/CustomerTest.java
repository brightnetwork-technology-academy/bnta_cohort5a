import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerTest {

    Customer customer;
    Artist charlesClough;
    Artwork cruor;
    Artist vincentVanGogh;
    Artwork irises;

    @BeforeEach
    public void setUp(){
        customer = new Customer("Dorothy Vogel", 23_000);

        charlesClough = new Artist("Charles Clough");
        cruor = new Artwork("Cruor", charlesClough, 1_000, 846);

        vincentVanGogh = new Artist("Vincent Van Gogh");
        irises = new Artwork("Irises", vincentVanGogh, 50_000_000, 885);
    }

    @Test
    public void canAffordArtwork__true(){
        assertThat(customer.canBuy(cruor)).isEqualTo(true);
    }

    @Test
    public void canAffordArtwork__false(){
        assertThat(customer.canBuy(irises)).isEqualTo(false);
    }

    @Test
    public void customerArtworkCountStartsEmpty(){
        assertThat(customer.getArtworkCount()).isEqualTo(0);
    }

    @Test
    public void canBuyArtwork(){
        customer.buyArtwork(cruor);
        assertThat(customer.getWallet()).isEqualTo(22_000);
        assertThat(customer.getArtworkCount()).isEqualTo(1);
    }

    @Test
    public void hasName(){
        assertThat(customer.getName()).isEqualTo("Dorothy Vogel");
    }

    @Test
    public void hasWallet(){
        assertThat(customer.getWallet()).isEqualTo(23_000);
    }

}
