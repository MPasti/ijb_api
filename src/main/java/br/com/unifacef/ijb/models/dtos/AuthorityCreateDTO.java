package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityCreateDTO {
    private Role role;
}
