package create_api.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Age")
    private int age;

    @Column(name = "City")
    private String city;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    public String getCity(){
        return city;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCity(String city){
        this.city = city;
    }


}
