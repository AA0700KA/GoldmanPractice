package essential.collection;

import essential.objects.abstraction.AbstractGameObject;
import essential.objects.abstraction.AbstractMovableObject;
import essential.objects.enums.Direction;
import essential.objects.impl.*;
import essential.observer.realization.StepsNotifierImpl;

import java.util.List;

public class ArrayCollection extends StepsNotifierImpl implements GameCollection {

    // B - Brick, GG - Gold, P - Player, G - Ground, E - Exit
    String[][] initialData = {
            {"B", "G", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"GG", "G", "G", "GG", "GG", "GG", "E", "B", "B", "B", "G"},
            {"G", "G", "B", "B", "G", "B", "B", "G", "B", "B", "G"},
            {"G", "G", "B", "B", "M", "B", "B", "M", "B", "B", "G"},
            {"GG", "G", "G", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "B", "G", "G", "G", "G", "G", "P", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "GG", "G", "GG", "B", "B", "G"},
            {"M", "B", "B", "B", "B", "B", "B", "B", "B", "B", "G"},
            {"M", "B", "G", "G", "G", "G", "G", "G", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "G", "G", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"}
    };

    private AbstractGameObject[][] data;
    private List<AbstractMovableObject> movableObjects;

    public ArrayCollection() {
        initData();
    }

    private void initData() {
        data = new AbstractGameObject[initialData.length][initialData[0].length];

        for (int i = 0; i < initialData.length; i++) {
            for (int j = 0; j < initialData[i].length; j++) {
                String value = initialData[i][j];

                if (value.equals("B")) {
                    data[i][j] = new Wall();
                } else if (value.equals("G")) {
                    data[i][j] = new Ground();
                } else if (value.equals("GG")) {
                    data[i][j] = new Gold();
                } else if (value.equals("P")) {
                    data[i][j]  = new Goldman();
                } else if (value.equals("E")) {
                    data[i][j] = new Exit();
                } else if (value.equals("M")) {
                    data[i][j] = new Monster();
                }

                data[i][j].setY(i);
                data[i][j].setX(j);
            }
        }

    }

    @Override
    public AbstractGameObject[][] getData() {
        return data;
    }

    public void setObjectByCoordinate(int y, int x, AbstractGameObject object) {
        try {
            object.setX(x);
            object.setY(y);
            data[y][x] = object;
        } catch (Exception e) {
            System.out.println("Out of the coordinate: " + y + " " + x + " " + object.getClass().getSimpleName());
        }
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int y, int x) {
        try {
            return data[y][x];
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void moveMovableObjects(Direction direction) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] instanceof AbstractMovableObject) {
                    AbstractMovableObject movableObject = (AbstractMovableObject) data[i][j];


                    int[] nextCoordinate = movableObject.nextCoordinate(direction);
                    int y = nextCoordinate[0];
                    int x = nextCoordinate[1];

                    AbstractGameObject nextObject = getObjectByCoordinate(y, x);

                    if (movableObject.canMove(nextObject)) {
                        setObjectByCoordinate(movableObject.getY(), movableObject.getX(), new Ground());
                        setObjectByCoordinate(y, x, movableObject);
                    }

                    if (movableObject.getClass() == Goldman.class) {
                        Goldman goldman = (Goldman) movableObject;
                        notifyAll(goldman);
                    }
                }
            }

        }

        notifyAllObject();



    }

}
