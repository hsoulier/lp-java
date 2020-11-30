package lpw.hippolyte.entity;

import lpw.hippolyte.entity.Entity;

import java.util.ArrayList;

public abstract class Player extends Entity {
    protected int mp;

    protected ArrayList<String> inventory;

    public Player(int lp, int att) {
        super(lp, att, new int[]{1, 1});
    }
    protected void updatePosition(int[] newPos) {
        super.position = newPos;
    }

}
