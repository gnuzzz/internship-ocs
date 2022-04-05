package ru.digitalleague.ocs.internship.lesson16;

public class CartsService {

    private CartsRepository cartsRepository;

    public CartsService(CartsRepository cartsRepository) {
        this.cartsRepository = cartsRepository;
    }

    public Cart16 getCart(User16 user) throws MarketException {
        try {
            Cart16 cart = cartsRepository.getCart(user);
            recalculate(cart);
            return cart;
        } catch (Exception e) {
            throw new MarketException("Can't get cart for user " + user.getEmail(), e);
        }
    }

    public Cart16 addBook(User16 user, Book16 book) throws MarketException {
        try {
            Cart16 cart = cartsRepository.getCart(user);
            CartItem16 item = cartsRepository.createCartItem(cart, book, 1);
            cart.getItems().add(item);
            recalculate(cart);
            return cart;
        } catch (Exception e) {
            throw new MarketException("Can't add book " + book.getId() + " to cart for user " + user.getEmail(), e);
        }
    }

    public Cart16 changeQuantity(User16 user, Book16 book, int quantity) throws MarketException {
        try {
            Cart16 cart = cartsRepository.getCart(user);
            CartItem16 item = cart.getItems().stream().filter(cartItem -> cartItem.getBook().equals(book)).findFirst().orElse(null);
            if (item == null) {
                item = cartsRepository.createCartItem(cart, book, quantity);
                cart.getItems().add(item);
            } else {
                item.setQuantity(quantity);
                cartsRepository.updateCartItem(item);
            }
            recalculate(cart);
            return cart;
        } catch (Exception e) {
            throw new MarketException("Can't change book " + book.getId() + " quantity for user " + user.getEmail(), e);
        }
    }

    public Cart16 removeBook(User16 user, Book16 book) throws MarketException {
        Cart16 cart = cartsRepository.getCart(user);
        CartItem16 item = cart.getItems().stream().filter(cartItem -> cartItem.getBook().equals(book)).findFirst().orElse(null);
        if (item != null) {
            cartsRepository.removeCartItem(item);
            cart.getItems().remove(item);
        }
        recalculate(cart);
        return cart;
    }

    private void recalculate(Cart16 cart) {
        long sum = 0;
        long vatSum = 0;
        for (CartItem16 item: cart.getItems()) {
            sum += item.getBook().getPrice();
            vatSum += item.getBook().getPrice() * item.getBook().getVat() / 100;
        }
        cart.setSum(sum);
        cart.setVatSum(vatSum);
    }

}
