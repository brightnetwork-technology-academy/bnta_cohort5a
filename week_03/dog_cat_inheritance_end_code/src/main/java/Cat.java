public class Cat extends Animal {

    public Cat(String name, int age){
        super(name, age);
    }

    public String getName(){
        return super.getName();
    }

    public int getAge(){
        return super.getAge();
    }

    public String meow(){
        return "meow";
    }

}
