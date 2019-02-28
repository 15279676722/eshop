package org.taishan.electronshop.dao;

import org.taishan.electronshop.domain.Goods;
import org.taishan.electronshop.domain.Order;
import org.taishan.electronshop.domain.OrderItem;
import org.taishan.electronshop.domain.TrolleyItem;
import org.taishan.electronshop.util.JdbcHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderItemDao implements Dao{
    private OrderItemDao oid;

    private static final String table = " t_order_items " ;
    @Override
    public Object load(Object id) {
        return null;
    }

    public OrderItem load(String name) {
        String SQL = "SELECT   goods_id,price, goods_number,order_id FROM" + table  + "WHERE name = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , name ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            OrderItem oi =   this.cast( map );
            return oi ;
        }
        return null;
    }


    @Override
    public List<OrderItem> list() {
        String SQL = "SELECT   goods_id,price, goods_number,order_id FROM" + table   ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL  ) ;
        helper.destory();
        if( list != null && list.size() >0) {
            List<OrderItem> orderItems= new ArrayList<>();
            for( int i = 0 ; i < list.size() ; i++ ) {
                Map<String, Object> map = list.get(i);
                OrderItem oi =   this.cast( map );
                orderItems.add(oi);
            }
            return orderItems;
        }
        return null;
    }

    @Override
    public boolean save(Object o) {
        return false;
    }

    public boolean save(OrderItem oi) {
        String SQL = "INSERT INTO " + table +
                " ( goods_id , price , goods_number,order_id   ) " +
                " VALUES (  ? , ? , ? , ?  )" ;
        Goods g = oi.getGoods();
        Integer goodsId = oi.getId();
        double price = g.getPrice();
        int goodsNumber = oi.getNumber();
        Order o = oi.getOrder();
        String orderId = o.getId();
        /*
        判断数据库中是否有和这个商品,没有则新增一条数据，有则修改那天数据令其number加1
         */

        Object[] array = {goodsId,price,goodsNumber,orderId};
        JdbcHelper helper = new JdbcHelper();
        // 执行插入语句，并获得由数据库产生的主键值
        int id = helper.insert( SQL , array );

        oi.setId( id );
        helper.destory();
        // 如果 id 不等于 -1  则视为保存成功( 在 JdbcHelper 的 insert 方法中有约定 )
        return id != -1 ;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public OrderItem cast(Map map) {
        OrderItem oi = new OrderItem();
        Goods g =new Goods();
        Order o = new Order();
        g.setId((Integer) map.get("goods_id"));
        oi.setPrice((double) map.get("price"));
        oi.setGoods(g);
        o.setId((String) map.get( "order_id" ));
        oi.setOrder(o);
        oi.setNumber((Integer) map.get("goods_number"));
        return oi;
    }
}
