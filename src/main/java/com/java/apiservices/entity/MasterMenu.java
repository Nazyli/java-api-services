package com.java.apiservices.entity;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "master_menu")
@Where(clause = "is_deleted = 0")
public class MasterMenu extends BaseModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Lob
    @Column(name = "menu_description")
    private String menuDescription;

    @Lob
    @Column(name = "url_image")
    private String urlImage;

}
