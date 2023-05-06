package in.vaxa.springbootcruddemo.controller;

import in.vaxa.springbootcruddemo.entity.Product;
import in.vaxa.springbootcruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @PostMapping("/product")
  public Product addProduct(@RequestBody Product product) {
    return productService.saveProduct(product);
  }

  @PostMapping("/products")
  public List<Product> addProducts(@RequestBody List<Product> products) {
    return productService.saveProducts(products);
  }

  @GetMapping("/products")
  public List<Product> findAllProducts() {
    return productService.getProducts();
  }

  @GetMapping("/product/{id}")
  public Product findProductById(@PathVariable int id) {
    return productService.getProductById(id);
  }

  @GetMapping("/product")
  public Product findProductByName(@RequestParam String name) {
    return productService.getProductByName(name);
  }

  @PutMapping("/product")
  public Product updateProduct(@RequestBody Product product) {
    return productService.updateProduct(product);
  }

  @DeleteMapping("/product/{id}")
  public String deleteProduct(@PathVariable int id) {
    return productService.deleteProduct(id);
  }
}
