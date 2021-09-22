package tw.leonchen.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfilesRepository extends JpaRepository<UserProfiles, String> {

	public Optional<UserProfiles> findByName(String name);
}
