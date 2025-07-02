package Entities;

import Data.Dimention;

public class Cube extends Mesh {
    public Cube(Dimention start, int sideLength) {
        super();
        Dimention one = start.move(sideLength, new Dimention(1, 0,0 , 0));
        Dimention two = start.move(sideLength, new Dimention(0, 1, 0, 0));
        Dimention three = start.move(sideLength, new Dimention(0, 0, 0, 1));

        addRectangularPrism(start, one, two, three);
    }
}
