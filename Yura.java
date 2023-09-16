package yura;
import robocode.*;
import java.awt.Color;
import java.util.Random;

public class Yura extends Robot {
    private Random rand = new Random();

    public void run() {
        // Cores
        setColors(Color.lightGray, Color.black, Color.blue, Color.cyan, Color.white);

        while (true) {
            // Movimento aleatório e imprevisível
            ahead(100 + rand.nextInt(50));  // Avança uma distância aleatória
            turnRight(90 - rand.nextInt(180));  // Gira um ângulo aleatório
        }
    }

    // Robô detectado
    public void onScannedRobot(ScannedRobotEvent e) {
        String robotank = e.getName();
        double distancia = e.getDistance();
        System.out.println(robotank + " distância " + distancia);

        if (distancia < 135) {
            fire(3);
        } else {
            fire(1);
        }
    }

    // Colisão com a parede
    public void onHitWall(HitWallEvent e) {
        back(50);
        turnRight(90);
    }
}
