package com.java.apiservices.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterMenuDto extends BaseModelDto {
    private String menuId;
    private String menuName;
    private String menuDescription;
    private String urlImage;
}
