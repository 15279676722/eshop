package org.taishan.electronshop.mapper;

import model.Person;
import org.apache.ibatis.annotations.Param;
import org.taishan.electronshop.domain.Customer;

import java.util.List;
import java.util.Map;

public interface Mapper {

   List<Customer> queryById(Integer id);

   List<Customer> queryByUsername(String username);

   void add(Customer person);

   void insertPerson(Customer person);

   List<Customer> selectAllByPage(@Param("search") Map<String, Object> map);

   int insert(Customer c);
}
