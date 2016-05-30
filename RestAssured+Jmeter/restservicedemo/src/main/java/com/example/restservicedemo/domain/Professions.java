package com.example.restservicedemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Professions {
    WARRIOR("WARRIOR"), MAGE("MAGE"), ROGUE("ROGUE"), CLERIC("CLERIC"), ERROR("ERROR");
    private final String name;

    Professions(String s) {
        name = s;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public String toString(){
        return this.name;
    }
    //Moze sie przydac to testow taka metoda w sumie
    public boolean equalsName(String name2){
        return name2 != null && name.equals(name2);
    }


}
