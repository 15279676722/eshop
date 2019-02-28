package org.taishan.electronshop.dao;



import org.taishan.electronshop.domain.Customer;
import org.taishan.electronshop.util.DateHelper;
import org.taishan.electronshop.util.EncryptHelper;
import org.taishan.electronshop.util.JdbcHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CustomerDao implements Dao<Customer,Integer>{

    private static final String table = " t_customers " ;

    @Override
    public Customer cast(Map<String, Object> map) {
        Customer c = new Customer();
        c.setId( (Integer)map.get( "id" ) );
        c.setUsername( (String)map.get( "username" ) );
        c.setPassword( (String) map.get( "password" ) );
        c.setName( (String) map.get( "name" ) );
        c.setGender( (String) map.get( "gender" ) );
        c.setBirthdate( (Date) map.get( "birthdate" ) );
        c.setTelephone( (String) map.get( "telephone" ) );
        return c;
    }

    @Override
    public Customer load(Integer id) {
        String SQL = "SELECT id , username , password , name , gender , birthdate , telephone FROM" + table  + "WHERE id = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , id ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Customer c =   this.cast( map );
            return c ;
        }
        return null;
    }

    public Customer load(String username) {
        String SQL = "SELECT id , username , password , name , gender , birthdate , telephone FROM" + table  + "WHERE username = ? " ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , username ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Customer c =   this.cast( map );
            return c ;
        }
        return null;
    }
    public Customer load(String username,String telephone) {
        String SQL = "SELECT id , username , password , name , gender , birthdate , telephone FROM" + table  + "WHERE username = ? and telephone = ?" ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL , username,telephone ) ;
        helper.destory();
        if( list != null && list.size() == 1 ) {
            Map<String,Object> map = list.get( 0 );
            Customer c =   this.cast( map );
            return c ;
        }
        return null;
    }
    @Override
    public List<Customer> list() {
        String SQL = "SELECT id , username , password , name , gender , birthdate , telephone FROM" + table   ;
        JdbcHelper helper = new JdbcHelper();
        List<Map<String,Object>> list = helper.query( SQL ) ;
        helper.destory();
        if( list != null && list.size() > 0  ) {
            List<Customer> customers = new ArrayList<>();

            for( int i = 0 ; i < list.size() ; i++ ) {
                Map<String, Object> map = list.get(i);
                Customer c =   this.cast( map );
                customers.add(c);
            }

            return customers ;
        }
        return null;
    }

    @Override
    public boolean save(Customer c) {
        String SQL = "INSERT INTO " + table +
                             " ( username , password , name , gender , birthdate , telephone ) " +
                            " VALUES ( ? , ? , ? , ? , ? , ? )" ;
        // 对 用户 的密码进行 MD5 加密
        Customer load = this.load(c.getUsername());
        if(load==null) {
            String password = EncryptHelper.encrypt(c.getPassword());
            // 将 java.util.Date 转换成 java.sql.Date
            java.sql.Date birthdate = DateHelper.cast(c.getBirthdate());
            // 将 Customer 对象中的各个 字段的值 作为 参数占位符 的取值 依次添加到 数组中
            Object[] array = {c.getUsername(), password, c.getName(), c.getGender(), birthdate, c.getTelephone()};
            JdbcHelper helper = new JdbcHelper();
            // 执行插入语句，并获得由数据库产生的主键值
            int id = helper.insert(SQL, array);
            c.setId(id); // 将由数据库产生的主键值设置到 Customer 对象的 id 字段上
            helper.destory();
            // 如果 id 不等于 -1  则视为保存成功( 在 JdbcHelper 的 insert 方法中有约定 )
            return id != -1;
        }else
        {return false;}
    }

    @Override
    public boolean update(Customer c) {
        String SQL = "UPDATE " + table +
                " SET name = ?, gender = ? , birthdate = ?  " +
                " WHERE username = ? " ;
        java.sql.Date birthdate = DateHelper.cast( c.getBirthdate() );
        Object[] params = {c.getName() , c.getGender() , birthdate  , c.getUsername() };
        JdbcHelper helper = new JdbcHelper();
        int count = helper.update( SQL , params );
        helper.destory();
        return count == 1 ;
    }

    /**
     * 专门定义一个用来修改密码的方法
     * @param username 哪个用户需要修改密码
     * @param password 修改后的密码( 未加密 )
     * @return
     */
    public boolean updatePassword( String username, String password ) {
        String SQL = "UPDATE " + table + " SET password = ?  " +  " WHERE username = ? " ;
        JdbcHelper helper = new JdbcHelper();
        int count = helper.update( SQL , EncryptHelper.encrypt( password ) , username );
        helper.destory();
        return count == 1 ;
    }

    @Override
    public boolean delete(Integer id) {
        String SQL = "DELETE FROM " + table + " WHERE id = ? ";
        JdbcHelper helper = new JdbcHelper();
        int count = helper.update( SQL , id );
        helper.destory();
        return count == 1 ;
    }

}
