package com.quick.demo.service.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uid;
    private String uuid;
    private String cargoName;
    private Double account;
    private Date  createDate;
}
