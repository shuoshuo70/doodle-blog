package com.doodle.blog.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {

    @Autowired
    TagMapper mapper;

    @Test
    public void queryTags() {
        Assert.assertEquals(new ArrayList<>(), mapper.queryTags());
    }
}