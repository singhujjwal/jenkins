package com.ujjwal.testgdk;

public enum ColorEnum {
    WHITE('white', 'White is mix of all colors'),
    BLACK('black', 'Black is no colors'),
    RED('red', 'Red is the color of blood')
 
    final String id;
    final String desc;
    static final Map map 
 
    static {
        map = [:] as TreeMap
        values().each{ color -> 
            println "id: " + color.id + ", desc:" + color.desc
            map.put(color.id, color)
        }
 
    }
 
    private ColorEnum(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }
 
    static getColorEnum( id ) {
        map[id]
    }
}