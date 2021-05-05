public class Calculator {
    public static double calculate(double fisrtNum, double secondNum, char operator){
        switch (operator){
            case '+':
                return fisrtNum + secondNum;
            case '-':
                return fisrtNum - secondNum;
            case '*':
                return fisrtNum * secondNum;
            case '/':
                if(secondNum != 0){
                    return fisrtNum / secondNum;
                }
                else {
                    return 0;
                }
            default:
                return 0;
        }
    }
}
