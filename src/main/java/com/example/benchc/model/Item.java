package com.example.benchc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "item")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 64)
    @Column(unique = true, length = 64, nullable = false)
    private String sku;

    @NotBlank @Size(max = 128)
    @Column(length = 128, nullable = false)
    private String name;

    @NotNull @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotNull @Min(0)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"items"}) // ne sérialise pas la collection
    private Category category;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

