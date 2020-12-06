package lpw.hippolyte.entity;

import lpw.hippolyte.entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Player extends Entity {
    protected int mp;

    protected ArrayList<String> inventory;

    public Player(int lp, int att) {
//        super(lp, att, new int[]{1, 1});
        super(lp, att, new int[]{5, 1});
    }

    protected void updatePosition(int[] newPos) {
        super.position = newPos;
    }

    public String isIntersect(Obstacle obstacle, Monster monster) {
        if (Arrays.equals(this.getPosition(), obstacle.getPosition())) {
            return "obstacle";
        } else if (Arrays.equals(this.getPosition(), monster.getPosition())) {
            return "monster";
        } else {
            return null;
        }
    }

    public void attack(Entity target) {
        target.getHurt(this.att);
    }

}
