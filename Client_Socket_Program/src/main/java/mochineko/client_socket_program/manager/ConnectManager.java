package mochineko.client_socket_program.manager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import static mochineko.client_socket_program.Main.scanner;

public class ConnectManager {

    private static ConnectManager instance;
    private String hostName;
    private int port;
    private Socket socket;

    private ConnectManager() {
    }

    public static ConnectManager getInstance() {
        if (instance == null) {
            instance = new ConnectManager();
        }
        return instance;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void connect() {
        new Thread(() -> {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(hostName, port));
                this.socket = socket;
                do {
                    String line = scanner.nextLine();
                    socket.getOutputStream().write((line + "\n").getBytes());
                    socket.getOutputStream().flush();
                    System.out.println("[Client]" + line);
                } while (!socket.isClosed());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
