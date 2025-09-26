package Controls;

import Data.Dimention;
import Data.RotationDirections;
import Entities.Entity;
import Entities.Mesh;
import Scenes.Scene;
import Visuals.Frame;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Control {
    private static Scene scene;
    private static Entity focus;
    private static Frame frame;

    public static void initialize(Scene scene) {
        Control.scene = scene;
        focus = scene.getEye();
        frame = new Frame();
        Timer timer = new Timer(1, e -> {
            tick();
            frame.panel.tick();
        });
        timer.start();
    }

    public static void tick() {
        if ( focus != null) {
            if (Keys.isKeyPressed(KeyEvent.VK_W)) {
                focus.move(Settings.getHorizontalSpeed(), new Dimention(0, 0, 1, 0));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_S)) {
                focus.move(Settings.getHorizontalSpeed(), new Dimention(0, 0, -1, 0));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_A)) {
                focus.move(Settings.getHorizontalSpeed(), new Dimention(-1, 0, 0, 0));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_D)) {
                focus.move(Settings.getHorizontalSpeed(), new Dimention(1, 0, 0, 0));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_I)) {
                focus.move(Settings.getForwardsSpeed(), new Dimention(0, 1, 0, 0));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_K)) {
                focus.move(Settings.getForwardsSpeed(), new Dimention(0, -1, 0, 0));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_J)) {
                focus.move(Settings.getAnaSpeed(), new Dimention(0, 0, 0, -1));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_L)) {
                focus.move(Settings.getAnaSpeed(), new Dimention(0, 0, 0, 1));
            }
            if (Keys.isKeyPressed(KeyEvent.VK_NUMPAD4)) {
                // turn left
                focus.turn(Settings.getXZTurn(), RotationDirections.XZ);
            }
            if (Keys.isKeyPressed(KeyEvent.VK_NUMPAD6)) {
                focus.turn(Settings.getXZTurn() * -1, RotationDirections.XZ);
            }
            if (Keys.isKeyPressed(KeyEvent.VK_NUMPAD8)) {
                focus.turn(Settings.getYZTurn(), RotationDirections.YZ);
            }
            if (Keys.isKeyPressed(KeyEvent.VK_NUMPAD2)) {
                focus.turn(Settings.getYZTurn() * -1, RotationDirections.YZ);
            }
            if (Keys.isKeyPressed(KeyEvent.VK_NUMPAD7)) {
                focus.turn(Settings.getWZTurn(), RotationDirections.WZ);
            }
            if (Keys.isKeyPressed(KeyEvent.VK_NUMPAD9)) {
                focus.turn(Settings.getWZTurn() * -1, RotationDirections.WZ);
            }
        }
    }

    public static Scene getScene() {
        return scene;
    }
    public void add(Mesh shape) {
        scene.getShapes().add(shape);
    }
}
