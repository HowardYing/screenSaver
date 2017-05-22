
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
  void display() {
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
  void moveR(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX+i, startY);
      xpos=startX+i;
    }
  }

  void moveL(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX-i, startY);
      xpos=startX-i;
    }
  }

  void moveU(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX, startY-i);
      ypos=startY-i;
    }
  }

  void moveD(float startX, float startY, float moveCount) {
    for (float i=0; i<moveCount; i+=1) {
      point(startX, startY+i);
      ypos=startY+i;
    }
  }
}