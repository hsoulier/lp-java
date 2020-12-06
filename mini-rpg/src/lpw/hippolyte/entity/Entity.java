package lpw.hippolyte.entity;

import lpw.hippolyte.entity.races.Warrior;

abstract class Entity {
    protected int lp;
    protected int att;
    protected int damage;
    protected int[] position;

    public Entity(int lp, int att, int[] position) {
        this.lp = lp;
        this.att = att;
        this.damage = 0;
        this.position = position;
    }

    public void getHurt(int att) {  this.lp -= att; }

    public boolean isDead() {   return !(this.lp > 0); }

    public void attack(Enemy target, int att) {
        target.getHurt(att);
    }

    public int[] getPosition() {
        return this.position;
    }

    public abstract int getLife();

    public abstract void attack(Entity target);
}
