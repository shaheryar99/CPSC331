/**
* Assignment 2 Exercise 4 - Shaheryar Syed 
* CPSC 331 
* UCID: 30052162
* TA: Harnoor Khehra 
*/

public class Assignment2_Exercise4<T> {

    private static TupleGenerator[] dictionary;
    private int topPointer;

    public Assignment2_Exercise4() {
        dictionary = new TupleGenerator[6];
        topPointer = -1;
    }

    public void push (TupleGenerator tuple) {
        if(topPointer == dictionary.length -1) {
            System.out.println("The stack is so full, it wants to get into the storage unit business");
        }
        else {
            topPointer++;
            dictionary[topPointer] = tuple;
        }
    }

    public String peek() {
        if (topPointer == -1) {
           return("Rain Drop, Drop Top, my program did a flop, Stack Empty, guess we gotta shop non-stop.");
        }
        else {
            return("[(" + "\'" + dictionary[topPointer].getShoeBrand() + "\'" + ", " + dictionary[topPointer].getShoePrice() + ", " + dictionary[topPointer].getShoeDiscount() + ")]");
        }
    }

    public TupleGenerator pop() {
        if (topPointer == -1) {
            return null;
        }

        else {
            TupleGenerator poppedElement;
            poppedElement = dictionary[topPointer];
            dictionary[topPointer] = null;
            topPointer--;
            return poppedElement;
        }
    }

    public String shoppingCartBrand() {
        String brand = dictionary[topPointer].getShoeBrand();
        return brand;
    }

    public static void main(String[] args) {

        Assignment2_Exercise4 shoppingCart = new Assignment2_Exercise4<>();

        /* Why is a single pair worth more than my most expensive outfit?? */
        dictionary[0] = new TupleGenerator("Nike", 450, 15);
        dictionary[1] = new TupleGenerator("Adidas",400,10);
        dictionary[2] = new TupleGenerator("Puma", 600, 30);
        dictionary[3] = new TupleGenerator("Sorel", 360, 0);
        dictionary[4] = new TupleGenerator("Aldo", 680, 15);
        dictionary[5] = new TupleGenerator("Skechers", 390, 0);

        shoppingCart.push(dictionary[0]);

        System.out.print("Shoes info: ");
        for(int i = 0; i < dictionary.length; i++) {
            if (i==5) {
                System.out.print("(" + "\'" + dictionary[i].getShoeBrand() + "\'" + ", " + dictionary[i].getShoePrice() + ", " + dictionary[i].getShoeDiscount() + ")");
            }
            else {
                System.out.print("(" + "\'" + dictionary[i].getShoeBrand() + "\'" + ", " + dictionary[i].getShoePrice() + ", " + dictionary[i].getShoeDiscount() + ")" + ", ");
            }
        }

        System.out.println();
        /* checks over stripes BABYYYY */
        TupleGenerator nike = dictionary[0];

        /* petition to not have to do this math */
        double prevShoeDiscountedPrice = dictionary[0].getShoePrice() * (1-((double)dictionary[0].getShoeDiscount()/(100)));
        System.out.println("1st Step: " + shoppingCart.peek());


        for (int i = 1; i < dictionary.length; i++) {

            TupleGenerator currentitem = dictionary[i];
            double nextShoeDiscountedPrice = currentitem.getShoePrice() *  (1-((double)currentitem.getShoeDiscount()/(100))); 

            /* Because some genius in 1883 decided ordinal numbers should be a thing... its on sight. */
            if (i == 1) {
                System.out.print("2nd Step: ");
            }

            else if (i == 2) {
                System.out.print("3rd Step: " );
            }
            else {
                System.out.print((i+1) + "th" + " Step: ");
            }

            /* Cheapest pair still worth more than my outfits */
            if (nextShoeDiscountedPrice < prevShoeDiscountedPrice) {
                TupleGenerator cart = shoppingCart.pop();

                shoppingCart.push(currentitem);
                System.out.println(shoppingCart.peek() + " as " + currentitem.getShoePrice() + " X " + currentitem.getShoeDiscount() + " percent = " + (int)nextShoeDiscountedPrice + " is less than " + (int)prevShoeDiscountedPrice);
                prevShoeDiscountedPrice = nextShoeDiscountedPrice;

            }

            /* Obviously I'm a bargin hunter. No discount = no purchase */
            else if(nextShoeDiscountedPrice == prevShoeDiscountedPrice) {
                double priceEquals = currentitem.getShoePrice() *  (1-((double)currentitem.getShoeDiscount()/(100))); 
                String brand = shoppingCart.shoppingCartBrand();

                if (currentitem.getShoeDiscount() == 0) {;}
                else {
                    shoppingCart.pop();
                    shoppingCart.push(currentitem);
                }

                System.out.println(shoppingCart.peek() + " as " + currentitem.getShoePrice() + " X " + currentitem.getShoeDiscount() + " percent = " + (int)nextShoeDiscountedPrice + " = " + (int)priceEquals + " and " + "\'" + brand + "\'" + " has a discount");
            }
            else {
                System.out.println(shoppingCart.peek() + " as " + currentitem.getShoePrice() + " X " + currentitem.getShoeDiscount() + " percent = " + (int) nextShoeDiscountedPrice + " is greater than " + (int)prevShoeDiscountedPrice );
            }

        }
    }
    
}