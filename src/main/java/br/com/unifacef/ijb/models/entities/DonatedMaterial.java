package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_materiais_doados")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DonatedMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material_doado")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "nm_material", length = 60)
    private String materialName;
    @Column(name = "qnt_material")
    private String materialQuantity;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public DonatedMaterial(Donation donation, String materialName, String materialQuantity) {
        this.donation = donation;
        this.materialName = materialName;
        this.materialQuantity = materialQuantity;
    }
}
