package com.example.hante.thirdopen.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 *  用户登录信息
 */
@Entity
public class User {

    @Id(autoincrement = true) // 主键， long型， 设置自增长
    private Long id;   //  注意 大写 Long
    @NotNull   // 当前列不能为空
    private String userName;
    private String passWord;
    private String email;
    @Generated(hash = 1448469400)
    public User(Long id, @NotNull String userName, String passWord, String email) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
