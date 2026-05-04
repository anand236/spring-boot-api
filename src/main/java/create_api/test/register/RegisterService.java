package create_api.test.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    here registerUser ( is angular payload data)
    public Map<String, String> registerDetail(Register registerUser){

//        this is for checking password and confirm password matching or not
        if(!registerUser.getPassword().equals(registerUser.getConfirmpassword())){
            return Map.of("message","Password do not matched") ;
        }

//        this is to check wether email already exist or not
        if(registerRepo.findByEmail(registerUser.getEmail().trim().toLowerCase()).isPresent()){
            return Map.of("message","Email already exists");
        }

        if(registerRepo.findByPassword(registerUser.getPassword()).isPresent()){
            return Map.of("message","same password already exists");
        }




//        this is to create new user in db after registering new account
        RegisterForDb  newUser = new RegisterForDb ();
        newUser.setEmail(registerUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        registerRepo.save(newUser);

        return Map.of("message","User registered successfully");
    }
}
