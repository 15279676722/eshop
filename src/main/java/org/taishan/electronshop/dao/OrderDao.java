package org.taishan.electronshop.dao;

import org.taishan.electronshop.domain.Customer;
import org.taishan.electronshop.domain.Order;
import org.taishan.electronshop.util.JdbcHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDao implements Dao<Order,Integer> {
    private OrderDao od;

    private static final String table = " t_orders ";


    @Override
    public Order load(Integer id) {
        String SQL = "SELECT id , name , address , telephone , create_time , total , customer_id FROM" + table  + "WHERE id = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , id ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Order o =   this.cast( map );
            return o ;
        }
        return null;
    }

    public Object load(String name) {
        String SQL = "SELECT id , name , address , telephone , create_time , total , customer_id FROM" + table  + "WHERE name = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , name ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Order o =   this.cast( map );
            return o ;
        }
        return null;
    }

    @Override
    public List list() {
        String SQL = "SELECT id , name , address , telephone , create_time , total , customer_id FROM" + table   ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL ) ;
        helper.destory();
        if( list != null && list.size() > 0  ) {
            List<Order> orders = new ArrayList<>();

            for( int i = 0 ; i < list.size() ; i++ ) {
                Map<String, Object> map = list.get(i);
                Order o =   this.cast( map );
                orders.add(o);
            }

            return orders ;
        }
        return null;
    }

    @Override
    public boolean save(Order o) {
        return false;
    }

    @Override
    public boolean update(Order o) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Order cast(Map<String,Object> map) {
        Order o = new Order();
        o.setId( (String) map.get( "id" ) );
        o.setName( (String)map.get( "name" ) );
        o.setAddress( (String) map.get( "address" ) );
        o.setTelephone( (String) map.get( "telephone" ) );
        o.setCreateTime( (Date) map.get( "create_time" ) );
        o.setTotal( (Double) map.get( "Total" ) );
        Customer c = new Customer();
        c.setId( (Integer) map.get( "customer_id" ) );
        o.setCustomer(c);
        return o;
    }
}
