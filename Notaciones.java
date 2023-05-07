import java.util.Stack;

public class Notaciones {
    public static double operar(String input){
        Pila<String> opnStack = new Pila<>();
        int len = input.length();
       

    

        for (int i = 0; i < len; i++) {
            if(input.charAt(i) != '+'){
                opnStack.push(String.valueOf(input.charAt(i)));
            }else{
                System.out.println(opnStack.size());
                int op1 = Integer.valueOf(opnStack.pop());
                int op2 = Integer.valueOf(opnStack.pop());
                opnStack.push(String.valueOf(op1 + op2));
            }
        }
        return Double.valueOf(opnStack.pop());
        
    }
    
}
