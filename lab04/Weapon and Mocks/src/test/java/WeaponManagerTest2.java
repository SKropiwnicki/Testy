import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

//EASYMOCK  TUTAJ
public class WeaponManagerTest2 {

    @Rule
    public EasyMockRule mocks = new EasyMockRule(this);

    @Mock
    private IMyList mock;

    @TestSubject
    private IWeaponManager weaponMng = new WeaponManager(mock);

    Weapon w1;
    Weapon w2;
    Weapon w3;

    @Before
    public void setUp() throws Exception {
         w1 = new Weapon("Sword", 10, 20);
         w2 = new Weapon("Axe", 11, 20);
         w3 = new Weapon("Bow", 1, 201);
    }

    @Test
    public void addTest() {
        mock.add(w1);
        expectLastCall();
        expect(mock.size()).andReturn(1);
        expect(mock.getAll()).andReturn(mock);
        replay(mock);
        weaponMng.add(w1);

        assertEquals(1, weaponMng.getAll().size());
        verify(mock);
    }



}
