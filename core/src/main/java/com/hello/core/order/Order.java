package com.hello.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int disCountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int disCountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.disCountPrice = disCountPrice;
    }

    /*로직추가*/
    public int calculaterPrice(){
        return itemPrice - disCountPrice; //할인되었을때의 원가 메소드
    }

    /*       */
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDisCountPrice() {
        return disCountPrice;
    }

    public void setDisCountPrice(int disCountPrice) {
        this.disCountPrice = disCountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", disCountPrice=" + disCountPrice +
                '}';
    }
}
