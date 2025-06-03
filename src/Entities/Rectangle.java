package Entities;

import Data.Dimention;

public class Rectangle extends Mesh {
    public Rectangle(Dimention middle, Dimention one, Dimention two) {
        super();
        addRectangle(middle, one, two);
    }
}
