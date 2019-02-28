package org.taishan.electronshop.mapper;

import org.taishan.electronshop.domain.TrolleyItem;

import java.util.List;

public interface TrolleyMapper {
    List<TrolleyItem> querybyCostomer(String username);
}
