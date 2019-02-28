package controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.taishan.electronshop.mapper.Mapper;
import org.taishan.electronshop.util.MybatisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
@RequestMapping("/person")
public class PersonController implements Controller {
//        Mapper service;
        SqlSession sqlSession;
        @RequestMapping("/add")
        public ModelAndView handleRequest(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
            System.out.println("y");
            sqlSession = MybatisUtil.getSqlSession();
            Mapper mapper = sqlSession.getMapper(Mapper.class);
            System.out.println("q");
            String username=request.getParameter("username");
            Integer age=Integer.valueOf(request.getParameter("age"));
            Integer id=Integer.valueOf(request.getParameter("id"));
            model.Person person=new model.Person();
            person.setAge(age);
            person.setUsername(username);
            person.setId(id);
           //mapper.insertPerson(person);
            sqlSession.commit();
            MybatisUtil.closeSession(sqlSession);
            return new ModelAndView("index");
        }

        }



