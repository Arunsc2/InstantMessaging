import java.io.BufferedReader;

/**
 * Reads the key strokes from the server. This class is used by the client
 */
public class ReadUtilClient implements Runnable {

    private BufferedReader reader;

    public ReadUtilClient(BufferedReader reader) {
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
    }}
