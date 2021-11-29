/**
 * Homework 7
 *
 * @author Vrezh Sargsyan
 * @version 28.11.2021
 */

class Lesson7 {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat ("Kitty", 10), new Cat ("Kotty", 15), new Cat ("Kutty", 20)
        };
        Plate plate = new Plate(50, 100);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.setSatiety(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    void setSatiety(boolean status) {
        satiety = status;
    }

    void eat(Plate plate) {
        if(!satiety) {
            satiety = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return "(name:" + name + ", appetite:" + appetite + ", satiety:" + satiety + ")";
    }
}

class Plate {
    private int food;

    Plate(int i, int food) {
        this.food = food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) {
            return false;
        }
        food -= portion;
        return true;
    }

    void add(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }
}