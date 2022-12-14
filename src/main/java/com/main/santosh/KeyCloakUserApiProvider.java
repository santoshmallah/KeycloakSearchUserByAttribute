package com.main.santosh;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.utils.MediaType;

import com.main.santosh.mappers.UserMapper;
import com.main.santosh.models.UserDto;

import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class KeyCloakUserApiProvider implements RealmResourceProvider {
    private final KeycloakSession session;
    private final String defaultAttr = "entity_id";
    private final UserMapper userMapper;
    
    public KeyCloakUserApiProvider(KeycloakSession session) {
        this.session = session;
        this.userMapper = new UserMapper();
    }

    public void close() {
    }

    public Object getResource() {
        return this;
    }

    @GET
    @Path("users/searchUserByAttribute")
    @NoCache
    @Produces({ MediaType.APPLICATION_JSON })
    @Encoded
    public List<UserDto> searchUsersByAttribute(@DefaultValue(defaultAttr) @QueryParam("attr") String attr,
            @QueryParam("value") String value) {
        return session.users().searchForUserByUserAttribute(attr, value, session.getContext().getRealm())
                .stream().map(e -> userMapper.mapToUserDto(e,attr)).collect(Collectors.toList());
    }
}