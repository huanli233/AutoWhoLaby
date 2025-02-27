package com.huanli233.autowho.listener;

import net.labymod.api.Laby;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import com.huanli233.autowho.AutoWhoAddon;

public class ChatListener {

    private final AutoWhoAddon addon;

    public ChatListener(AutoWhoAddon addon) {
        this.addon = addon;
    }

    @Subscribe
    public void onChat(ChatReceiveEvent event) {
        if (Laby.labyAPI().serverController().getCurrentServerData() == null) {
            return;
        }
        String message = event.chatMessage().getOriginalPlainText();

        addon.checkAndSend(message);

    }

}