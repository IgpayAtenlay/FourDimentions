import Records.Dimention;
import Shapes.Parallelogram;
import Visuals.Frame;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
//        frame.panel.add(new Point(0, 0, 100, 0));
        frame.panel.add(new Parallelogram(
                new Dimention(0, 0, 100, 0),
                new Dimention(100, 0, 100, 0),
                new Dimention(100, 100, 100, 0)
        ));
    }
}
