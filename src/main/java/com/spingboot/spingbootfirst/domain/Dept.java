package com.spingboot.spingbootfirst.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private int deptnu;
    private String dname;
    private String addr;
}
