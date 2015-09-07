package com.apodoba.service;

import org.junit.Assert;
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
public class Test{

    @Autowired
    TestService testService;
    
    @org.junit.Test
    public void getTicketsCount(){
        Assert.assertEquals(8, testService.getAllTickets().size());
    }
}
