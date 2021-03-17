package essential.objects.impl;

import essential.objects.abstraction.AbstractMovableObject;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Monster extends AbstractMovableObject {

    public Monster() {
        super();
        setImage(new ImageIcon(getClass().getResource("/images/monster_up.jpg")));
    }

}
