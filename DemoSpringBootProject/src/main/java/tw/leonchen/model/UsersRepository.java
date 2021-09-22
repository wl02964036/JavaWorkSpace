package tw.leonchen.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	//concat(): SQL '+' 的寫法
	@Query(value = "from Users where username like concat('%',?1,'%')")
	public List<Users> findUsers(String username);
	
	public List<Users> findByUsernameLike(String username);

	@Query(value = "Select * From Users", nativeQuery = true)
	public List<Users> findAll();
}
