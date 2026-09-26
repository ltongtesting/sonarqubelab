import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

public class BookTest {

    @Test(expected = NullPointerException.class)
    public void testMockException() {
        try (MockedStatic<AgaUtils> mockedAgaUtils = mockStatic(AgaUtils.class)) {
            mockedAgaUtils.when(() -> AgaUtils.getTextUppercase(anyString()))
                    .thenThrow(new NullPointerException());

            Book book = new Book();

            book.getTitle();
        }
    }

    @Test
    public void testMockObjectStatic() {
        try (MockedStatic<AgaUtils> mockedAgaUtils = mockStatic(AgaUtils.class)) {
            mockedAgaUtils.when(() -> AgaUtils.getTextUppercase(anyString()))
                    .thenReturn("yesterday");

            Book book = new Book();

            String resultado = book.getTitle();

            Assert.assertEquals("yesterday", resultado);
        }
    }

    @Test
    public void testGetTitle() {
        Book book = new Book();

        String resultado = book.getTitle();

        Assert.assertEquals("TODAY IS THE DAY", resultado);
    }
}
