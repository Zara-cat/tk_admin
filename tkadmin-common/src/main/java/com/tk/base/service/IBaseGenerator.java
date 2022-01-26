package com.tk.base.service;

import java.util.List;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : BaseIGenerator
 * @description : [bean 实体转换 base接口]
 * @createTime : [2022/1/21 11:45]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/21 11:45]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IBaseGenerator {
    /**
     * 转换
     *
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return {@link T}
     * @Description: 单个对象的深度复制及类型转换，vo/domain , po
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:53:24
     */
    <T, S> T convert(S s, Class<T> clz);


    /**
     * 转换
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return {@link List<T>}
     * @Description: list深度复制
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:54:08
     */
    <T, S> List<T> convert(List<S> s, Class<T> clz);


    /**
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return
     * @Description: set深度复制
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:54:39
     */
    <T, S> Set<T> convert(Set<S> s, Class<T> clz);

    /**
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return
     * @Description: 数组深度复制
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:54:57
     */
    <T, S> T[] convert(S[] s, Class<T> clz);
}
