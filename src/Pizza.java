import java.util.List;

public class Pizza {

    private PizzaCrust crust;
    private PizzaSauce sauce;
    private List<PizzaTopping> toppings;  // up to 4 toppings

    public Pizza(PizzaCrust crust, PizzaSauce sauce, List<PizzaTopping> toppings) {
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    public PizzaCrust getCrust() {
        return crust;
    }

    public PizzaSauce getSauce() {
        return sauce;
    }

    public List<PizzaTopping> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza Details:\n");
        sb.append("Crust: ").append(crust.toString()).append("\n");
        sb.append("Sauce: ").append(sauce.toString()).append("\n");
        sb.append("Toppings:\n");
        for (PizzaTopping t : toppings) {
            sb.append("  - ").append(t.toString()).append("\n");
        }
        return sb.toString();
    }
}
