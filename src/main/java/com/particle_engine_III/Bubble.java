/*
 * Coder: Vanessa Haynes
 * Project: Project 2 - Particle Engine with Inheritance
 * Date: Sep. 2024
 * Description: Particle subclass for the bubbles. It extends the superclass OceanStuff
 */

package com.particle_engine_III;
import processing.core.*;

//extends from superclass OceanStuff to inherit all variables and functions etc.
public class Bubble extends OceanStuff{

//initializes everything
    Bubble(PApplet main_, float x_, float y_, float size_, int color_) {
        super(main_, x_, y_, size_, color_); //pulls all info from superclass. 
    }

//draws out the bubble - will have no fill and only coloring the outline
    void draw() {
        super.draw(); //mainly pulls from the superclass
        main.stroke(color); //only edit is to add color to the outline        
    }
}