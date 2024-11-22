package br.com.unifacef.ijb.models.enums;

import lombok.Getter;

@Getter
public enum OutletProductStatus {
    ACTIVE("ativo"),
    INACTIVE("inativo"),
    SOLD("vendido");

    private final String status;

    OutletProductStatus(String status) {
        this.status = status;
    }
}
