package create_api.test.login;

import create_api.test.config.JwtConfig;
import create_api.test.register.RegisterForDb;
import create_api.test.register.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepo;
    @Autowired
    private RegisterRepository registerRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtConfig jwtConfig;


    public Map<String, String> loginUserData(Login userData){

        Optional<RegisterForDb> userEmail = loginRepo.findByEmail(userData.getEmail());

        if(userEmail.isPresent()){
            if(passwordEncoder.matches(userData.getPassword(), userEmail.get().getPassword())){

                String token = jwtConfig.generateToken(userData.getEmail());
                return Map.of(
                        "message","login successfull",
                        "token", token
                );
            }else{
                return Map.of("message","wrong credential");
            }
        }

        return Map.of("message","User not found");



//        if(userData.getEmail().equals(loginRepo.findByEmail().isPresent())){
//            Map.of("message", "Logged in successfully!");
//        }

//        Login user = new Login();
//        user.setEmail(userData.getEmail());
//        this.loginRepo.save(user.getEmail());
    };
}
