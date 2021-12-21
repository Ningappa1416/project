package learning;

public class DataTypes {
    public static void main(String[] args) {
        System.out.println(DataTypes.Name());
        System.out.println(DataTypes.WebDriverWait(10, 20 ));
    }

    public static String Name(){
       String Name ="Prashant";
        //System.out.println("My name is prashant--" +Name);
        return Name;

    }
    public static int WebDriverWait(int a, int b){
       int c= a+b;
       // System.out.println("Additions of a+b " +c);
        return c;
    }
}
