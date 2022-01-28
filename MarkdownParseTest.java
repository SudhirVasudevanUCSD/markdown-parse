
import static org.junit.Assert.*;

import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParseTest {
    @Test
    public void testTestFile1() throws IOException {
        System.out.println("test ran");
        assertEquals(new ArrayList<String>(),
                MarkdownParse.getLinks(Files.readString(Path.of(("test-file" +
                        ".md")))));

    }
}