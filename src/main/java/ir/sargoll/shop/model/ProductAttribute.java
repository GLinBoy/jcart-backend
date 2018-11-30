package ir.sargoll.shop.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class ProductAttribute extends BaseEntity {
}
