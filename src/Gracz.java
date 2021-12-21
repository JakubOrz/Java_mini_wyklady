public class Gracz implements Checkable {
    public int lvl;
    public String nick;

    public Gracz(int lvl, String nick){
        this.lvl = lvl;
        this.nick = nick;
    }

    public String toString(){
        return this.nick +" lvl: "+this.lvl;
    }

    @Override
    public boolean validate() {
        return lvl > 0 && lvl < 300;
    }
}
