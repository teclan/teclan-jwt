package com.tecan.jwt;

import com.teclam.jwt.JwtFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TokenTest {

    String subject="teclan";
    String token="";

    @Before
    public  void setUp(){
        token = JwtFactory.getJws(subject);
    }

    @Test
    public void vaildTest(){
        Assert.assertEquals(JwtFactory.verify(subject,token),true);
    }
}
