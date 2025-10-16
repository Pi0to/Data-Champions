package com.datachampions.Data.Champions.dto.staticsDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StaticDto {

    @Id
    private String id;
    private String name;
    private String title;
    private String icon;
}
