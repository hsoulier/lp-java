package lpw.hippolyte;

abstract class Entity {
    protected int lp;
    protected int att;
    protected int damage;

    public Entity(int lp, int att, int damage) {
        this.lp = lp;
        this.att = att;
        this.damage = damage;
    }
    public void getHurt(int att) {
        this.lp -= att;
    }
    public void attackEntity(Entity target, int att) {
        target.getHurt(att);
    }


}
