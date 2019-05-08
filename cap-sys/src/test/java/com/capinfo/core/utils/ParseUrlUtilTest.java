package com.capinfo.core.utils;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.HashMap;

/** 
* ParseUrlUtil Tester. 
* 
* @author <Authors name>
* @version 1.0 
*/ 
public class ParseUrlUtilTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: parser(String url) 
* 
*/ 
@Test
public void testParser() throws Exception {

    ParseUrlUtil utils = new ParseUrlUtil();
    utils.parser("redirect_uri/?code=CODE&state=STATE");

    HashMap<String,String> maps = utils.getStrUrlParas();
    System.out.println(maps.get("code"));



//TODO: Test goes here... 
} 


} 
