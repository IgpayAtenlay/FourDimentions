package Entities;

import Data.Dimension;
import Data.RotationDirection;

public class Triangle extends Entity {
    public Dimension cornerOne;
    public Dimension cornerTwo;
    public Dimension cornerThree;

    public Triangle(Dimension cornerOne, Dimension cornerTwo, Dimension cornerThree) {
        this.cornerOne = cornerOne;
        this.cornerTwo = cornerTwo;
        this.cornerThree = cornerThree;
    }

    public void move(int distance, Dimension direction) {
        cornerOne = cornerOne.move(distance, direction);
        cornerTwo = cornerTwo.move(distance, direction);
        cornerThree = cornerThree.move(distance, direction);
    }
    @Override
    public void turn(double degree, RotationDirection direction) {
    }
}
