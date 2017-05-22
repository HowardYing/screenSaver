Lines[] myLines = new Lines [10];
void setup() {
  //size(500,500);
  size(displayWidth, displayHeight);
  background(0);
  for (int i=0; i<myLines.length; i++) {
    //myLines[i] = new Lines(random(width), random(height), random(2), random(10, 20));
    myLines[i] = new Lines(width/2, height/2, random(1), random(10, 20));
  }
}

void draw() {
  for (int i=0; i<myLines.length; i++) {
    myLines[i].display();
  }
}