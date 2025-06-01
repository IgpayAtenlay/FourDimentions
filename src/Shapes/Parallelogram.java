package Shapes;

import Records.Dimention;
import Visuals.Panel;

import java.awt.*;

public class Parallelogram extends Shape {
    public Dimention cornerOne;
    public Dimention cornerTwo;
    public Dimention cornerThree;

    public Parallelogram(Dimention cornerOne, Dimention cornerTwo, Dimention cornerThree) {
        this.cornerOne = cornerOne;
        this.cornerTwo = cornerTwo;
        this.cornerThree = cornerThree;
    }
    public void draw(Graphics g, Panel panel) {
        Dimention cornerFour = new Dimention(
                cornerOne.x() - cornerTwo.x() + cornerThree.x(),
                cornerOne.y() - cornerTwo.y() + cornerThree.y(),
                cornerOne.z() - cornerTwo.z() + cornerThree.z(),
                cornerOne.w() - cornerTwo.w() + cornerThree.w()
        );
        Dimention modifiedOne = panel.modifyCoordinates(cornerOne);
        Dimention modifiedTwo = panel.modifyCoordinates(cornerTwo);
        Dimention modifiedThree = panel.modifyCoordinates(cornerThree);
        Dimention modifiedFour = panel.modifyCoordinates(cornerFour);

        Graphics2D g2 = (Graphics2D) g;
        int[] xPoints = {(int) modifiedOne.x(), (int) modifiedTwo.x(), (int) modifiedThree.x(), (int) modifiedFour.x()};
        int[] yPoints = {(int) modifiedOne.y(), (int) modifiedTwo.y(), (int) modifiedThree.y(), (int) modifiedFour.y()};
        g2.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    public void move(int distance, Dimention direction) {
        cornerOne = cornerOne.move(distance, direction);
        cornerTwo = cornerTwo.move(distance, direction);
        cornerThree = cornerThree.move(distance, direction);
    }
}
