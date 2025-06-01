package Shapes;

import Data.Dimention;
import Data.Edges;
import Visuals.Panel;

import java.awt.*;

public class GenericGraph extends Shape {
    public Edges edges;
    public GenericGraph() {
        edges = new Edges();
    }

    public void draw(Graphics g, Panel panel) {
        for (Dimention start : edges.getEdges().keySet()) {
            Dimention modifiedStart = panel.modifyCoordinates(start);
            for (Dimention end : edges.getEdges().get(start)) {
                Dimention modifiedEnd = panel.modifyCoordinates(end);
                g.drawLine((int) modifiedStart.x(), (int) modifiedStart.y(), (int) modifiedEnd.x(), (int) modifiedEnd.y());
            }
        }
    }
    public void move(int distance, Dimention direction) {
        edges.move(distance, direction);
    }
}
