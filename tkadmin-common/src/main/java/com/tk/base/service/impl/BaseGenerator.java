package com.tk.base.service.impl;

import com.github.dozermapper.core.Mapper;
import com.tk.base.service.IBaseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : BaseGenerator
 * @description : [bean 复制 实现类，需要 bean 转换的业务直接注入即可]
 * @createTime : [2022/1/21 11:49]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/21 11:49]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
@Lazy(value = true)
public class BaseGenerator implements IBaseGenerator {

    private final Mapper dozerMapper;

    public BaseGenerator(Mapper dozerMapper) {
        this.dozerMapper = dozerMapper;
    }

    @Override
    public <T, S> T convert(S s, Class<T> clz) {
        return s == null ? null : dozerMapper.map(s,clz);
    }

    @Override
    public <T, S> List<T> convert(List<S> s, Class<T> clz) {
        return s == null ? null : s.stream().map(item -> dozerMapper.map(item,clz)).collect(Collectors.toList());
    }

    @Override
    public <T, S> Set<T> convert(Set<S> s, Class<T> clz) {
        return s == null ? null : s.stream().map(item -> dozerMapper.map(item,clz)).collect(Collectors.toSet());
    }

    @Override
    public <T, S> T[] convert(S[] s, Class<T> clz) {
        if (s == null){
            return null;
        }
        T[] arr = (T[]) Array.newInstance(clz, s.length);
        for (int i = 0; i < s.length; i++) {
            arr[i] = this.dozerMapper.map(s[i], clz);
        }
        return arr;
    }
}
