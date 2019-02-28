package org.taishan.electronshop.domain;

import java.util.*;

// 对应 t_categories
public class Category {

    private Integer id;
    private String name;
    private int position;

    private Category parent ; // 当前分类的父分类 对应  Category 对象

    private List<Category> categories ;  // 当前分类的所有子分类组成的List集合

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}