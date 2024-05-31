package Problem1;

public class MainProblem1 {
    public static void main(String[] args) {
        Address address1 = new Address("1234 Main St", "Chicago", "IL", "60601");
        Address address2 = new Address("456 Elm St", "New York", "NY", "10001");
        Address address3 = new Address("789 Oak St", "Los Angeles", "CA", "90001");
        Address address4 = new Address("999 Pine St", "Chicago", "IL", "60602");
        Address address5 = new Address("490 Apple St", "Fairfield", "IA", "52556");

        Customer customer1 = new Customer("Wycliff", "Kasirye", "332-221-4444");
        customer1.setBillingAddress(address1);
        customer1.setShippingAddress(address2);

        Customer customer2 = new Customer("Abdul", "Moiz", "223-113-5555");
        customer2.setBillingAddress(address3);
        customer2.setShippingAddress(address4);

        Customer customer3 = new Customer("Hiago", "Dias", "445-667-8899");
        customer3.setBillingAddress(address4);
        customer3.setShippingAddress(address5);

        Customer[] customers = {customer1, customer2, customer3};

        for (Customer customer : customers) {
            if (customer.getBillingAddress().getCity().equalsIgnoreCase("Chicago")) {
                System.out.println(customer);
            }
        }
    }
}