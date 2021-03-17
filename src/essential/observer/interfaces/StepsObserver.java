package essential.observer.interfaces;

import essential.objects.abstraction.AbstractMovableObject;
import essential.objects.impl.Goldman;

public interface StepsObserver {

    void notify(Goldman movableObject);

    void notifyObject();

}
