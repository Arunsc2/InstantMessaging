import java.io.BufferedReader;

/**
 * Reads the key Strokes from the client. This class is used by the Server
 */
public class ReadUtilServer implements Runnable {
    private BufferedReader reader;

    public ReadUtilServer(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() {
        while(true) {
            try {
                String received = reader.readLine();
                System.out.println(received); // for test purposes

                // TODO with received key stroke
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
