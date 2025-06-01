import Data.Dimention;
import Shapes.GenericGraph;
import Visuals.Frame;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
//        frame.panel.add(new Point(0, 0, 100, 0));
//        frame.panel.add(new Parallelogram(
//                new Dimention(0, 0, 100, 0),
//                new Dimention(100, 0, 100, 0),
//                new Dimention(100, 100, 100, 0)
//        ));
        GenericGraph genericGraph = new GenericGraph();
        genericGraph.edges.addEdge(new Dimention(0, 0, 100, 0), new Dimention(100, 0, 100, 0));
        genericGraph.edges.addEdge(new Dimention(100, 0, 100, 0), new Dimention(100, 100, 100, 0));
        genericGraph.edges.addEdge(new Dimention(100, 100, 100, 0), new Dimention(0, 0, 100, 0));
        frame.panel.add(genericGraph);
    }
}
