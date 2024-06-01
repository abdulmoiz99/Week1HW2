package Problem4;

enum PizzaSize {
    SMALL, MEDIUM, LARGE;
}
enum PizzaType {
    VEGGIE, PEPPERONI, CHEEZE, BBQ_CHICKEN;
}

class Pizza {
    private PizzaSize size;
    private PizzaType type;
    private int quantity;
    private double price;

    public Pizza(PizzaSize size, PizzaType type, int quantity) {
        this.size = size;
        this.type = type;
        this.quantity = quantity;
        calculatePrice();
    }

    private void calculatePrice() {
        double sizePrice = switch (size) {
            case SMALL -> 8.0;
            case MEDIUM -> 10.0;
            case LARGE -> 12.0;
        };

        double typePrice = switch (type) {
            case VEGGIE -> 1.0;
            case PEPPERONI -> 2.0;
            case CHEEZE -> 1.5;
            case BBQ_CHICKEN -> 2.0;
        };

        price = (sizePrice + typePrice) * quantity;
    }

    public String printOrderSummary() {
        double tax = price * 0.03;
        double totalPrice = price + tax;
        return String.format(
                "Pizza Order:\nSize: %s\nType: %s\nQty: %d\nPrice: $%.2f\nTax: $%.2f\nTotal Price: $%.2f",
                size, type, quantity, price, tax, totalPrice
        );
    }
}