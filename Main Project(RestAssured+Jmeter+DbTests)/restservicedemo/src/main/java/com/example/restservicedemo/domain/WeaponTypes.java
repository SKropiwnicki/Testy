package com.example.restservicedemo.domain;

public enum WeaponTypes {
    SWORD("SWORD"),AXE("AXE"),WAND("WAND"),STAFF("STAFF"),BOW("BOW"),CROSSBOW("CROSSBOW"), ERROR("ERROR");

    private final String name;

    WeaponTypes(String s) {
        name = s;
    }

    public String toString(){
        return this.name;
    }
    public boolean equalsName(String name2){
        return name2 != null && name.equals(name2);
    }
}
