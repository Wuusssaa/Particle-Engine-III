/*
 * Coder: Vanessa Haynes
 * Project: Project 2 - Particle Engine with Inheritance
 * Date: Sep. 2024
 * Description: Controller class that controls and animates all of the particles.
 */

package com.particle_engine_III;
import java.util.ArrayList;
import processing.core.*;

public class OceanController {
    PApplet main; //processing functionality
    float r, g, b; //color variables for background color
    int background; //background color with the above random variables
    float bubbleR, bubbleG, bubbleB; //color variables for the bubbles
    int bubblesColor; //bubbles color with the above random variables
    ArrayList<Fish> fishies; //all the fish being drawn
    ArrayList<Bubble> bubbles; //all the bubbles being drawn
    ArrayList<Seaweed> seaweeds; //all the seaweed being drawn
    ArrayList<FishFood> foods; //all the food being drawn
    Fish fish; //fish that will be drawn to the screen
    Bubble bubble; //a bubble that will be drawn to the screen
    Seaweed seaweed; //seaweed that will be drawn to the screen
    FishFood food; //food that will be drawn to the screen
    int bubbleCount = 10; //# of bubbles
    int fishCount = 3; //# of fish
    int seaweedCount = 10; //# of seaweed
    int foodCount = 1; //# of food

//initializes everything
    OceanController(PApplet main_) {
        main  = main_;
        //random dark blues for the background
        r = main.random(50); 
        g = main.random(50);
        b = main.random(50, 255);
        background = main.color(r, g, b);
        //random light blues for the bubbles
        bubbleR = main.random(144, 173); 
        bubbleG = main.random(213, 216);
        bubbleB = main.random(230, 255);
        bubblesColor = main.color(bubbleR, bubbleG, bubbleB);
        fishies = new ArrayList<>();
        bubbles = new ArrayList<>();
        seaweeds = new ArrayList<>();
        foods = new ArrayList<>();
        init(); //initialize everything except bubbles
        initb(); //initialize the bubbles
    }

//draws the background as well as all of the elements of the "ocean". 
    public void draw() {
        main.background(background); //background is a random dark blue color
        main.strokeWeight(2); //setting the outline thickness of most elements
        main.noStroke(); //takes away the outlines for some elements
        //draws the fish
        for(int i = 0; i<fishies.size(); i++){
            fishies.get(i).draw(); 
        }
        main.noFill(); //takes away the fill for the bubbles
        //draws the bubbles
        for(int i = 0; i<bubbles.size(); i++){
            bubbles.get(i).draw(); 
        }
        //draws the seaweed
        for(int i = 0; i<seaweeds.size(); i++){
            seaweeds.get(i).draw(); 
        }
        main.fill(255, 10, 30); //makes sure that the food will be a red
        main.noStroke(); //takes away the outline
        //draws the food
        for(int i = 0; i<foods.size(); i++){
            foods.get(i).draw(); 
        }
        collisions(); //runs collisions for the food and fish. 
    }

//adds all of the fish, food, and seaweed to their respective arrays. Most attributes are random
    void init() {
        for(int i=0; i<fishCount; i++) {
            fish = new Fish(main, main.random(main.width), main.random(main.height), main.random(15,30), main.random(5,15), main.color(main.random(255), main.random(255), main.random(255)));
            fishies.add(fish);
        }
        for(int i=0; i<foodCount; i++) {
            food = new FishFood(main, main.random(main.width), main.random(main.height), 12, main.color(255, 0, 0));
            foods.add(food);
        }
        for(int i=0; i<seaweedCount; i++) {
            seaweed = new Seaweed(main, main.random(main.width), main.height, main.random(main.height/2,main.height-40), main.color(main.random(255), main.random(255), main.random(255)));
            seaweeds.add(seaweed);
        }
        
    }

//adds the bubbles to its array. A random light blue color. In a separate array so we can add more bubbles later with keypressed.
    void initb() {
        for(int i=0; i<bubbleCount; i++) {
            bubble = new Bubble(main, main.random(main.width), main.random(main.height), main.random(25), bubblesColor);
            bubbles.add(bubble);
        }
    }

//allows the fish elements on screen to collide with the food element on screen.
    public void collisions() {
        for(int i=0; i<fishies.size(); i++) {
            food.collision(fishies.get(i));
        }
    }

//sets a random location for the food
    public void setFoodLocation(float x, float y) {
        food.setLocation(x,y);
    }

//dragging the mouse over the window allows the background color to change between a random range of dark blues.
//as well as interacting with the food
    void mouseDragged() {
        setFoodLocation(main.mouseX, main.mouseY); //can drag the food location with current mouse location
        r = main.random(50); 
        g = main.random(50);
        b = main.random(50, 255);
        background = main.color(r, g, b);
    }

//clicking in specific locations altars the speeds of elements
    void mouseClicked() {
        //if right side of screen, bottom right will speed up and top right will slow down bubbles
        if ((main.mouseX > main.width/2) & (main.mouseY > main.height/2)) {
            for(int i = 0; i<bubbles.size(); i++){
                bubbles.get(i).faster(); 
            }
        } else if ((main.mouseX > main.width/2) & (main.mouseY < main.height/2)) {
            for(int i = 0; i<bubbles.size(); i++){
                bubbles.get(i).slower(); 
            }
        }
        //if left side of screen, bottom left will speed up and top left will slow down fish
        if ((main.mouseX < main.width/2) & (main.mouseY > main.height/2)) {
            for(int i = 0; i<fishies.size(); i++){
                fishies.get(i).faster(); 
            }
        } else if ((main.mouseX < main.width/2) & (main.mouseY < main.height/2)) {
            for(int i = 0; i<fishies.size(); i++){
                fishies.get(i).slower(); 
            }
        }
    }

//pressing different keys will interact with both fish and bubbles
    void keyPressed() {
        //if key is spacebar, it flips the fish swimming and facing directions
        if (main.key == ' ') {
            for(int i = 0; i<fishies.size(); i++){
                fishies.get(i).flip(); 
            }
        } else if (main.key == 'b') { //if key is 'b', it adds more bubbles! 
            initb();
        }
    }
}