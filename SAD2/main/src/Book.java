public class Book {
    String title;
    int pages;
    double price;
    double discount;

    public Book(String title, int pages, double price, double discount) {
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.discount = discount;
    }

    public int getReadingTime() {
        return pages / 5;
    }

    public double applyDiscount() {
        return price - (price * discount);
    }
}
