package create_api.test.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/create")
//    RequestBody data is coming from angular payload (here user ne naya object create kiya Register model ka)
    public Map<String, String> postUserData(@RequestBody Register registerUserDetail){
        return registerService.registerDetail(registerUserDetail);
    }
}
