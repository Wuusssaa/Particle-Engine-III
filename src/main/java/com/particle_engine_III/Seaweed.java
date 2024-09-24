/*
 * Coder: Vanessa Haynes
 * Project: Project 2 - Particle Engine with Inheritance
 * Date: Sep. 2024
 * Description: Particle subclass for the seaweed. It extends the superclass OceanStuff
 */

 package com.particle_engine_III;
 import processing.core.*;

//extends from superclass OceanStuff to inherit all variables and functions etc.
public class Seaweed extends OceanStuff{

//initializes everything
    Seaweed(PApplet main_, float x_, float y_, float y2_, int color_){
        super(main_, x_, y_, 0, color_); //pulls from the superclass
        y2 = y2_; //initializes something new for the new shape
    }

//because it is a different shape and doesn't need to move, it doesn't pull from superclass and overrides instead. 
    void draw() {
        main.stroke(color);
        main.strokeWeight(6);
        main.line(x, y, x, y2);
    }
}