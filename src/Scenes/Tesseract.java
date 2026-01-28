package Scenes;

import Data.Dimension;

public class Tesseract extends Scene {
    public Tesseract() {
        super();
        shapes.add(new Entities.Tesseract(new Dimension(-500, 500, 2000, 0),500));
    }
}
