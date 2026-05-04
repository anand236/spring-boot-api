
package create_api.test.register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterForDb, Integer> {
//    this is for checking after user logs in
    Optional<RegisterForDb> findByEmail(String email);
    Optional<RegisterForDb> findByPassword(String password);
}
