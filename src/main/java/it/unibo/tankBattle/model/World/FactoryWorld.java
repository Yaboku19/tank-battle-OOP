package it.unibo.tankBattle.model.World;


import java.util.HashSet;
import java.util.Set;
import it.unibo.tankBattle.model.api.GameObject;
import it.unibo.tankBattle.model.api.World;
import it.unibo.tankBattle.model.impl.FactoryGameObject;
import javafx.geometry.Point2D;

public class FactoryWorld {
    private final Set<GameObject> border;
    private final FactoryGameObject factory;
    private final static int ROW = 9;
    private final static int COLUMN = 14;
    private final static int WALLSIZE = 3;
    private final static int STANDARDSPEED = 10;

    public FactoryWorld() {
        factory = new FactoryGameObject();
        border = new HashSet<>();
        for (int i = 0; i < ROW ; i++) {
            border.add(factory.simpleWall(new Point2D(0, i * WALLSIZE + 1)));
            border.add(factory.simpleWall(new Point2D(COLUMN * WALLSIZE + 1, i * WALLSIZE + 1)));
        }
        for (int i = 0; i < COLUMN ; i++) {
            border.add(factory.simpleWall(new Point2D(i * WALLSIZE + 1, 0)));
            border.add(factory.simpleWall(new Point2D(i * WALLSIZE + 1, ROW * WALLSIZE + 1)));
        }
    }

    public World simpleWorld() {
        GameObject tankOne = factory.simpleTank(null, null, ROW, COLUMN);
        GameObject tankTwo = factory.simpleTank(null, null, ROW, COLUMN);
        return null;
    }
}
