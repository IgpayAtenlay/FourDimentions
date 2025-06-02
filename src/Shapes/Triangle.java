package Shapes;

import Data.Dimention;
import Visuals.Eye;
import Visuals.Panel;

import java.awt.*;

public class Triangle extends Shape {
    private Dimention cornerOne;
    private Dimention cornerTwo;
    private Dimention cornerThree;

    public Triangle(Dimention cornerOne, Dimention cornerTwo, Dimention cornerThree) {
        this.cornerOne = cornerOne;
        this.cornerTwo = cornerTwo;
        this.cornerThree = cornerThree;
    }
    public void draw(Graphics g, Panel panel) {
        Color oldColor = g.getColor();
        Dimention modifiedOne = panel.modifyCoordinates(cornerOne);
        Dimention modifiedTwo = panel.modifyCoordinates(cornerTwo);
        Dimention modifiedThree = panel.modifyCoordinates(cornerThree);

        if (modifiedOne.isVisible() && modifiedTwo.isVisible() && modifiedThree.isVisible()) {
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(getColor(panel.getEye(), modifiedOne, modifiedTwo, modifiedThree));
            int[] xPoints = {(int) modifiedOne.x(), (int) modifiedTwo.x(), (int) modifiedThree.x()};
            int[] yPoints = {(int) modifiedOne.y(), (int) modifiedTwo.y(), (int) modifiedThree.y()};
            g2.fillPolygon(xPoints, yPoints, xPoints.length);
        }
        g.setColor(oldColor);
    }
    public Color getColor(Eye eye, Dimention... dimentions) {
        boolean pos = false;
        int blurValue = 0;

        for (Dimention dimention : dimentions) {
            double w = Math.abs(dimention.w());
            if (w <= eye.getSolid() / 2) {
                return Color.BLACK;
            } else if (w <= eye.getBlur() / 2) {
                if (dimention.w() > 0) {
                    pos = true;
                }
                double blurArea = eye.getBlur() - eye.getSolid();
                blurValue = (int) ((1 - (w - eye.getSolid() / 2) / (eye.getBlur() / 2 - eye.getSolid() / 2)) * eye.getStartingBlur());
            }
        }

        if (pos) {
            return new Color(255, 0, 0, blurValue);
        } else {
            return new Color(0, 0, 255, blurValue);
        }
    }

    public void move(int distance, Dimention direction) {
        cornerOne = cornerOne.move(distance, direction);
        cornerTwo = cornerTwo.move(distance, direction);
        cornerThree = cornerThree.move(distance, direction);
    }
}
