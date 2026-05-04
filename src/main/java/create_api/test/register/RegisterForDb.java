package create_api.test.register;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class RegisterForDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column (name="password", unique = true, nullable = false)
    private String password;

//    Getters
    public int getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

//    Setters
    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
