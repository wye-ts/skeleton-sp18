public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readString();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int planetCount = in.readInt();
        in.readString();
        Planet[] allPlanets = new Planet[planetCount];
        for (int i = 0; i < planetCount; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return allPlanets;
    }

    public static void main(String[] args) {
        // Collecting all needed input
        if (args.length < 3) return;
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] allPlanets = readPlanets(filename);
        int planetCount = allPlanets.length;

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        /* Clears the drawing window. */
        StdDraw.clear();
        for (double time = 0; time < T; time += dt) {
            double[] xForces = new double[planetCount];
            double[] yForces = new double[planetCount];
            for (int i = 0; i < planetCount; i++) {
                Planet currentPlanet = allPlanets[i];
                xForces[i] = currentPlanet.calcNetForceExertedByX(allPlanets);
                yForces[i] = currentPlanet.calcNetForceExertedByY(allPlanets);
                currentPlanet.update(dt, xForces[i], yForces[i]);
            }
            // Drawing the Background
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            // Drawing All of the Planets
            for (Planet p : allPlanets)
                p.draw();

            StdDraw.show();
            StdDraw.pause(100);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", allPlanets[i].xxPos, planets[i].yyPos,
                    planets[i].xxVel, allPlanets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

        System.exit(0);
    }
}