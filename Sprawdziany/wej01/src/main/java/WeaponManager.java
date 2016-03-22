import java.util.ArrayList;

interface IWeaponManager {
    void add(Weapon w);
    ArrayList<Weapon> getAll();
}


public class WeaponManager implements IWeaponManager
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
