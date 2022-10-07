package hello.core_20220927.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
