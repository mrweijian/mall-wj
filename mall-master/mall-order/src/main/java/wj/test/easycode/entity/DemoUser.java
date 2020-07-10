package wj.test.easycode.entity;

import java.io.Serializable;

/**
 * (DemoUser)实体类
 *
 * @author makejava
 * @since 2020-03-20 10:18:23
 */
public class DemoUser implements Serializable {
    private static final long serialVersionUID = -46120991795406354L;
    
    private String userid;
    
    private String username;
    
    private String idcard;
    
    private Integer sex;
    
    private String phone;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}