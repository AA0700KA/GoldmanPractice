package essential.objects.impl;

import essential.objects.abstraction.AbstractMovableObject;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Goldman extends AbstractMovableObject {

    private int stepsCount = 50;
    private int score;

    public Goldman() {
        super();
        setImage(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score += score;
    }

    public void count() {
        stepsCount--;
    }

}
