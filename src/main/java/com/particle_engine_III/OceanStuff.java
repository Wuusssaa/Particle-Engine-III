/*
 * Coder: Vanessa Haynes
 * Project: Project 2 - Particle Engine with Inheritance
 * Date: Sep. 2024
 * Description: Superclass for all particle types in this "Fish Tank" particle engine
 */

package com.particle_engine_III;
import processing.core.*;

public class OceanStuff {
    PApplet main; //processing functionality
    float x, y; //location
    float y2; //seaweed locations
    float size; //size of the particles
    float sizeX, sizeY; //size of fish length and height
    int color; //color of the particles
    float xvel = 2; //x velocity of the particles
    float yvel = 1; //y velocity of the particles
    float xdirection = -1; //x direction of the particles
    float ydirection = 1; //y direction of the particles
    boolean collide; //if the fish and food have collided

//initializes everything
    OceanStuff(PApplet main_, float x_, float y_, float size_, int color_) {
        main = main_;
        x = x_;
        y = y_;
        size = size_;
        color = color_;
    }

//displays and moves the particles
    void draw() {
        main.ellipse(x, y, size, size);
        move();
    }

//making the fish and bubbles move on their own
    void move() {

        x += xvel*xdirection;
        y += yvel*ydirection; 

        if(y >= main.height || y <= 0){
            ydirection *= -1;
        }

        if(x >= main.width || x <= 0){
        xdirection *= -1;
        }
    }

//makes the particles go faster
    void faster() {
        yvel++;
        xvel++;
    }

//makes the particles go slower
    void slower() {
        yvel--;
        xvel--;
    }

//to allow the food and fish particles to collide
    boolean collides(OceanStuff stuff) {
        float distance = PApplet.dist(x, y, stuff.getX(), stuff.getY());
        return (distance < (size/2 + stuff.getSize()/2));
    }

//to allow the food to relocate in a random location after colliding with a fish
    void spawn() {
        x = main.random(main.width);
        y = main.random(main.height);

        xvel = main.random(-10, 10);
        yvel = main.random(-10, 10);
    }

//getters
    float getX() {return x;}
    float getY() {return y;}
    float getSize() {return size;}
}