package com.legit.ScratchDocker;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

import java.net.Socket;

/**
 * Created by natha on 8/4/2017.
 */
public class Main {

    public static void main(String[] args) {
        startSocketServer();
    }

    static void startSocketServer() {
        Configuration config = new Configuration();
        config.setHostname("0.0.0.0");
        config.setPort(9092);



        final SocketIOServer server = new SocketIOServer(config);
        server.addEventListener("messageevent", MessageEvent.class, new DataListener<MessageEvent>() {
            @Override
            public void onData(SocketIOClient client, MessageEvent data, AckRequest ackSender) throws Exception {
                server.getBroadcastOperations().sendEvent(data.tag, data.content);
            }
        });

        server.startAsync();
    }


}
