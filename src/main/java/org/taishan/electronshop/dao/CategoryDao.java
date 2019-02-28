package org.taishan.electronshop.dao;


import org.taishan.electronshop.domain.Category;
import org.taishan.electronshop.domain.Customer;
import org.taishan.electronshop.domain.Goods;
import org.taishan.electronshop.util.JdbcHelper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CategoryDao implements Dao<Category,Integer> {
    private String table = " t_categories ";
    @Override
    public Category load(Integer id) {
        String SQL = "SELECT id , name , position , parent_id   FROM" + table  + "WHERE id = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , id ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Category ct =   this.cast( map );
            return ct ;
        }
        return null;
    }

    @Override
    public List<Category> list() {
        return null;
    }

    @Override
    public Category cast(Map<String, Object> map) {
        Category ct = new Category();
        ct.setId( (Integer)map.get( "id" ) );
        ct.setName( (String)map.get( "name" ) );
        ct.setPosition( (Integer) map.get( "position" ) );
        return ct;
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
