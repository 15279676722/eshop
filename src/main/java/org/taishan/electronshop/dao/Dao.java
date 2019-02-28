package org.taishan.electronshop.dao;

import java.util.List;
import java.util.Map;


/**
 * DAO , Data Access Object ， 数据访问对象
 * @param <E> 类型化参数，表示某个被持久化对象的类型
 * @param <P> 类型化参数 ，表示某个被持久化对象的对象标识符(对应主键)的类型
 */
public interface Dao< E , P> {

    /**
     * 根据主键值从数据库查询一条记录后，包装成一个对象
     * @param id 数据库中的主键
     * @return 根据返回的数据库记录包装的Java对象
     */
    E load(P id) ;


    /**
     * 查询数据库中的所有记录后，将这些记录包装成Java对象，并添加到一个List集合中
     * @return
     */
    List<E> list() ;

    /**
     * 将 map 集合中的 键值对 封装到 指定类型的 对象中
     * @param map 需要处理的 map 集合
     * @return 封装之后的 Java 对象
     */
    E cast(Map<String, Object> map);

    /**
     * 保存一个对象到数据库中
     * @param e 被保存的Java对象
     * @return 如果保存成功，返回 true,否则返回 false
     */
    boolean save(E e) ;

    /**
     * 使用某个对象中的数据更新数据库中的记录( 该对象 的 id 跟数据库中某个一行数据的主键必须相等 )
     * @param e 被更新的对象
     * @return 当更新成功时返回 true,否则返回 false
     */
    boolean update(E e) ;

    /**
     * 根据id删除数据库中的一条记录
     * @param id 被删除记录的主键值
     * @return 当删除成功时返回 true,否则返回 false
     */
    boolean delete(P id) ;

}
