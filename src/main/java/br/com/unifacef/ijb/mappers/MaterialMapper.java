package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.MaterialDTO;
import br.com.unifacef.ijb.models.dtos.MaterialResponseDTO;
import br.com.unifacef.ijb.models.dtos.MaterialUpdateDTO;
import br.com.unifacef.ijb.models.entities.Material;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialMapper {

    public static MaterialDTO convertMaterialIntoMaterialDTO(Material material) {
        return new MaterialDTO(material.getId(), material.getName(), material.getQuantity(), material.getPrice(),
                material.getDescription(), material.getOrigin());
    }

    public static List<MaterialDTO> convertListOfMaterialIntoListOfMaterialDTO(
            List<Material> materials) {
        List<MaterialDTO> materialDTOs = new ArrayList<>();

        materials.forEach(material -> materialDTOs.add(convertMaterialIntoMaterialDTO(material)));

        return materialDTOs;
    }

    public static Material convertMaterialDTOIntoMaterial(MaterialDTO material) {
        return new Material(material.getName(), material.getQuantity(), material.getDescription(), material.getPrice(), material.getOrigin());
    }

    public static List<MaterialResponseDTO> convertListOfMaterialIntoListOfMaterialResponseDTO(
            List<Material> materials) {
        List<MaterialResponseDTO> materialResponseDTOS = new ArrayList<>();

        materials.forEach(material -> materialResponseDTOS.add(convertMaterialIntomaterialResponseDTO(material)));

        return materialResponseDTOS;
    }

    private static MaterialResponseDTO convertMaterialIntomaterialResponseDTO(Material material) {
        return new MaterialResponseDTO(material.getId(), material.getName(), material.getQuantity(),
                material.getPrice(), material.getDescription(), material.getOrigin().getValue());
    }
}
