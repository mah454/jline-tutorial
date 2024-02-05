package ir.moke.jline;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        Terminal terminal = TerminalBuilder.builder().build();
        DefaultParser parser = new DefaultParser();
        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .parser(parser)
                .build();
        while (true) {
            try {
                String line = reader.readLine("prompt > ");
                System.out.println(line);
            } catch (UserInterruptException e) {
                // Ignore
            } catch (EndOfFileException e) {
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}