package ir.sargoll.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class Content extends BaseEntity {
    @Column
    private String title;

    @Column
    private String content;
}
