package Scenes;

import Data.Dimention;

public class Wall extends Scene {
    public Wall() {
        super();
        shapes.add(new Entities.Wall(new Dimention(-500, 500, 2000, 0),1000, 500, 500, 1000));
    }
}
