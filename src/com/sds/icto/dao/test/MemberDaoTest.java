package com.sds.icto.dao.test;

import java.util.List;

import com.sds.icto.dao.MemberDao;
import com.sds.icto.vo.MemberVO;

public class MemberDaoTest {

	private static MemberDao dao;

	public static void main(String[] args) {

		before();
		insertTest();
		getTest();
	}

	public static void before() {
		dao = new MemberDao();
	}

	public static void insertTest() {
		MemberVO vo = new MemberVO();
		vo.setName("test22");
		vo.setEmail("test@te.st");
		vo.setPassword("123422");
		vo.setGender("female22");
		dao.insert(vo);
	}

	public static void getTest() {
		MemberVO vo = new MemberVO();

		vo.setEmail("test@te.st");
		vo.setPassword("1234");

		MemberVO vo2 = dao.get(vo);
		System.out.println(vo2.getNo() + " : " + vo2.getName());

		List<MemberVO> list = dao.getByEmail("test@te.st");
		for (MemberVO vo3 : list) {
			System.out.println(vo3.getNo() + " : " + vo3.getEmail() + " : "
					+ vo3.getName());
		}
		
		List<MemberVO> list2 = dao.getByNameEmail("test", "test@te.st");
		for (MemberVO vo3 : list2) {
			System.out.println(vo3.getNo() + " : " + vo3.getEmail() + " : "
					+ vo3.getName());
		}
	}
}
