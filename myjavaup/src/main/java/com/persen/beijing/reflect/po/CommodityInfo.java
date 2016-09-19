package com.persen.beijing.reflect.po;

public class CommodityInfo {
    private String commodity_id;
    private String commodity_name;
    private String commodity_num;
    private long price;
    private long discount;

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_num() {
        return commodity_num;
    }

    public void setCommodity_num(String commodity_num) {
        this.commodity_num = commodity_num;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "CommodityInfo [commodity_id=" + commodity_id
                + ", commodity_name=" + commodity_name + ", commodity_num="
                + commodity_num + ", price=" + price + ", discount=" + discount
                + "]";
    }
}
