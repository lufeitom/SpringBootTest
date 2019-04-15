package com.edu.manage.service.impl;

import com.edu.manage.entity.Admin;
import com.edu.manage.dao.AdminMapper;
import com.edu.manage.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lufei
 * @since 2019-04-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
