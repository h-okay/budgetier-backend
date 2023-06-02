package com.hokay.budgetier.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "spending")
public class Spending {

    @Id
    private String id;
    private String date;
    private String category;
    private String sub_category;
    private String description;
    private String where;
    private String currency;
    private double amount;

}
