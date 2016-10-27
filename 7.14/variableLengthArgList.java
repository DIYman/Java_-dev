public class VariableLengthArgumentList{
    public static void main(String[] args){

        System.out.printf("12 * 53 * 32 * 1 * 9 * 5 = %d\n",
                variableProduct(12, 53, 32, 1, 9, 5));

        System.out.printf("2 * 2 * 2 = %d\n",
                variableProduct(2, 2, 2));

        System.out.printf("3 * 3 = %d\n",
                variableProduct(3, 3));

        System.out.printf("1 * 0 = %d\n",
                variableProduct(1));
    }

    public static int variableProduct(int... args){
        for(int i=1; i<args.length; i++){
            args[0] *= args[i];
        }
        return args[0];
    }
}
