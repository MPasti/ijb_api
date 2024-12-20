package br.com.unifacef.ijb.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class DonatedMaterialDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private DonationDTO donation;
    private String materialName;
    private Integer materialQuantity;

    public DonatedMaterialDTO(Integer id, String materialName, Integer materialQuantity) {
        this.id = id;
        this.materialName = materialName;
        this.materialQuantity = materialQuantity;
    }
}
