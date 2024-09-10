package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.Product;
import in.ashokit.service.ProductService;

@Controller
public class ProductController {
 @Autowired
 private ProductService productService;
 
  @GetMapping("/")
  public  String loadForm(Model model)
  { 
	  model.addAttribute("pobj", new Product());
	  return "index";
	}
  @PostMapping("/product")
 public String saveProduct(Product product,Model model)
 {
	boolean status=productService.saveProduct(product);
	if(status)
	{
		model.addAttribute("smsg","product saved Successfully");
		}
	else
	{
		model.addAttribute("emsg","product failed");
	}
	model.addAttribute("pobj",new Product());
	return "index";
	 }
  
  @GetMapping("/products")
  public String viewProducts(Model model)
  {
	  List<Product> productsList=productService.getAllProducts();
	  model.addAttribute("plist",productsList);
	  return "data";
  }
}
