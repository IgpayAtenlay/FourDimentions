package Entities;

import Data.Dimention;

import java.util.ArrayList;
import java.util.Arrays;

public class Tesseract extends Mesh {
    public Tesseract(Dimention start, int sideLength) {
        super();

        // generate all vertices
        ArrayList<Dimention> dimentions = new ArrayList<>();
        for (double x : new double[]{start.x(), start.x() + sideLength}) {
            for (double y : new double[]{start.y(), start.y() + sideLength}) {
                for (double z : new double[]{start.z(), start.z() + sideLength}) {
                    for (double w : new double[]{start.w(), start.w() + sideLength}) {
                        dimentions.add(new Dimention(x, y, z, w));
                    }
                }
            }
        }

        // generate all cubes
        ArrayList<Cube> cubes = new ArrayList<>();
        for (int i = 0; i < dimentions.size(); i++) {
            for (int j = i + 1; j < dimentions.size(); j++) {
                for (int k = j + 1; k < dimentions.size(); k++) {
                    for (int l = k + 1; l < dimentions.size(); l++) {
                        Cube cube = createWithTesting(dimentions.get(i), dimentions.get(j), dimentions.get(k), dimentions.get(l));
                        if (cube != null) {
                            boolean sameCube = false;
                            for (Cube cube1 : cubes) {
                                if (cube1.sameCube(cube)) {
                                    sameCube = true;
                                }
                            }
                            if (!sameCube) {
                                cubes.add(cube);
                            }
                        }
                    }
                }
            }
        }

        for (Cube cube : cubes) {
            addRectangularPrism(cube.dimentions[0], cube.dimentions[1], cube.dimentions[2], cube.dimentions[3]);
        }
    }
    private class Cube {
        private Dimention[] dimentions;
        private Dimention min;
        private Dimention max;
        private Cube(Dimention... corners) {
            dimentions = corners;
            Dimention min = dimentions[0];
            Dimention max = dimentions[0];
            for (Dimention dimention : dimentions) {
                min = new Dimention(
                        Math.min(min.x(), dimention.x()),
                        Math.min(min.y(), dimention.y()),
                        Math.min(min.z(), dimention.z()),
                        Math.min(min.w(), dimention.w())
                );
                max = new Dimention(
                        Math.max(max.x(), dimention.x()),
                        Math.max(max.y(), dimention.y()),
                        Math.max(max.z(), dimention.z()),
                        Math.max(max.w(), dimention.w())
                );
                this.min = min;
                this.max = max;
            }
        }

        private boolean sameCube(Cube cube) {
            return min.equals(cube.min) && max.equals(cube.max);
        }
        public String toString() {
            return Arrays.toString(dimentions);
        }
    }
    private Cube createWithTesting(Dimention... dimentions) {
        if (dimentions.length != 4) {
            return null;
        }

        int middle = 0;
        int middleIndex = 0;
        for (int i = 0; i < dimentions.length; i++) {
            int edges = 0;
            for (int j = 0; j < dimentions.length; j++) {
                if (i != j) {
                    if (threeCoordsMatching(dimentions[i], dimentions[j])) {
                        edges++;
                    }
                }
            }
            if (edges == 3) {
                middle++;
                middleIndex = i;
            }
        }

        if (middle != 1) {
            return null;
        }

        Dimention temp = dimentions[middleIndex];
        dimentions[middleIndex] = dimentions[0];
        dimentions[0] = temp;

        return new Cube(dimentions[0], dimentions[1], dimentions[2], dimentions[3]);
    }
    private static boolean threeCoordsMatching(Dimention one, Dimention two) {
        int numSharedAspects = 0;
        if (one.x() == two.x()) {
            numSharedAspects++;
        }
        if (one.y() == two.y()) {
            numSharedAspects++;
        }
        if (one.z() == two.z()) {
            numSharedAspects++;
        }
        if (one.w() == two.w()) {
            numSharedAspects++;
        }
        return numSharedAspects == 3;
    }
}
