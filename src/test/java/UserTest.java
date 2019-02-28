
import model.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.taishan.electronshop.domain.Customer;
import org.taishan.electronshop.mapper.Mapper;
import org.taishan.electronshop.util.MybatisUtil;

import java.util.List;

public class UserTest {
    SqlSession sqlSession ;
    @Test
    public void insertPerson(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 10000;
        String userName = "test";
        int age = 18;
        String mobilePhone = "18000000000";
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setUsername(userName);

        try{
            sqlSession.insert("insertPerson",person);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1234;
        try{
          List<Person> person= sqlSession.selectList("test.queryById",id);
          for(Person p:person){
              System.out.println(p.toString());
          }
            System.out.println("yangqinag");
            sqlSession.commit();
//            System.out.println(person.getUsername());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }
    @Test
    public void queryById2(){
        //PropertyConfigurator.configure("log4j.properties");
        sqlSession = MybatisUtil.getSqlSession();
        Integer id = null;
        try{
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            final List<Customer> customers = mapper.queryByUsername("1234");
//            for(Person p:person){
//                System.out.println(p.toString());
//            }
           // System.out.println(person.getUsername());
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//            //构建sqlSession的工厂
//            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//
//            SqlSession session= sessionFactory.openSession();
//            Mapper mapper= session.getMapper(Mapper.class);
//            Person person = mapper.queryById(10000);
//
//            //sqlSession.commit();
//            System.out.println(person.getUsername());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

}
