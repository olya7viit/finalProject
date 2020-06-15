package by.matusevich.rating.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    USER(1),
    ADMIN(2),
    GUEST(3);

    private int idRole;

    Role(int idRole){
        this.idRole = idRole;
    }

    public int getUserRolesId(){
        return idRole;
    }

    public static Optional<Role> getUserRoleById(int idRole){
        Role[] usersId = Role.values();
        Optional<Role> role = Arrays.stream(usersId).filter(o -> o.getUserRolesId() == idRole).findAny();
        return role;
    }

}