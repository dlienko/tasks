import java.math.BigDecimal;
import java.util.Optional;

class CombiningOptionals {

    static class Order {
        int productId;
    }

    static class Product {
        BigDecimal price;
    }

    interface OrdersRepository {
        Optional<Order> getOrderById(int id);
    }

    interface ProductsRepository {
        Optional<Product> getProductById(int id);
    }

    static class GetOrderPriceQuery {

        private final OrdersRepository ordersRepository;
        private final ProductsRepository productsRepository;

        public GetOrderPriceQuery(OrdersRepository ordersRepository, ProductsRepository productsRepository) {
            this.ordersRepository = ordersRepository;
            this.productsRepository = productsRepository;
        }

        public Optional<BigDecimal> getOrderPrice(int orderId) {
            return ordersRepository.getOrderById(orderId)
                .map(order -> productsRepository.getProductById(order.productId))
                .map((Optional<Product> product) -> product.map(p -> p.price).orElse(null));
        }
    }

}
