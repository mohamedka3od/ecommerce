package gov.iti.jets.ecommerce.presentation.controllers;

import jakarta.annotation.security.RolesAllowed;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gov.iti.jets.ecommerce.business.dtos.ProductCategoriesDTO;
import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // Get All Products
    @GetMapping
    public ResponseDTO getAllProducts() {

        return new ResponseDTO("All products", true, 200, productService.getAllProducts());

    }

    // Get Product By ID
    @GetMapping("/{id}")
    public ResponseDTO getProduct(@PathVariable Integer id) {

        return new ResponseDTO("product", true, 200, productService.getProduct(id));
    }

    // Add Products
    @RolesAllowed("ADMIN")
    @PostMapping
    public ResponseDTO addProduct(@RequestBody ProductCategoriesDTO productDTO) {

        this.productService.addProduct(productDTO);
        return new ResponseDTO("Update Product Successfully", true, 200);
    }

    // update product
    @RolesAllowed("ADMIN")
    @PutMapping
    public ResponseDTO updateProduct(@RequestBody ProductCategoriesDTO productDTO) {

        this.productService.updateProduct(productDTO);
        return new ResponseDTO("Update Product Successfully", true, null);
    }

    // delete product by id
    @RolesAllowed("ADMIN")
    @DeleteMapping("/{id}")
    public ResponseDTO deleteProduct(@PathVariable Integer id) {
        this.productService.deleteProduct(id);
        return new ResponseDTO("Delete Product Successfully", true, null);
    }

    @PostMapping("/upload")
    public void uploadImage (@RequestParam("file") MultipartFile file ) throws Exception {
     
       String path_directory="D:\\Final Front\\-Frontend-ecommerce\\src\\assets\\images";

       Files.copy(file.getInputStream(),Paths.get(path_directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
          
    }


}