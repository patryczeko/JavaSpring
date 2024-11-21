package org.example.ketchup.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter @Setter
@Document(collection = "Customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String surname;
    private double age;
    private Boolean isAvailable = true;
}