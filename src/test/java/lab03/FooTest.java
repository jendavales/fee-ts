package lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FooTest {
    private Foo foo;

    @BeforeEach
    public void setup() {
        foo = new Foo();
    }

    @Test
    public void returnNumber_returnsNumber5_true() {
        Assertions.assertEquals(5, foo.returnNumber());
    }

    @Test
    public void getNum_getsNum_numberIs0() {
        Assertions.assertEquals(0,foo.getNum());
    }

    @Test
    public void incrementNum_incrementsNum_numberIs3() {
        foo.increment();
        Assertions.assertEquals(1,foo.getNum());
        foo.increment();
        foo.increment();
        Assertions.assertEquals(3,foo.getNum());
    }

    @Test
    public void foo_exceptionThrown_exceptionCatched() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> foo.exceptionThrown());
        Assertions.assertEquals("Ocekavana vyjimka", exception.getMessage());
    }
}
