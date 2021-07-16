package com.java.apiservices.dto;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class BaseModelDto {
    private Date createdDate;
    private Date modifiedDate;
    private short isDeleted;
}
