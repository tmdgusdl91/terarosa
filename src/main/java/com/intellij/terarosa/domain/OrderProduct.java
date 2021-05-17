package com.intellij.terarosa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="productId")
    private Long productId;

    @Column
    private int count;

    @OneToOne
    @JoinColumn(name="username", referencedColumnName = "username", insertable=false, updatable=false)
    private User user;

    @OneToOne
    @JoinColumn(name="productId", referencedColumnName = "id",insertable=false, updatable=false)
    private Product product;

    @Column(columnDefinition = "BIGINT", nullable = false)
    private BigInteger price;

    @Builder
    public OrderProduct(Long id, String username, Long productId, int count, BigInteger price) {
        this.id = id;
        this.username =  username;
        this.productId = productId;
        this.count = count;
        this.price = price;
    }

}
