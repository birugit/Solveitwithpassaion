package com.ood.stockexchange.account;

/**
 * @author swamy on 2/4/21
 *//*
public class Member extends Account {

    private double availableFundForTrading;
    private Date dateOfmemberShip;
    private HashMap<String, StockPosistions> stockPositions;
    private HashMap<Integer, Order> activeOrders;

    public ErrorCode placeSellOrder(String stockId, float quantity, int limitPrice, TimeEnforcementType timeEnforcementType) {
//check if member have stackposition
        if (!stockPositions.containsKey(stockId)) {
            retrun NO_STOCK_POSITIONS;
        }
    }

    StockPosition stockPosition = stockPositions.get(stokId);
    //check if member have enough quantity to sell
    if(stockPosition.getQuantity() <quantity)

    {
        retrun INSUFFIECIENT_QUANTITYL
    }

    LimitOrders order = new LimitOrders(stockId, quantity, limitPrice, enforcementType);
    order.isBuyOrder  =false;
        order.saveInDb();
    boolean success = StockExchange::placeOrder(order);
        if(!success)

    {
        order.setStatus(OrderStatus::FAILEd);
        order.saveInDV();
    }else

    {
        activeOrders.add(orderId, order);

    }

    returun success;
}


    @Override
    public boolean resetPassword() {
        return false;
    }
}*/
