package br.com.studiotrek.resilience.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "user")
public class UserOrm implements Serializable {
    @Id
    private final String id;
    private final String name;

    public UserOrm(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
