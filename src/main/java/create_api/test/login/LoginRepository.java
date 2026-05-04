package create_api.test.login;

import create_api.test.register.Register;
import create_api.test.register.RegisterForDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<RegisterForDb, Integer> {
    Optional<RegisterForDb> findByEmail(String email);
}
