package ir.sargoll.shop.model;

public class Discount  extends BaseEntity {
    private User user;
    private Product product;
    private Double percent;
    private Double ceiling;
    private Boolean isUsed;
}
