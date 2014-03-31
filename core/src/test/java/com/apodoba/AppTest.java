package com.apodoba;

import com.apodoba.dao.TestDao;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    @Ignore
    public void countOfTypes(){
        Assert.assertEquals(0, testDao.getTypesCount());
    }
}
