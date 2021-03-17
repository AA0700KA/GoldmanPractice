package essential.collection;

import essential.objects.abstraction.AbstractGameObject;
import essential.objects.enums.Direction;

public interface GameCollection {

    AbstractGameObject[][] getData();

    void setObjectByCoordinate(int y, int x, AbstractGameObject object);

    AbstractGameObject getObjectByCoordinate(int y, int x);

    void moveMovableObjects(Direction direction);

}
