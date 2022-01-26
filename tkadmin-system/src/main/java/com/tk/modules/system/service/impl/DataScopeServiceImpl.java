package com.tk.modules.system.service.impl;

import com.tk.modules.security.service.dto.UserDetailedInformation;
import com.tk.modules.system.entity.Dept;
import com.tk.modules.system.entity.Role;
import com.tk.modules.system.enums.DataScopeEnum;
import com.tk.modules.system.service.IDataScopeService;
import com.tk.modules.system.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : DataScopeServiceImpl
 * @description : [数据权限服务实现类]
 * @createTime : [2022/1/5 16:20]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/5 16:20]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class DataScopeServiceImpl implements IDataScopeService {

    private final IDeptService iDeptService;

    public DataScopeServiceImpl(IDeptService service) {
        this.iDeptService = service;
    }

    @Override
    public List<Long> getDeptIds(UserDetailedInformation userDetailedInformation) {
        // 用于存储部门id
        Set<Long> deptIds = new HashSet<>();
        // 获取用户角色
        Set<Role> roles = userDetailedInformation.getRoles();
        for (Role role : roles){
            DataScopeEnum dataScopeEnum = DataScopeEnum.getDataScopeEnum(role.getDataScope());
            switch (Objects.requireNonNull(dataScopeEnum)){
                // 本级数据权限
                case THIS_LEVEL:
                    deptIds.add(userDetailedInformation.getDept().getId());
                    break;
                // 自定义数据权限
                case CUSTOMIZE:
                    deptIds.addAll(getCustomize(deptIds,role));
                    break;
                // 非本级 非自定义(全部)
                default:
                    return new ArrayList<>(deptIds);
            }
        }
        return new ArrayList<>(deptIds);
    }

    /**
     * 获取自定义的数据权限
     * @param deptIds 部门id集合
     * @param role 角色
     * @return 数据权限Ids
     */
    public Set<Long> getCustomize(Set<Long> deptIds,Role role){
        // 查询角色对应的部门集合
        Set<Dept> depts = iDeptService.findByRoleId(role.getId());
        List<Integer> list = new ArrayList<>();
        // 遍历部门集合，把其及以下的子部门加入
        for (Dept dept : depts){
            deptIds.add(dept.getId());
            // 其下的一级子部门，需要检验子部门下是否有子部门，和其下是否有一级子部门也就是查询的集合是否为空
            List<Dept> deptChildren = iDeptService.findByPid(dept.getId());
            if (deptChildren != null && deptChildren.size() != 0){
                // 其下一级子部门不为空，需要递归查找 n 级子部门
                deptIds.addAll(iDeptService.getDeptChildren(deptChildren));
            }
        }
        return deptIds;
    }
}
