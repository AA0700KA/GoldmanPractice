package essential.observer.interfaces;

import essential.objects.abstraction.AbstractMovableObject;
import essential.objects.impl.Goldman;

public interface StepsNotifier {

    void notifyAll(Goldman movableObject);

    void notifyAllObject();

    void addObserver(StepsObserver observer);

}
