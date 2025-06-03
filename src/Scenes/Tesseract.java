package Scenes;

import Data.Dimention;

public class Tesseract extends Scene {
    public Tesseract() {
        super();
        shapes.add(new Entities.Tesseract(new Dimention(-500, 500, 2000, 0),500));
    }
}
