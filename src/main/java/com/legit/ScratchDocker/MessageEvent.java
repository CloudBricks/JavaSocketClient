package com.legit.ScratchDocker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by natha on 8/4/2017.
 */
public class MessageEvent {

    public final String tag;
    public final String content;
    public final String metadata;

    static Map<Integer,MessageEvent> messages = new HashMap<>();

    public MessageEvent(){
        tag = content = metadata = "";
    }

    public MessageEvent forId(int id){
        return messages.get(id);
    }

    public void destroy(int id){
        messages.remove(id);
    }

    public String toString(){
        return tag + " : " + content;
    }
}
