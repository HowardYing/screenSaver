import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ScreenSaver extends PApplet {

Lines[] myLines = new Lines [10];
public void setup() {
  //size(500,500);
  
  background(0);
  for (int i=0; i<myLines.length; i++) {
    //myLines[i] = new Lines(random(width), random(height), random(2), random(10, 20));
    myLines[i] = new Lines(width/2, height/2, random(1), random(10, 20));
  }
}

public void draw() {
  for (int i=0; i<myLines.length; i++) {
    myLines[i].display();
  }
}

class Lines {
  //Class Variables
  float xpos, ypos, strokeW, lineLength, reset;
  //Constructor
  Lines(float tempX, float tempY, float tempStroke, float tempLength) {
    xpos = tempX;
    ypos = tempY;
    strokeW= tempStroke;
    lineLength = tempLength;
    reset=0;
  }
  //display
  public void display() {
    //strokeW=random(6);
    //lineLength = random(5,21);
    stroke(random(35,75));
    strokeWeight(strokeW);
    if (xpos>width||xpos<0||ypos>height||ypos<0) {
      xpos=random(width);
      ypos=random(height);
    } else {
      if (random(101)>85) {
        strokeWeight(strokeW);
        moveL(xpos, ypos, lineLength);
      } else if (random(101)>60) {
        strokeWeight(strokeW);
        moveU(xpos, ypos, lineLength);
      } else if (random(101)>30) {
        strokeWeight(strokeW);
        moveD(xpos, ypos, lineLength);
      } else {
        strokeWeight(strokeW);
        moveR(xpos, ypos, lineLength);
      }
    }
    reset++;
    if (reset>= 3500) {
      background(0);
      reset = 0;
    }
  }
  //move
  public void moveR(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX+i, startY);
      xpos=startX+i;
    }
  }

  public void moveL(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX-i, startY);
      xpos=startX-i;
    }
  }

  public void moveU(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX, startY-i);
      ypos=startY-i;
    }
  }

  public void moveD(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX, startY+i);
      ypos=startY+i;
    }
  }
}
  public void settings() {  size(displayWidth, displayHeight); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "ScreenSaver" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
