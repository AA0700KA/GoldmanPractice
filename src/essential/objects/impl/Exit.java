package essential.objects.impl;

import essential.objects.abstraction.AbstractGameObject;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Exit extends AbstractGameObject {

    public Exit() {
        super();
        setImage(new ImageIcon(getClass().getResource("/images/exit.gif")));
    }



}
