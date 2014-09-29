package com.fmt.rest.service;

class Schema {
    final String name;
    final String value;
 
    Schema(String name, String value) {
        this.name = name;
        this.value = value;
    }
 
    @Override
    public String toString() {
        return "Schema{" +
               "Name='" + name + '\'' +
               ", Value=" + value +
               '}';
    }
}