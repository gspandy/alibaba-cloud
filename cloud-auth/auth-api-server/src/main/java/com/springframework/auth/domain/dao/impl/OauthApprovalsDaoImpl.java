package com.springframework.auth.domain.dao.impl;

import com.springframework.auth.domain.po.OauthApprovals;
import com.springframework.auth.domain.mapper.OauthApprovalsMapper;
import com.springframework.auth.domain.dao.OauthApprovalsDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author summer
 * @since 2019-05-06
 */
@Service
public class OauthApprovalsDaoImpl extends ServiceImpl<OauthApprovalsMapper, OauthApprovals> implements OauthApprovalsDao {
	
}
