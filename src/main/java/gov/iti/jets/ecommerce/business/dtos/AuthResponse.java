package gov.iti.jets.ecommerce.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String message;
    private boolean status;

    private Object object;
//    private String token;
}
