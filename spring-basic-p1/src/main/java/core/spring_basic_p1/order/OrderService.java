package core.spring_basic_p1.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

