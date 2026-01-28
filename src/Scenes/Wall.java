package Scenes;

import Data.Dimension;

public class Wall extends Scene {
    public Wall() {
        super();
//        shapes.add(new Entities.Wall(new Dimension(-500, 500, 2000, 0),1000, 500, 500, 1000));
        shapes.add(new Entities.Wall(new Dimension(-500, 500, 2000, 0),1000, 500, 500, 500));
        shapes.add(new Entities.Wall(new Dimension(-500, 500, 2000, 500),1000, 500, 500, 500));
    }
}
