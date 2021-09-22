package tw.leonchen.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.leonchen.exception.UserNotFoundException;

@Service
@Transactional
public class UserProfilesService {

	@Autowired
	private UserProfilesRepository upRepository;
	
	public UserProfiles getByName(String name) {
		Optional<UserProfiles> uResp = upRepository.findByName(name);
	
		if(uResp.isEmpty()) {
			throw new UserNotFoundException("Can't find User");
		}
		
		return uResp.get();
	}
	
	public UserProfiles createUserProfiles(UserProfiles userprofiles) {
		return upRepository.save(userprofiles);
	}
}
