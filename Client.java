import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Runnable{

    private static String name;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        try {

            String address = InetAddress.getLocalHost().getCanonicalHostName(); // Gets the IP Address

            Socket socket = new Socket(address, 4242);

            System.out.println(this.getName() + " connected to host");

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scan = new Scanner(System.in);

            ReadUtilClient readUtil = new ReadUtilClient(reader);
            WriteUtilClient writeUtil = new WriteUtilClient(writer, scan);

            Thread readThread = new Thread(readUtil);
            Thread writeThread = new Thread(writeUtil);

            readThread.start();
            writeThread.start();

        } catch (Exception e) {
            e.printStackTrace();
            // run();
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Thread t = new Thread(client);
        t.start();
    }
}
