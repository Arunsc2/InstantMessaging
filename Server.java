import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    private static String name;

    public Server() throws IOException {
        serverSocket = new ServerSocket(4242);
        this.name = "Server";
    }

    public void serveClients() throws IOException {
        Socket socket;
        ActionHandler handler;
        Thread threadHandler;

        while(true) {
            try {
                socket = this.serverSocket.accept();
                System.out.println("The client has connected...");
            } catch (IOException e) {
                break;
            }

            handler = new ActionHandler(socket);
            handler.setName(this.name);
            threadHandler = new Thread(handler);
            threadHandler.start();
        }
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.serveClients();
    }

}
