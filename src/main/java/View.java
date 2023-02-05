import java.util.Scanner;


public class View {

    Scanner sc = new Scanner(System.in);

    public void print(String str) {
        System.out.println(str);
    }

    public String str() {
        return sc.nextLine();
    }
}
