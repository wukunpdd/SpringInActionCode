package cn.wukun.data;

import cn.wukun.domain.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittleByUserName(String userName);
}
