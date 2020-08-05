package lesson6;

import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        Dog dog1 = new Dog("Bobik");

        cat1.info();

        System.out.println();

        dog1.info();

        System.out.println();

        dog1.run(400);
        dog1.swim(5);
        dog1.jump(4);

        System.out.println();

        cat1.run(1700);
        cat1.swim(5);
        cat1.jump(2);
    }

    public static class Animals {//super class
        protected String name;
        protected String type;
        protected int maxRun;
        protected int maxSwim;
        protected double maxJump;
        public Random random = new Random();

        public Animals(String name){
            this.name = name;
        }

        public void run(int dist) {
            if (this.maxRun >= dist) {
                System.out.println(this.type + " " + this.name + " run " + dist + " m.");
            }
            else System.out.println(this.type + " " + this.name + " can't run so far.");
        }

        public void swim(int dist) {
            if (this.maxSwim >= dist) {
                System.out.println(this.type + " " + this.name + " swim " + dist + " m.");
            }
            else System.out.println(this.type + " " + this.name + " can't swim so far.");
        }

        public void jump(double height) {
            if (this.maxJump >= height) {
                System.out.println(this.type + " " + this.name + " jump " + height + " m.");
            }
            else System.out.println(this.type + " " + this.name + " can't jump so high.");
        }

        public void info() {
            System.out.println(this.type + " " + this.name + " Run: " + this.maxRun + " m., Swim: " + this.maxSwim + " m., Jump: " + this.maxJump + " m.");
        }
    }

    public static class Cat extends Animals {
        public Cat(String name) {
            super(name);
            this.maxJump = 2.0;
            this.maxRun = random.nextInt(45) + 155;
            this.type = "Cat";
        }

        @Override
        public void swim(int dist) {
            System.out.println("Cat's no swim!");
        }
    }

    public static class Dog extends Animals {
        public Dog(String name) {
            super(name);
            this.type = "Dog";
            this.maxRun = random.nextInt(300) + 300;
            this.maxSwim = random.nextInt(6) + 5;
            this.maxJump = Math.random() * 6 + 0.1;
        }
    }
}