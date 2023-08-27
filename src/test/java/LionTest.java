import com.example.Feline;
import com.example.Lion;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest extends TestCase {

    @Mock
    private Feline feline;
    private final String sex = "Самец";

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(5);
        assertEquals(5, lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        assertEquals(expected, lion.getFood());
    }
    @Test
    public void testException() {
        Throwable thrown = assertThrows(Exception.class, () -> {
            new Lion("Гермафродит", feline).doesHaveMane();
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
    }
    @Test
    public void doesHaveManeMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean result = lion.doesHaveMane();
        assertEquals(true, result);
    }
    @Test
    public void doesHaveManeFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean result = lion.doesHaveMane();
        assertEquals(false, result);
    }
}