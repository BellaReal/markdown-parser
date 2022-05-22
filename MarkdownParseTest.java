import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTester() throws IOException {
        String content = Files.readString(Path.of("test-file.md"));
        assertEquals(List.of("https://something.com","some-thing.html"),
            MarkdownParse.getLinks(content));
    }

    // THIS IS A TEST THAT FAILS -> NOW THIS TEST SHOULD PASS
    @Test
    public void getLinksMyTester1() throws IOException {
        String content = Files.readString(Path.of("my-test-file1.md"));
        assertEquals(List.of(),
            MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksMyTester2() throws IOException {
        String content = Files.readString(Path.of("my-test-file2.md"));
        assertEquals(List.of("onlythisshouldprint.com"),
            MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksMyTester3() throws IOException {
        String content = Files.readString(Path.of("my-test-file3.md"));
        assertEquals(List.of("3thisfileshouldprint.com"),
            MarkdownParse.getLinks(content));
    }

    //----------------------NEW TESTS FOR LAB REPORT 4----------------------
    @Test
    public void getLinksSnippet1() throws IOException{
        String content = Files.readString(Path.of("snippet1.md"));
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"),
            MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksSnippet2() throws IOException{
        String content = Files.readString(Path.of("snippet2.md"));
        assertEquals(List.of("a.com", "a.com(())", "example.com"),
            MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksSnippet3() throws IOException {
        String content = Files.readString(Path.of("snippet3.md"));
        assertEquals(List.of( 
    "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"),
        MarkdownParse.getLinks(content));
    }

}