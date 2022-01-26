package com.tk.modules.system.service.impl;

import com.tk.modules.system.dao.IDeptDao;
import com.tk.modules.system.entity.Dept;
import com.tk.modules.system.service.IDeptService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : DeptServiceImpl
 * @description : [部门相关 service 实现类]
 * @createTime : [2022/1/10 21:29]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/10 21:29]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class DeptServiceImpl implements IDeptService {

    private final IDeptDao iDeptDao;

    public DeptServiceImpl(IDeptDao dao) {
        this.iDeptDao = dao;
    }

    /**
     * 根据角色 id 查询 部门集合
     * @param id
     * @return
     */
    @Override
    public Set<Dept> findByRoleId(Long id) {
        return iDeptDao.selectDeptByRoleId(id);
    }

    /**
     * 根据 Pid 查询 部门
     * @param id
     * @return
     */
    @Override
    public List<Dept> findByPid(Long id) {
        return iDeptDao.selectDeptByPid(id);
    }

    /**
     * 根据部门集合 获取其项的子部门 id 集合
     * @param deptList
     * @return
     */
    @Override
    public List<Long> getDeptChildren(List<Dept> deptList) {
        List<Long> list = new ArrayList<>();
        deptList.forEach(dept -> {
            if (dept != null && dept.getEnabled()){
                // 获取每一个 部门 的子部门集合
                List<Dept> depts = iDeptDao.selectDeptByPid(dept.getId());
                if (!CollectionUtils.isEmpty(depts) && depts.size() != 0){
                    // 如果获取的子部门集合不为空，递归
                    list.addAll(getDeptChildren(depts));
                }
                // 如果为空
                list.add(dept.getId());
            }
        });
        return list;
    }
}
