package com.dangxy.androidpractice.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author dangxueyi
 * @description
 * @date 2018/1/16
 */
@Entity
public class Student {

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "user")
    private String user;
    @Property(nameInDb = "age")
    private String age;

    @Generated(hash = 164507339)
    public Student(Long id, String user, String age) {
        this.id = id;
        this.user = user;
        this.age = age;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
