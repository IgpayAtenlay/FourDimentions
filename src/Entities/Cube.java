package Entities;

import Data.Dimention;

public class Cube extends Mesh {
    public Cube(Dimention start, Dimention one, Dimention two, Dimention three) {
        super();
        addRectangle(start, one, two);
        addRectangle(start, two, three);
        addRectangle(start, one, three);
        Dimention twoThree = two.move(start, three);
        Dimention oppositeStart = twoThree.move(start, one);
        addRectangle(twoThree, two, oppositeStart);
        addRectangle(twoThree, oppositeStart, three);
        Dimention oneTwo = one.move(start, two);
        addRectangle(oneTwo, oppositeStart, one);
    }
}
