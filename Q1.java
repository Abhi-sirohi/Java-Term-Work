import java.util.Scanner;

/***
 1.	WAP in java to simulate condition to generate Wi-Fi password. Take input as Name, City, Age and Gender.
 Constraints:
 a.	Length of name and city should be greater or equal to 3.
 b.	Age can`t be 18.
 Output Constraints:
 a.	If Gender=F and Age<18
 Password: 1st 3 char of name + sum of digit of age + last 3 char of city
 b.	Else If gender=F and Age>18
 Password: last 3 char of Name + Diff of digit of age(Positive) + 1st 3 char of City.
 c.	Else
 Password: 1st char of name + 1st char of city + 2nd char of name + 2nd char of city …
 Append this to length of max string(name or city) and then concatenate with Age to get password.
 ***/

public class Q1 {
    static String name, cityName,gender;
    static int age;
    public static void main(String args[]){

        Q1 ob = new Q1();
        ob.takeUserInput();
        ob.checkForConstraints();

    }

    private void checkForConstraints(){
        boolean check = true;
//        checks for Constraints
        if (name.length()<3){
            System.out.println("ERROR:Name length should be greater than 2");
            check = false;
        } else if (cityName.length() <3 ) {
            System.out.println("ERROR:City Name length should be greater than 2");
            check = false;

        } else if (age == 18) {
            System.out.println("Age should not be 18 years");
            check = false;

        }
        if (check)
            generateWifiPassword();
        else takeUserInput();
    }

    private void takeUserInput(){
//         Take input as Name, City, Age and Gender.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length of name should be greater or equal to 3.");
        System.out.println("Enter your Name: ");
        name = scanner.nextLine().trim();
        System.out.println("Length of City name should be greater or equal to 3.");
        System.out.println("Enter your City name: ");
        cityName = scanner.nextLine().trim();
        System.out.println("Enter your Age: ");
        age = scanner.nextInt();
        System.out.println("Enter your Gender F or M : ");
        gender = scanner.next();
        gender = gender.substring(0,1);
    }
    private void generateWifiPassword(){
        String password;
        if (gender.equals("F")){
            if (age<18){
                password = name.substring(0,3) +sumOfAge()+cityName.substring(cityName.length()-3,cityName.length());
            }else {
                password = name.substring(name.length()-3,name.length()) +diffOfAge()+cityName.substring(0,3);

            }
        }else {
            password = name.substring(0,1)+cityName.substring(0,1)+name.substring(1,2)+cityName.substring(1,2);
            if (name.length()>cityName.length())
                password = password+name;
            else password = password+cityName;
            password = password+age;

        }
        System.out.println("Generated WIFI Password is: "+password);

    }

    private int sumOfAge(){
        String sAge = String.valueOf(age);
        int sum=0 ;
        for (int i=0;i<sAge.length();i++){
            sum = sum+ Integer.parseInt(String.valueOf(sAge.charAt(i)));
        }

        return sum;
    }
    private int diffOfAge(){
        String sAge = String.valueOf(age);
        int diff=0 ;
        for (int i=0;i<sAge.length();i++){
            diff =  Integer.parseInt(String.valueOf(sAge.charAt(i))) - diff;
//            return the absolute value of int.
            diff = Math.abs(diff);
        }

        return diff;
    }

}

