package com.java.apiservices.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterSubMenuDto extends BaseModelDto {
    private String subMenuId;
    private String menuId;
    private String subMenuName;
    private String subMenuDescription;
    private String urlImage;
}
