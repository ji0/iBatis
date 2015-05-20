package com.sds.icto.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sds.icto.vo.MemberVO;

public class MemberDao {

	private SqlMapClient sqlMapClient;

	public MemberDao() {

		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public List<MemberVO> get(){
		return null;
	}
	
	public List<MemberVO> getByEmail(String email){
		List<MemberVO> list = null;
		try {
			list =  sqlMapClient.queryForList("member.getMember2", email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	public List<MemberVO> getByNameEmail(String name, String email){
		List<MemberVO> list = null;
		try {
			
			Map map = new HashMap();
			map.put("n", name);
			map.put("e", email);
			
			list =  sqlMapClient.queryForList("member.getMember3", map);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	public MemberVO get(MemberVO vo){
		
		MemberVO vo2 = null;
		
		try {
			vo2 = (MemberVO) sqlMapClient.queryForObject("member.getMember", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo2;
	}
	public void insert(MemberVO vo) {
		try {
			sqlMapClient.insert("member.insert", vo);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
