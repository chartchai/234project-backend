package camt.se234.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String transactionId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    SaleOrder order;
    @OneToOne (fetch = FetchType.EAGER)
    Product product;
    int amount;

    public SaleTransaction(String transactionId, SaleOrder order, Product product, int amount) {
        this.transactionId = transactionId;
        this.order = order;
        this.product = product;
        this.amount = amount;
    }
}
