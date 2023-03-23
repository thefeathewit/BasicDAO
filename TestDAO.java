package com.czedu.dao_.test;

import com.czedu.dao_.dao.ActorDAO;
import com.czedu.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    @Test
    //测试ActorDAO 对actor表的crud操作
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();

        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 2);
        System.out.println(actor);

        //查询单行单列
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 2);
        System.out.println(o);


        int update = actorDAO.update("insert into actor values(null,?,?,?,?)", "tom", "男", "2020-11-11", "156");
        System.out.println(update > 0 ? "成功" : "没有影响");
    }


}
