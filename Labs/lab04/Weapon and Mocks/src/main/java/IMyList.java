/**
 * Created by Kasiunia on 2016-03-22.
 */
public interface IMyList {
    void add (Weapon weapon);

    IMyList get(int index);
    IMyList getAll();
    int size();
    boolean isEmpty();
}
