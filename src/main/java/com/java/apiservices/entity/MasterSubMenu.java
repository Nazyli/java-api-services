package com.java.apiservices.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "master_sub_menu")
@Where(clause = "is_deleted = 0")
public class MasterSubMenu extends BaseModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "sub_menu_id")
    private String subMenuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private MasterMenu masterMenu;

    @Column(name = "sub_menu_name")
    private String subMenuName;

    @Lob
    @Column(name = "sub_menu_description")
    private String subMenuDescription;

    @Lob
    @Column(name = "url_image")
    private String urlImage;

}
