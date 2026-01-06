package mochineko.server_socket_program.manager;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectManager {

    private static ConnectManager instance;
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 25565;

    private ConnectManager() {}

    public static ConnectManager getInstance() {
        if (instance == null) {
            instance = new ConnectManager();
        }
        return instance;
    }

    public void startServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket()){
                serverSocket.bind(new InetSocketAddress(HOSTNAME, PORT));
                System.out.println("[Server] 起動しました");
                Socket socket = serverSocket.accept();

                do {
                    InputStream input = socket.getInputStream();
                    Scanner scanner = new Scanner(input);
                    String message = scanner.nextLine();

                    System.out.println("[Server]" + message);
                } while (!serverSocket.isClosed());
            } catch(IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
