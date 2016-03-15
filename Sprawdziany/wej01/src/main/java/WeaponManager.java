import java.util.ArrayList;



public class WeaponManager
{
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();


    public void add(Weapon w)
    {
        weapons.add(w);
    }


    public ArrayList<Weapon> getAll()
    {
        return weapons;
    }


}
