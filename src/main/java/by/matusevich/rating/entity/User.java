package by.matusevich.rating.entity;

public class User {
    private long idUser;
    private String name;
    private String surname;
    private String password;
    private String email;
    private Role role;

    public User(long idUser, String name, String surname, String password, String email, Role role) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(){}

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser &&
                (name == user.name ||
                        (name != null && name.equals(user.getName()))) &&
                (surname == user.surname ||
                        (surname != null && surname.equals(user.getSurname()))) &&
                (password == user.password  ||
                        password!=null || password.equals(user.getPassword())) &&
                (email == user.email ||
                        (email != null && email.equals(user.getEmail()))) &&
                (role == user.role ||
                        (role != null && role.equals(user.getRole())));
    }

    @Override
    public int hashCode() {
        return 31 * ((int)idUser *
                ((name == null) ? 0 : name.hashCode()) *
                ((surname == null) ? 0 : surname.hashCode()) *
                ((password == null) ? 0 : password.hashCode()) *
                ((email == null) ? 0 : email.hashCode()) *
                ((role == null) ? 0 : role.hashCode()));
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User{")
                .append("idUser=").append(idUser)
                .append(", name='").append(name).append('\'')
                .append(", surname='").append(surname).append('\'')
                .append(", password='").append(password).append('\'')
                .append(", email='").append(email).append('\'')
                .append(", role=").append(role).append('}').toString();
    }
}
