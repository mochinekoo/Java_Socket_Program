package mochineko.server_socket_program;

import mochineko.server_socket_program.manager.ConnectManager;

public class Main {

    public static void main(String[] args) {
        System.out.println("Socket通信プログラミング（サーバー側）");
        ConnectManager.getInstance().startServer();
    }

}
