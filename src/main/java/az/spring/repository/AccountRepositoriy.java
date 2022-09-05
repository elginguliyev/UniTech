package az.spring.repository;

import az.spring.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoriy  extends JpaRepository<Account , Integer> {
}
