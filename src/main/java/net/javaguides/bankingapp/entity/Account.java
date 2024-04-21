package net.javaguides.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.model.jdbc.DeleteOrUpsertOperation;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private long id;
    @Column(name="account_holder_name")
    private String accountholderName;
    private double balance;

}
