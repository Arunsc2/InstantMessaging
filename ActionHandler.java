import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ActionHandler implements Runnable{
    private final Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private static String name;

    public ActionHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        writer = new PrintWriter(this.clientSocket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        name = "Server"; // TODO Set Name
    }

   public void run() {

        System.out.println(this.getName() + " has been connected to the client");

        Scanner scan = new Scanner(System.in);

        ReadUtilServer readUtil = new ReadUtilServer(reader);
        WriteUtilServer writeUtil = new WriteUtilServer(writer, scan);

        Thread readThread = new Thread(readUtil);
        Thread writeThread = new Thread(writeUtil);

        readThread.start();
        writeThread.start();
   }

   public static String getName() {
        return name;
   }

   public void setName(String name) {
        this.name = name;
   }





}
