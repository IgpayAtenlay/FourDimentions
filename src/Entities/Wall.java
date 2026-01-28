package Entities;

import Data.Dimension;

import java.util.ArrayList;
import java.util.Arrays;

public class Wall extends Mesh {
    public Wall(Dimension start, double xLength, double yLength, double zLength, double wLength) {
        super();

        // generate all vertices
        ArrayList<Dimension> dimensions = new ArrayList<>();
        for (double x : new double[]{start.x(), start.x() + xLength}) {
            for (double y : new double[]{start.y(), start.y() + yLength}) {
                for (double z : new double[]{start.z(), start.z() + zLength}) {
                    for (double w : new double[]{start.w(), start.w() + wLength}) {
                        dimensions.add(new Dimension(x, y, z, w));
                    }
                }
            }
        }
        System.out.println(dimensions.size());

        // generate all cubes
        ArrayList<RectangularPrism> rectangularPrisms = new ArrayList<>();
        for (int i = 0; i < dimensions.size(); i++) {
            for (int j = i + 1; j < dimensions.size(); j++) {
                for (int k = j + 1; k < dimensions.size(); k++) {
                    for (int l = k + 1; l < dimensions.size(); l++) {
                        RectangularPrism rectangularPrism = createWithTesting(dimensions.get(i), dimensions.get(j), dimensions.get(k), dimensions.get(l));
                        if (rectangularPrism != null) {
                            boolean sameCube = false;
                            for (RectangularPrism rectangularPrism1 : rectangularPrisms) {
                                if (rectangularPrism1.sameCube(rectangularPrism)) {
                                    sameCube = true;
                                }
                            }
                            if (!sameCube) {
                                rectangularPrisms.add(rectangularPrism);
                            }
                        }
                    }
                }
            }
        }

        for (RectangularPrism rectangularPrism : rectangularPrisms) {
            addRectangularPrism(rectangularPrism.dimensions[0], rectangularPrism.dimensions[1], rectangularPrism.dimensions[2], rectangularPrism.dimensions[3]);
            System.out.println(rectangularPrism);
        }
        System.out.println(rectangularPrisms.size());
    }
    private class RectangularPrism {
        private Dimension[] dimensions;
        private Dimension min;
        private Dimension max;
        private RectangularPrism(Dimension... corners) {
            dimensions = corners;
            Dimension min = dimensions[0];
            Dimension max = dimensions[0];
            for (Dimension dimension : dimensions) {
                min = new Dimension(
                        Math.min(min.x(), dimension.x()),
                        Math.min(min.y(), dimension.y()),
                        Math.min(min.z(), dimension.z()),
                        Math.min(min.w(), dimension.w())
                );
                max = new Dimension(
                        Math.max(max.x(), dimension.x()),
                        Math.max(max.y(), dimension.y()),
                        Math.max(max.z(), dimension.z()),
                        Math.max(max.w(), dimension.w())
                );
                this.min = min;
                this.max = max;
            }
        }

        private boolean sameCube(RectangularPrism rectangularPrism) {
            return min.equals(rectangularPrism.min) && max.equals(rectangularPrism.max);
        }
        public String toString() {
            return Arrays.toString(dimensions);
        }
    }
    private RectangularPrism createWithTesting(Dimension... dimensions) {
        if (dimensions.length != 4) {
            return null;
        }

        int middle = 0;
        int middleIndex = 0;
        for (int i = 0; i < dimensions.length; i++) {
            int edges = 0;
            for (int j = 0; j < dimensions.length; j++) {
                if (i != j) {
                    if (threeCoordsMatching(dimensions[i], dimensions[j])) {
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

        Dimension temp = dimensions[middleIndex];
        dimensions[middleIndex] = dimensions[0];
        dimensions[0] = temp;

        return new RectangularPrism(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
    }
    private static boolean threeCoordsMatching(Dimension one, Dimension two) {
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
