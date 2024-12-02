package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_materiais")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material_doado")
    private DonatedMaterial donatedMaterial;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material_comprado")
    private PurchasedMaterial purchasedMaterial;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Material(DonatedMaterial donatedMaterial, PurchasedMaterial purchasedMaterial) {
        this.donatedMaterial = donatedMaterial;
        this.purchasedMaterial = purchasedMaterial;
    }
}
