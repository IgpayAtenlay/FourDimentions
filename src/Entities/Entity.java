package Entities;

import Data.Dimension;
import Data.RotationDirection;

public abstract class Entity {
    public abstract void move(int distance, Dimension direction);
    public abstract void turn(double degree, RotationDirection direction);
}
