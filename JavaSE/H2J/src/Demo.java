public class Demo{
    public static void main(String[] args) {


        for (int i = 0; i < 6; i++) {
            for (int i1 = 6-i; i1 > 0; i1--) {
                System.out.print(" ");
            }
            for (int i2 = 6-i; i2 < 6; i2++) {
                System.out.print("*");
            }
            for (int i3 = 5-i; i3 < 6; i3++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }

    }
}