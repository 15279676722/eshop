package org.taishan.electronshop.dao;

import org.taishan.electronshop.domain.Category;
import org.taishan.electronshop.domain.Customer;
import org.taishan.electronshop.domain.Goods;
import org.taishan.electronshop.util.JdbcHelper;

import java.util.List;
import java.util.Map;

public class GoodsDao implements Dao<Goods,Integer> {
    private GoodsDao gd;
    CustomerDao cd = new CustomerDao();
    CategoryDao ctd = new CategoryDao();
    private String table = " t_goods ";
    @Override
    public Goods load(Integer id) {
        String SQL = "SELECT id ,name, price , image , category_id  FROM" + table  + " WHERE id = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , id ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Goods g =   this.cast( map );
            return g ;
        }
        return null;
    }

    public Goods load(String name) {
        String SQL = "SELECT id ,name, price , image , category_id  FROM" + table  + " WHERE name = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , name ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Goods g =   this.cast( map );
            return g ;
        }
        return null;
    }

    @Override
    public List<Goods> list() {
        return null;
    }

    @Override
    public Goods cast(Map<String, Object> map) {
        Goods  g= new Goods();
        g.setId( (Integer)map.get( "id" ) );
        g.setName( (String)map.get( "name" ) );
        g.setPrice( (Double) map.get( "price" ) );
        g.setImage( (String) map.get( "image" ) );
        Category ct = ctd.load((Integer) map.get( "category_id" ));
        g.setCategory(ct);
        return g;
    }

    @Override
    public boolean save(Goods goods) {
        return false;
    }

    @Override
    public boolean update(Goods goods) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
