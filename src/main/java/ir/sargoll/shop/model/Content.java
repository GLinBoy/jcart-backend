package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter @Setter
public class Content extends BaseEntity {
    @Column
    private String title;

    @Column
    private String content;
}
