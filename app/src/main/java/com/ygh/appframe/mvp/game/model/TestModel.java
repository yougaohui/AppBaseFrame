package com.ygh.appframe.mvp.game.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
@Entity
public class TestModel {
    @Id
    private long id;
    private int age;
    private int hight;
    @Generated(hash = 1274417115)
    public TestModel(long id, int age, int hight) {
        this.id = id;
        this.age = age;
        this.hight = hight;
    }
    @Generated(hash = 1568142977)
    public TestModel() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getHight() {
        return this.hight;
    }
    public void setHight(int hight) {
        this.hight = hight;
    }
}
