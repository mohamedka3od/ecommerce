package gov.iti.jets.ecommerce.presentation.controllers;

import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.CustomerService;
import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    final private CustomerService customerService;

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseDTO getProfile(@PathVariable Integer id){
    return new ResponseDTO(
            "Get Customer Successfully",
            true,
            200,
            customerService.find(id)
    ) ;
    }


    @RolesAllowed("ADMIN")
    @ResponseBody
    @GetMapping("/all")
    public ResponseDTO getAllCustomers(){
        return new ResponseDTO(
                "Get All Customer Successfully",
                true,
                200,
                customerService.getAll()
        ) ;
    }


   @PostMapping
   public ResponseDTO addCustomer(@RequestBody CustomerDTO customerDTO){
       return new ResponseDTO(
               "Add Customer Successfully",
               true,
               200,
               customerService.add(customerDTO)
       ) ;

   }
    @DeleteMapping
    public void delete(@RequestBody CustomerDTO customerDTO){
        customerService.delete(customerDTO);
    }
    @PutMapping
    public ResponseDTO update(@RequestBody CustomerDTO customerDTO){
        return new ResponseDTO(
                "Add Customer Successfully",
                true,
                200,
                customerService.update(customerDTO)
        ) ;
    }
}
