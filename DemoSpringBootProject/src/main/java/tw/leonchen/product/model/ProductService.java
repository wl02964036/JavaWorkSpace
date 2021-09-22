package tw.leonchen.product.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product findById(Integer id) {
		Optional<Product> pRep = productRepository.findById(id);
		if(pRep.isPresent()) {
			return pRep.get();
		}
		
		return null;
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	
	public Page<Product> findAllByPage(Pageable pageable){
		return productRepository.findAll(pageable);
	}
	
	public Product insertProduct(Product p) {
		return productRepository.save(p);
	}
	
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}
	
	public void deleteProduct(Product p) {
		productRepository.delete(p);
	}
}
