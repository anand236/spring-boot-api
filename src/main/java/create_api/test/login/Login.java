package create_api.test.login;

import jakarta.persistence.*;

//@Entity
//@Table(name = "loginuser")
public class Login {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    private String email;
    private String password;

//    Getters
//    public int getId(){
//        return id;
//    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

//    Setters
//    public void setId(int id){
//        this.id = id;
//    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
