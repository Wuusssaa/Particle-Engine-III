/*
 * Coder: Vanessa Haynes
 * Project: Project 2 - Particle Engine with Inheritance
 * Date: Sep. 2024
 * Description: Particle subclass for the food. It extends the superclass OceanStuff
 */

 package com.particle_engine_III;
 import processing.core.*;

//extends from superclass OceanStuff to inherit all variables and functions etc.
public class FishFood extends OceanStuff{
    Fish fish;
    int fed = 0; //counter to keep track of the food that has been eaten/times collided.

//initializes everything
    FishFood(PApplet main_, float x_, float y_, float size_, int color_) {
        super(main_, x_, y_, size_, color_); //pulling from superclass
    }

//because it is a different shape and doesn't need to move, it doesn't pull from superclass and overrides instead. 
    void draw() {
        main.square(x, y, size); 
    }

//sets the random location for the food.
    void setLocation(float x_, float y_) {
        x = x_;
        y = y_;
    }

//allows the food to collide with the swimming fish. If they collide, the fed counter will go up and a message will be printed to the terminal.
    void collision(OceanStuff stuff) {
        collide = collides(stuff);
        if(collide) {
            spawn();
            fed++;
            PApplet.println("fish fed: " + fed + ". yummy!!");
        }
    }
}