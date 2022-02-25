import static org.junit.Assert.*;

import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    //Snippet 1
    @Test
    public void testSnippet1() {
        String contents = "`[a link`](url.com)\n" +
                "\n" +
                "[another link](`google.com)`\n" +
                "\n" +
                "[`cod[e`](google.com)\n" +
                "\n" +
                "[`code]`](ucsd.edu)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    //Snippet 2
    @Test
    public void testSnippet2() {
        String contents = "[a [nested link](a.com)](b.com)\n" +
                "\n" +
                "[a nested parenthesized url](a.com(()))\n" +
                "\n" +
                "[some escaped \\[ brackets \\]](example.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    //Snippet 3
    @Test
    public void testSnippet3() {
        String contents = "[this title text is really long and takes up more than \n" +
                "one line\n" +
                "\n" +
                "and has some line breaks](\n" +
                "    https://www.twitter.com\n" +
                ")\n" +
                "\n" +
                "[this title text is really long and takes up more than \n" +
                "one line](\n" +
                "    https://ucsd-cse15l-w22.github.io/\n" +
                ")\n" +
                "\n" +
                "\n" +
                "[this link doesn't have a closing parenthesis](github.com\n" +
                "\n" +
                "And there's still some more text after that.\n" +
                "\n" +
                "[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/\n" +
                "\n" +
                "\n" +
                "\n" +
                ")\n" +
                "\n" +
                "And then there's more text";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}