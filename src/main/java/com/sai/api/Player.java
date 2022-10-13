package com.sai.api;



import javax.validation.constraints.NotNull;

public class Player {


    @NotNull(message = "cant be null")
    private int id;
    @NotNull(message = "cant be null")
    private String name;
    private String type;

    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
