package com.example.evenementenkalenderbe.utils;

import org.springframework.beans.BeanUtils;

public class PropertyMapper {

    public static <T, U> void copyProperties(T source, U destination) {
        BeanUtils.copyProperties(source, destination);
    }
}
