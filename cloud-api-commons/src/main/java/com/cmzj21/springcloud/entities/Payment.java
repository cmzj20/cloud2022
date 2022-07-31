package com.cmzj21.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Payment实体类
public class Payment implements Serializable {
    private long id;
    private String serial;
    public Payment(String serial){
        this.serial = serial;
    }
}
