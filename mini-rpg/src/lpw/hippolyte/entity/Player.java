package lpw.hippolyte.entity;

import lpw.hippolyte.entity.Entity;

import java.util.ArrayList;

abstract class Player extends Entity {
    protected int mp;
    protected ArrayList<String> inventory;

    public Player(int lp, int att, int damage) {
        super(lp, att, damage);
    }
}