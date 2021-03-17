package essential.objects.abstraction;

import essential.objects.enums.Direction;

public abstract class AbstractMovableObject extends AbstractGameObject {

    public int[] nextCoordinate(Direction direction) {
        int x = getX();
        int y = getY();

        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        return new int[] {y, x};
    }

    public boolean canMove(AbstractGameObject gameObject) {
        return false;
    }

}
