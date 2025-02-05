import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for crust choice
        System.out.println("Select your crust:");
        System.out.println("1 - Thin Crust");
        System.out.println("2 - Thick Crust");
        System.out.print("Your choice: ");
        int crustChoice = scanner.nextInt();

        PizzaCrust crust;
        switch (crustChoice) {
            case 1:
                crust = new ThinCrust();
                break;
            case 2:
                crust = new ThickCrust();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Thin Crust.");
                crust = new ThinCrust();
        }

        // Ask user for sauce choice
        System.out.println("\nSelect your sauce:");
        System.out.println("1 - Tomato Sauce");
        System.out.println("2 - Alfredo Sauce");
        System.out.print("Your choice: ");
        int sauceChoice = scanner.nextInt();

        PizzaSauce sauce = switch (sauceChoice) {
            case 1 -> new TomatoSauce();
            case 2 -> new AlfredoSauce();
            default -> {
                System.out.println("Invalid choice. Defaulting to Tomato Sauce.");
                yield new TomatoSauce();
            }
        };

        // Ask user for toppings
        System.out.println("\nHow many toppings (up to 4)? ");
        int numToppings = scanner.nextInt();
        if (numToppings > 4) {
            System.out.println("Maximum of 4 toppings allowed. Setting to 4.");
            numToppings = 4;
        } else if (numToppings < 0) {
            numToppings = 0;
        }

        System.out.println("\nToppings list (pick by number):");
        System.out.println("1 - Sausage");
        System.out.println("2 - Pepperoni");
        System.out.println("3 - Bacon");
        System.out.println("4 - Ham");
        System.out.println("5 - Mushrooms");
        System.out.println("6 - Onions");
        System.out.println("7 - Olives");
        System.out.println("8 - Bell Peppers");
        System.out.println("9 - Mozzarella");
        System.out.println("10 - Parmesan");
        System.out.println("11 - Cheddar");
        System.out.println("12 - Gouda");

        List<PizzaTopping> chosenToppings = new ArrayList<>();

        for (int i = 0; i < numToppings; i++) {
            System.out.print("Select topping #" + (i + 1) + ": ");
            int toppingChoice = scanner.nextInt();
            PizzaTopping topping = createToppingFromChoice(toppingChoice);
            chosenToppings.add(topping);
        }

        // Construct the Pizza object
        Pizza pizza = new Pizza(crust, sauce, chosenToppings);

        // Print out the pizza details
        System.out.println("\n" + pizza.toString());

        scanner.close();
    }

    /**
     * A helper method to map a user's numeric choice to an actual Topping object.
     */
    private static PizzaTopping createToppingFromChoice(int choice) {
        return switch (choice) {
            case 1 -> new Sausage();
            case 2 -> new Pepperoni();
            case 3 -> new Bacon();
            case 4 -> new Ham();
            case 5 -> new Mushrooms();
            case 6 -> new Onions();
            case 7 -> new Olives();
            case 8 -> new BellPeppers();
            case 9 -> new Mozzarella();
            case 10 -> new Parmesan();
            case 11 -> new Cheddar();
            case 12 -> new Gouda();
            default -> {
                System.out.println("Invalid topping choice. Defaulting to Sausage.");
                yield new Sausage();
            }
        };
    }
}
