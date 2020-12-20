import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Writes the key strokes from the Client to the Server
 */
public class WriteUtilClient implements Runnable {
    private PrintWriter writer;
    private Scanner scan;

    public WriteUtilClient(PrintWriter writer, Scanner scan) {
        this.writer = writer;
        this.scan = scan;
    }

    public void run() {
        while(true) {
            try {
                String keyStroke = scan.nextLine();
                // keyStroke = scan.nextLine(); // TODO get keyStroke string
                writer.println(Client.getName() +": " + keyStroke);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
