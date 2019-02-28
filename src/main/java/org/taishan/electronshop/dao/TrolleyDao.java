package org.taishan.electronshop.dao;

import org.taishan.electronshop.domain.Customer;
import org.taishan.electronshop.domain.Goods;
import org.taishan.electronshop.domain.TrolleyItem;
import org.taishan.electronshop.util.JdbcHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrolleyDao implements Dao<TrolleyItem,Integer> {
    private TrolleyDao td;

    private static final String table = " t_trolleyitems ";

    @Override
    public TrolleyItem load(Integer id) {
        return null;
    }

    public TrolleyItem load(String name) {
        String SQL = "SELECT   goods_id,goods_name,goods_price,customers_id, goods_number FROM" + table + "WHERE name = ? ";
        JdbcHelper helper = new JdbcHelper();
        List<Map<String, Object>> list = helper.query(SQL, name);
        helper.destory();
        if (list != null && list.size() == 1) {
            Map<String, Object> map = list.get(0);
            TrolleyItem t = this.cast(map);
            return t;
        }
        return null;
    }


    @Override
    public List<TrolleyItem> list() {
        String SQL = "SELECT   goods_id,goods_name,goods_price,customers_id, goods_number FROM" + table;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String, Object>> list = helper.query(SQL);
        helper.destory();
        if (list != null && list.size() > 0) {
            List<TrolleyItem> trolleyItems = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                TrolleyItem t = this.cast(map);
                trolleyItems.add(t);
            }
            return trolleyItems;
        }
        return null;
    }

    @Override
    public boolean save(TrolleyItem t) {
        String SQL = "INSERT INTO " + table +
                " ( goods_id , goods_name , goods_price,goods_number , customer_id  ) " +
                " VALUES (  ? , ? , ? , ? ,? )";
        Goods g = t.getGoods();
        Integer goodsId = g.getId();
        String goodsName = g.getName();
        /*
        判断数据库中是否有和这个商品,没有则新增一条数据，有则修改那天数据令其number加1
         */
        int goodsNumber = 1;
        if (td.load(goodsName) == null) {
            goodsNumber = 1;
        } else {
            goodsNumber = td.load(goodsName).getNumber() + 1;
            t = td.load(goodsName);
            return td.update(t);
        }
        Object[] array = {goodsId, goodsName, goodsNumber, t.getId()};
        JdbcHelper helper = new JdbcHelper();
        // 执行插入语句，并获得由数据库产生的主键值
        int id = helper.insert(SQL, array);
        t.setId(id); // 将由数据库产生的主键值设置到 Customer 对象的 id 字段上
        helper.destory();
        // 如果 id 不等于 -1  则视为保存成功( 在 JdbcHelper 的 insert 方法中有约定 )
        return id != -1;

    }

    @Override
    public boolean update(TrolleyItem t) {
        String SQL = "UPDATE " + table +
                " SET goods_number = ? " +
                " WHERE id = ? ";
        int number = t.getNumber();
        int id = t.getId();
        if (number <= 0) {
            td.delete(id);
        }
        Object[] params = {number, id};

        JdbcHelper helper = new JdbcHelper();
        int count = helper.update(SQL, params);
        helper.destory();
        return count == 1;
    }

    @Override
    public boolean delete(Integer id) {
        String SQL = "DELETE FROM " + table + " WHERE id = ? ";
        JdbcHelper helper = new JdbcHelper();
        int count = helper.update(SQL, id);
        helper.destory();
        return count == 1;
    }

    @Override
    public TrolleyItem cast(Map map) {
        TrolleyItem t = new TrolleyItem();
        Goods g = new Goods();
        Customer c = new Customer();
        g.setId((Integer) map.get("goods_id"));
        g.setName((String) map.get("goods_name"));
        g.setPrice((Integer) map.get("goods_price"));
        t.setGoods(g);
        c.setId((Integer) map.get("customers_id"));
        t.setCustomer(c);
        t.setnumber((Integer) map.get("goods_number"));
        return t;
    }



}
