package User.model;

import Player.model.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock extends BaseBean {
    private String userId;
    private String playerStockId;
    private long quantity;
    private int price;
}
