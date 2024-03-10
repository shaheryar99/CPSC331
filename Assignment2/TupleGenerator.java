/**
* Assignment 2 Generate Tuple - Shaheryar Syed 
* CPSC 331 
* UCID: 30052162
* TA: Harnoor Khehra 
*/

public class TupleGenerator {
    private String shoeBrand;
    private int shoePrice;
    private int shoeDiscount;

    public TupleGenerator(String shoe, int price, int discount) {
        this.shoeBrand = shoe;
        this.shoeDiscount = discount;
        this.shoePrice = price;
    }

    public String getShoeBrand() {
        return shoeBrand;
    }
    public int getShoeDiscount() {
        return shoeDiscount;
    }
    public int getShoePrice() {
        return shoePrice;
    }
}
