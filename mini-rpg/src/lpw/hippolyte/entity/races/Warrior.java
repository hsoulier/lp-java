package lpw.hippolyte.entity.races;

import lpw.hippolyte.entity.*;

public class Warrior extends Player {
    public Warrior() {
        super(70, 7);
    }


    @Override
    public int getLife() {
        return this.lp;
    }


}
