package Domain;

public class Pizza {
    private int id;
    private int price;
    private String title;
    private String topping;

    public Pizza(int id, int price, String title, String topping) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.topping = topping;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getTopping() {
        return topping;
    }

    private int getLength() {
        String value = getId() + ". " + getTitle() + ": " + getTopping() + " " + getPrice() + ",-";
        return value.length();
    }

    private String getSpace() {
        int max = 92;
        int totalDots = max - getLength();
        String dots = "";
        for (int i = 0; i < totalDots; i++) {
            dots += ".";
        }
        return dots;
    }

    @Override
    public String toString() {
        return getId() + ". " + getTitle() + ": " + getTopping() + getSpace() + " " + getPrice() + ",-";
    }
}
