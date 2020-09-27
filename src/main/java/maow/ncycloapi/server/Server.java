package maow.ncycloapi.server;

import maow.ncycloapi.Ncyclo;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private String data;
    private String[] exclusions;

    public void send(String data, String... exclusions) {
        this.data = data;
        this.exclusions = exclusions;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(Ncyclo.PORT)) {
            //noinspection InfiniteLoopStatement
            while (true) {
                new ServerThread(serverSocket.accept(), data, exclusions).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}