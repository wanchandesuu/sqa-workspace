import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestShiftCipher {
    private final ShiftCipher shiftCipher = new ShiftCipher();

    @Test // TC01
    void testCase01() {
        assertEquals("ZVMADHYL", shiftCipher.shift("SOFTWARE", 3));
    }

    @Test // TC02
    void testCase02() {
        assertEquals("zvmadhyl", shiftCipher.shift("software", 3));
    }

    @Test // TC03
    void testCase03() {
        assertEquals("DEF", shiftCipher.shift("ABC", 3));
    }

    @Test // TC04
    void testCase04() {
        assertEquals("GHID", shiftCipher.shift("DEFA", 3));
    }
}
