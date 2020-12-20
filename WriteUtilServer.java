import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Writes the keyStrokes from the server to the client
 */
public class WriteUtilServer implements Runnable {
    private PrintWriter writer;
    Scanner scan;

    public WriteUtilServer(PrintWriter writer, Scanner scan) {
        this.writer = writer;
        this.scan = scan;
    }

    public void run() {
        while(true) {
            try {
                String keyStroke = scan.nextLine();
                // keyStroke = scan.nextLine(); // TODO get keyStroke string
                writer.println(Server.getName() + ": " + keyStroke); // sends the keyStroke string to client
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
