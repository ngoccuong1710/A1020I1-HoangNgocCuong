package _08_Clean_code_refactoring.thuc_hanh.refactoring_doi_ten_bien_va_tach_hang;

public class CalculatorTest {
    public static void main(String[] args) {
        int firstOperand = 6;
        int secondOperand = 3;
        char operatorAdd = '+';
        char operatorSub = '-';
        char operatorMult = '*';
        char operatorDiv = '/';

        int resultAdd = Calculator.calculate(firstOperand, secondOperand, operatorAdd);
        System.out.println(resultAdd);
        int resultSub = Calculator.calculate(firstOperand, secondOperand, operatorSub);
        System.out.println(resultSub);
        int resultMult = Calculator.calculate(firstOperand, secondOperand, operatorMult);
        System.out.println(resultMult);
        int resultDiv = Calculator.calculate(firstOperand, secondOperand, operatorDiv);
        System.out.println(resultDiv);
    }
}
