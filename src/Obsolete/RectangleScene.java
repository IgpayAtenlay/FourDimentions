package Obsolete;

import Data.Dimention;

public class RectangleScene extends Scene {
    public RectangleScene() {
        super();
        shapes.add(new Obsolete.Rectangle(
                new Dimention(0, 0, 2000, 0),
                new Dimention(0, 100, 2000, 500),
                new Dimention(0, 0, 2500, 0))
        );
//        shapes.add(new Obsolete.Rectangle(
//                new Dimention(500, 0, 100, 0),
//                new Dimention(0, 0, 100, 0),
//                new Dimention(500, 0, 600, 0))
//        );
    }
}
