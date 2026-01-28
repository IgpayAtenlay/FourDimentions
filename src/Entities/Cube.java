package Entities;

import Data.Dimension;

public class Cube extends Mesh {
    public Cube(Dimension start, int sideLength) {
        super();
        Dimension one = start.move(sideLength, new Dimension(1, 0,0 , 0));
        Dimension two = start.move(sideLength, new Dimension(0, 1, 0, 0));
        Dimension three = start.move(sideLength, new Dimension(0, 0, 0, 1));

        addRectangularPrism(start, one, two, three);
    }
}
