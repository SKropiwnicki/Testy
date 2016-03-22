interface IWeaponManager {
    void add(Weapon w);
    IMyList getAll();
}


public class WeaponManager implements IWeaponManager
{
    private IMyList weapons;
    //ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    public WeaponManager(IMyList weapons){
        super();
        this.weapons = weapons;
    }


    public void add(Weapon w)
    {
        weapons.add(w);
    }


    public IMyList getAll()
    {
        return weapons.getAll();
    }


}
