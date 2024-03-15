/**
 * AsteriodCollision
 */
public class AsteriodCollision {

    @SuppressWarnings("unused")
    public static int[] simulateCollisions(int[] astroids) {
        StackImplemention resultStack = new StackImplemention(11);

        System.out.print("Step-" + 1 + ": ");
        if(resultStack.isEmpty()) {
            System.out.println("[]");
        }

        for (int i = 0; i < astroids.length; i++) {
            
            int curr = astroids[i];
            
            if(resultStack.isEmpty()) {
                resultStack.push(curr);
            }
            else if((curr * resultStack.returnSingle(0) > 0)) {
                resultStack.push(curr);
            }

            else {
                if(Math.abs(curr) == Math.abs(resultStack.returnSingle(0))) {
                    resultStack.pop();
                }
                else if (Math.abs(curr) > Math.abs(resultStack.returnSingle(0))) {
                    resultStack.pop();
                    resultStack.push(curr);
                }
                else {
                    ;
                }
            }

            System.out.print("Step-" + (i+2) + ": ");
            if (i+2 == 12) {
                System.out.print("Final astroid = ");
            }
            int[] elements = resultStack.seeElements();
            if (elements.length == 0) {
                System.out.println("[]");
            }
            else {
                System.out.print("[");
                for (int j = 0; j < elements.length; j++) {
                    if (j < elements.length - 1) {
                        System.out.print(elements[j] + ", ");
                    }
                    else {
                        System.out.println(elements[j] + "] ");
                    }
                }
            }
        }
        return astroids;
    }

    public static void main(String[] args) {
        int[] input = {7, 16, -16, -7, 5, -5, -21, 2, 2, 34, -9};
        System.out.print("Input astroids = [");
        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1) {
                System.out.print(input[i] + "]");
            }
            else {
                System.out.print(input[i] + ", ");
            }   
        }
        System.out.println();
        simulateCollisions(input);

    }
}