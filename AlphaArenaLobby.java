import java.io.IOException;
import java.util.Scanner;

public class AlphaArenaLobby {
    private boolean isServer;

    private String name;

    public AlphaArenaLobby() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Do you want to host the game?"); // Need to put GUI in herea
        String answer = scan.nextLine();

        if(answer.toLowerCase().equals("yes")) {
            isServer = true;
        } else {
            isServer = false;
        }

        System.out.println("Input your name: "); // Need to put GUI in here
        this.name = scan.nextLine();
    }

    public boolean getIsServer() {
        return isServer;
    }

    public String getName(){
        return name;
    }

    public static void main(String[] args) throws IOException {
        AlphaArenaLobby lobby = new AlphaArenaLobby();
        String name = lobby.getName();
        boolean isServer = lobby.getIsServer();

        if(isServer) {
            Server server = new Server();
            System.out.println("Now running server...");
            server.setName(name);
            server.serveClients();
        } else {
            Client client = new Client();
            client.setName(name);
            Thread t = new Thread(client);
            t.start();
            System.out.println("Now running client....");
        }
    }
}
