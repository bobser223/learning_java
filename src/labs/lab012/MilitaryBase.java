package labs.lab012;

public class MilitaryBase implements MilitaryObject{
    public String title;
    public int soldiers;
    public int tanks;

    public MilitaryBase(String title, int soldiers, int tanks){
        this.title = title;
        this.soldiers = soldiers;
        this.tanks = tanks;
    }

    @Override
    public String toString(){
        return String.format("%s: %d, %d", title, soldiers, tanks);
    }

    @Override
    public void accept(Spy spy){
        spy.visit(this);
    }
}
