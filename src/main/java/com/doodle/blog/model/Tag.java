package com.doodle.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Tag implements Serializable {
    int tagId;
    String tagName;
}
