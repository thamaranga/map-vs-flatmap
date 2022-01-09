import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(
                new Customer(1, "Chathushka", "a@gmail.com", Arrays.asList("0711111111", "0712222222")),
                new Customer(2, "Kasun", "b@gmail.com", Arrays.asList("0713333333", "0714444444")),
                new Customer(3, "Pamitha", "c@gmail.com", Arrays.asList("0715555555", "0716666666")),
                new Customer(4, "Hasitha", "d@gmail.com", Arrays.asList("0717777777", "0718888888"))
        );

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping
        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        System.out.println(emails);


        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<List<String>> phoneNumbers = customers.
                stream().map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);
    }
}
