package sze.thesis.service;

import lombok.AllArgsConstructor;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.springframework.stereotype.Service;
import sze.thesis.model.CreateUserDto;
import sze.thesis.model.Credentials;
import sze.thesis.security.KeyCloakConfig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class KeyCloakService {


    public void addUser(CreateUserDto createUserDto){
        CredentialRepresentation credential = Credentials
                .createPasswordCredentials(createUserDto.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(createUserDto.getUsername());
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);

        UsersResource instance = getInstance();
        instance.create(user);
    }

    public List<UserRepresentation> getUser(String userName){
        UsersResource usersResource = getInstance();
        List<UserRepresentation> user = usersResource.search(userName, true);
        return user;

    }

    public void updateUser(String userId, CreateUserDto createUserDto){
        CredentialRepresentation credential = Credentials
                .createPasswordCredentials(createUserDto.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(createUserDto.getUsername());
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setCredentials(Collections.singletonList(credential));

        UsersResource usersResource = getInstance();
        usersResource.get(userId).update(user);
    }
    public void deleteUser(String userId){
        UsersResource usersResource = getInstance();
        usersResource.get(userId)
                .remove();
    }


    public void sendVerificationLink(String userId){
        UsersResource usersResource = getInstance();
        usersResource.get(userId)
                .sendVerifyEmail();
    }

    public void sendResetPassword(String userId){
        UsersResource usersResource = getInstance();

        usersResource.get(userId)
                .executeActionsEmail(Arrays.asList("UPDATE_PASSWORD"));
    }

    public UsersResource getInstance(){
        return KeyCloakConfig.getInstance().realm(KeyCloakConfig.realm).users();
    }


}