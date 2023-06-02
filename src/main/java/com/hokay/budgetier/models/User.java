package com.hokay.budgetier.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;
    private String first_name;
    private String last_name;
    @Indexed(unique = true)
    private String username;
    @Indexed(unique = true)
    private String email;
    private String birthdate;

    @DocumentReference(lazy = true)
    private List<Spending> spendingIds;

}
