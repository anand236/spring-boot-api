package create_api.test.register;

public class Register {
//    private int id;
    private String email;
    private String password;
    private String confirmpassword;

//    public int getId(){
//        return this.id;
//    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword(){
        return confirmpassword;
    }

    public void setEmail(String email){
        this.email = email;
    }
//    public void setId(int id){
//        this.id = id;
//    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setConfirmpassword(String confirmpassword){
        this.confirmpassword = confirmpassword;
    }
}
