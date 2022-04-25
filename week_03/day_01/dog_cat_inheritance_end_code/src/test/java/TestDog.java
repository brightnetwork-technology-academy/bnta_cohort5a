import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestDog {

    Dog dog;

    @BeforeEach
    public void setUp(){
        dog = new Dog("Betty", 3, true);
    }

    @Test
    public void hasName(){
        assertThat(dog.getName()).isEqualTo("Betty");
    }

    @Test
    public void hasAge(){
        assertThat(dog.getAge()).isEqualTo(3);
    }

    @Test
    public void hasWorkingBreed(){
        assertThat(dog.getIsWorkingBreed()).isEqualTo(true);
    }

    @Test
    public void canBark(){
        assertThat(dog.bark()).isEqualTo("woof");
    }

    @Test
    public void canSleep(){
        assertThat(dog.sleep()).isEqualTo("Betty is sleeping");
    }

    @Test
    public void canEat(){
        assertThat(dog.eat()).isEqualTo("Betty is eating");
    }

}
