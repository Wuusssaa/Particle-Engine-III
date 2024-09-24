/*
 * Coder: Vanessa Haynes
 * Project: Project 2 - Particle Engine with Inheritance
 * Date: Sep. 2024
 * Description: Particle subclass for the fish. It extends the superclass OceanStuff
 */

package com.particle_engine_III;
import processing.core.*;

//extends from superclass OceanStuff to inherit all variables and functions etc.
public class Fish extends OceanStuff{
    boolean swimright; //boolean to help with swimming direction of fish to change shape

//initializes everything
    Fish(PApplet main_, float x_, float y_, float sizeX_, float sizeY_, int color_) {
        super(main_, x_, y_, 0, color_); //pulls from the superclass.
        sizeX = sizeX_; //initializes the new variable to create fish length
        sizeY = sizeY_; //initializes the new variable to create fish height
    }

//draws out the fish, if fish are swimming to the right, the shape will look like they're facing to the right, and vice-versa.
    void draw() {
        if (swimright) {
            main.fill (color);
            main.rect (x, y, sizeX, sizeY);
            main.ellipse (x+sizeX, y+sizeY/2-1, sizeX, sizeY);
        } else {
            main.fill (color);
            main.rect (x, y, sizeX, sizeY);
            main.ellipse (x, y+sizeY/2-1, sizeX, sizeY);
        }
        move(); //moves the fish
    }

//this move is inherited but needed to be edited as the shapes of the fish need to change once bounced. 
    void move() {
        super.move();
        if((x+sizeX) >= main.width){
            xdirection = -1;
            swimright = false;
        } else if (x <= 0) {
            xdirection = 1;
            swimright = true;
        }
    }

//changes the direction and shape of the fish - connects to the spacebar for keypressed.
    void flip() {
        xdirection *= -1;
        if (xdirection == -1) {
            swimright = false;
        } else if (xdirection == 1) {
            swimright = true;
        }
    }
}