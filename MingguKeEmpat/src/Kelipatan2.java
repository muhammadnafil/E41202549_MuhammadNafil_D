import java.util.Scanner;
public class Kelipatan2 {
    Scanner input=new Scanner(System.in);
    public void counter()
    {
        int hitung=1;
        do
        {
            System.out.print("  "+hitung);
            hitung=(hitung*2);
        }
        while(hitung<=100);
    }
    public static void main(String[] args)
    {
        System.out.println("         Do__While         ");
        System.out.println("Bilangan kelipatan 2 (1-100)");
        System.out.println("============================");
        Kelipatan2 mulai=new Kelipatan2();
        mulai.counter();
        System.out.println();
    }
}
