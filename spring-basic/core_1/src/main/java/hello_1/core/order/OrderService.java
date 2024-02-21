package hello_1.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
//주문 서비스 인터페이스