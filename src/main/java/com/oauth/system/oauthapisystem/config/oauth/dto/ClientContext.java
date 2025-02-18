package com.oauth.system.oauthapisystem.config.oauth.dto;

public class ClientContext {
    private static final ThreadLocal<String> clientId = new ThreadLocal<>();

    public static void setClientId(String clientId) {
        ClientContext.clientId.set(clientId);
    }

    public static String getClientId() {
        return clientId.get();
    }

    public static void clear() {
        clientId.remove();
    }
}
