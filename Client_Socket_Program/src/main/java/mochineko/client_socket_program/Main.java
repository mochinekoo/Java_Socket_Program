package mochineko.client_socket_program;

import mochineko.client_socket_program.manager.ConnectManager;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("socket通信プログラミング（クライアント）");

        ConnectManager connect = ConnectManager.getInstance();
        while (true) {
            System.out.print("接続したいIPを入力してください:\n>");
            String hostName = scanner.nextLine();
            connect.setHostName(hostName);
            System.out.print("ポートを入力してください\n>");
            int port = scanner.nextInt();
            connect.setPort(port);
            System.out.printf("入力したIPは%s, portは%dです。\n", hostName, port);
            connect.connect();
            break;
        }
    }

}
