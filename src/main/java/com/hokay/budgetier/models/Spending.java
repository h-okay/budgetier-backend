package com.hokay.budgetier.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "spendings")
public class Spending {

    @Id
    private ObjectId id;
    private String date;
    private String category;
    private String sub_category;
    private String description;
    private String where;
    private String currency;
    private double amount;

    public Spending(
            String date,
            String category,
            String sub_category,
            String description,
            String where,
            String currency,
            double amount) {
        this.date = date;
        this.category = category;
        this.sub_category = sub_category;
        this.description = description;
        this.where = where;
        this.currency = currency;
        this.amount = amount;
    }
}
