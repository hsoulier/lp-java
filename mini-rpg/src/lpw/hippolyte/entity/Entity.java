package lpw.hippolyte.entity;

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

    public void getHurt(int att) {
        this.lp -= att;
    }

    public void attackEntity(Entity target, int att) {
        target.getHurt(att);
    }

    public int[] getPosition() {
        return this.position;
    }

}
