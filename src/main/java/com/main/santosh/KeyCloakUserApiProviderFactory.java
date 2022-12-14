package com.main.santosh;

import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

import com.main.santosh.KeyCloakUserApiProvider;

public class KeyCloakUserApiProviderFactory implements RealmResourceProviderFactory {
    public static final String ID = "customApi";

    public RealmResourceProvider create(KeycloakSession session) {
        return new KeyCloakUserApiProvider(session);
    }

    public void init(Scope config) {
    }

    public void postInit(KeycloakSessionFactory factory) {
    }

    public void close() {
    }

    public String getId() {
        return ID;
    }
}