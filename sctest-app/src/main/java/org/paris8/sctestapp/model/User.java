package org.paris8.sctestapp.model;

public class User {
    public Long id;
    public String name;
    public int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, age=%s]", id, name, age);
    }
}
