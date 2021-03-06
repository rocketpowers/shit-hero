package com.rocketpowers.heroesapi.document;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Heroes_Table_Demo")



public class Heroes {
 @Id
 @DynamoDBHashKey(attributeName = "id")
 private String id;

 @DynamoDBAttribute(attributeName = "name")
    private String name;

 @DynamoDBAttribute(attributeName = "universe")
 private String universe;

 @DynamoDBAttribute(attributeName = "films")
    private String films;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getFilm() {
        return films;
    }

    public void setFilm(String film) {
        this.films = film;
    }


public  Heroes(String id, String name, String universe, String films){
        this.id=id;
        this.name=name;
        this.universe=universe;
        this.films=films;


}






}
