package org.hero.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
    private int pageNum;
    private int amount;

    private String type;
    private String keyword;

    public Criteria(){
        this(1,10);
    }

    public Criteria(int pageNum,int amount){
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public void setPageNum(int pageNum){
        if(pageNum<=0) {
            this.pageNum = 1;
            return;
        }
        this.pageNum = pageNum;
    }

    public void setAmount(int amount){
        if(amount<=0 || amount>100){
            this.amount =10;
            return;
        }
        this.amount = amount;
    }

    public int getPageStart(){
        return (this.pageNum-1)*this.amount;
    }

    public String[] getTypeArr(){
        return type == null? new String[] {} : type.split("");
    }

}
