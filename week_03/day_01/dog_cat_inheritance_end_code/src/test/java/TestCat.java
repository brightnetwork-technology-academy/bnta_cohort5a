import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCat {

    Cat cat;

    @BeforeEach
    public void setUp(){
        cat = new Cat("Gus", 5);
    }

    @Test
    public void hasName(){
        assertThat(cat.getName()).isEqualTo("Gus");
    }

    @Test
    public void hasAge(){
        assertThat(cat.getAge()).isEqualTo(5);
    }

    @Test
    public void canMeow(){
        assertThat(cat.meow()).isEqualTo("meow");
    }

    @Test
    public void canSleep(){
        assertThat(cat.sleep()).isEqualTo("Gus is sleeping");
    }

    @Test
    public void canEat(){
        assertThat(cat.eat()).isEqualTo("Gus is eating");
    }
}
