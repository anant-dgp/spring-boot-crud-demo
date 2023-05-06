package in.vaxa.springbootcruddemo.service;

import in.vaxa.springbootcruddemo.entity.Product;
import in.vaxa.springbootcruddemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> saveProducts(List<Product> products) {
    return productRepository.saveAll(products);
  }

  @Override
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(int id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public Product getProductByName(String name) {
    return productRepository.findByName(name);
  }

  @Override
  public String deleteProduct(int id) {
    productRepository.deleteById(id);
    return "Product deleted successfully!";
  }

  @Override
  public Product updateProduct(Product product) {
    Product existingProduct = productRepository.findById(product.getId()).orElse(null);
    existingProduct.setName(product.getName());
    existingProduct.setQuantity(product.getQuantity());
    existingProduct.setPrice(product.getPrice());
    return productRepository.save(existingProduct);
  }
}
