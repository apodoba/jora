package com.apodoba;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.TestDao;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@Transactional
public class AppTest{

    @Autowired
    TestDao testDao;
    
    @Test
    public void getTicketsCount(){
        Assert.assertEquals(5, testDao.getTicketsCount());
    }
    
    @Test
    public void getUsersCount(){
        Assert.assertEquals(5, testDao.getUsersCount());
    }
}
