package tw.leonchen.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BirdService {
	
	@Autowired
	private BirdRepository birdRepository;

	//新增	//save()存在是更新，不存在是新增
	public Bird insert(Bird bird) {
		return birdRepository.save(bird);
	}
	
	//更新	//save()存在是更新，不存在是新增
	public Bird update(Bird bird) {
		return birdRepository.save(bird);
	}
	
	//刪除一筆
	public void deleteById(Integer id) {
		birdRepository.deleteById(id);
	}
	
	//查詢一筆
	public Bird findById(Integer id) {
		Optional<Bird> birdOptional = birdRepository.findById(id);
		return birdOptional.get();
	}
}
