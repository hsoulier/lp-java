package lpw.hippolyte.entity;

public class Enemy extends Entity{
    public Enemy(int lp, int att, int[] position) {
        super(lp, att, position);
    }

    @Override
    public int getLife() {
        return this.lp;
    }

    @Override
    public void attack(Entity target) {
        target.getHurt(this.att);
    }

}
