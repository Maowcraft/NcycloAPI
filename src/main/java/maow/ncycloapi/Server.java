package maow.ncycloapi;

import maow.ncycloapi.util.ExcludeType;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    private ServerSocket serverSocket;

    private static Server instance;

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    private Server() {
        try {
            serverSocket = new ServerSocket(Ncyclo.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String data, ExcludeType excludeType, String[] receivers) {
        if (serverSocket != null) {
            try (Socket socket = serverSocket.accept()) {
                InputStream fromClient = socket.getInputStream();
                DataInputStream in = new DataInputStream(fromClient);
                String[] receiverNames = in.readUTF().replaceAll(",+", " ").split("\\s+");
                System.out.println(Arrays.toString(receiverNames));
                OutputStream toClient = socket.getOutputStream();
                DataOutputStream out = new DataOutputStream(toClient);
                switch (excludeType) {
                    case INCLUDE: {
                        for (String receiverName : receiverNames) {
                            if (!Arrays.asList(receivers).contains(receiverName)) {
                                out.writeUTF("ncyclo:server:skip");
                            } else {
                                out.writeUTF(data);
                            }
                            break;
                        }
                    }
                    case EXCLUDE: {
                        for (String receiverName : receiverNames) {
                            if (Arrays.asList(receivers).contains(receiverName)) {
                                out.writeUTF("ncyclo:server:skip");
                            } else {
                                out.writeUTF(data);
                            }
                            break;
                        }
                        break;
                    }
                    case NONE:
                    default: {
                        out.writeUTF(data);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}