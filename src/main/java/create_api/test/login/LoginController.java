package create_api.test.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginSer;

    @PostMapping("/login")
    public Map<String, String> loginDetails(@RequestBody Login userData){
        return this.loginSer.loginUserData(userData);
    };
}
