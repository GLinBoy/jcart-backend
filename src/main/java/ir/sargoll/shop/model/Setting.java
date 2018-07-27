package ir.sargoll.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Locale;

@Entity
@Table
@Getter @Setter
public class Setting extends BaseEntity {
}
