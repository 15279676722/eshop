package model;

public class Person {
    private Integer id;
    private String username;
    private int age;
    private int ss;
    public String getUsername() {
        return username;
    }
   
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
      return "|ID|:"+this.id+"|USERNAME|:"+this.username+"|AGE|"+this.age;


    };
}
