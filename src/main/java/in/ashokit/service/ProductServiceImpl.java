package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.ashokit.entity.Product;
import in.ashokit.repo.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	
	public boolean saveProduct(Product p) {
		Product saveProduct=productRepository.save(p);
		return saveProduct.getPid()!=null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
