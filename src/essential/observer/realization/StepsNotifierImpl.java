package essential.observer.realization;

import essential.objects.abstraction.AbstractMovableObject;
import essential.objects.impl.Goldman;
import essential.observer.interfaces.StepsNotifier;
import essential.observer.interfaces.StepsObserver;

import java.util.ArrayList;
import java.util.List;

public class StepsNotifierImpl implements StepsNotifier {

    private List<StepsObserver> observers = new ArrayList<>();


    @Override
    public void notifyAll(Goldman goldman) {
        for (StepsObserver observer: observers) {
            observer.notify(goldman);
        }
    }

    @Override
    public void notifyAllObject() {
        for (StepsObserver observer : observers) {
            observer.notifyObject();
        }
    }

    @Override
    public void addObserver(StepsObserver observer) {
        observers.add(observer);
    }


}
