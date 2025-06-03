package Entities;

import Data.Dimention;

public class Cube extends Mesh {
    public Cube(Dimention start, int sideLength) {
        super();
        Dimention one = start.move(sideLength, new Dimention(1, 0,0 , 0));
        Dimention two = start.move(sideLength, new Dimention(0, 1, 0, 0));
        Dimention three = start.move(sideLength, new Dimention(0, 0, 1, 0));

        // bottom
        addRectangle(start, one, three);
        // left
        addRectangle(start, two, three);
        // front
        addRectangle(start, one, two);

        Dimention four = two.move(sideLength, new Dimention(0, 0, 1, 0));
        Dimention five = one.move(sideLength, new Dimention(0, 0, 1, 0));
        Dimention six = one.move(sideLength, new Dimention(0, 1, 0, 0));

        // top
        addRectangle(two, four, six);
        // right
        addRectangle(one, five, six);
        // back
        addRectangle(three, four, five);
    }
}
