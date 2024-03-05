package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
		public List<PersonVo> personSelect() {
			System.out.println("PhonebookDao.personSelect()");

			List<PersonVo> personList = sqlSession.selectList("phonebook.select");

			// System.out.println(personList);

			return personList;
		}

		// 등록
		public int personInsert(PersonVo personVo) {

			int count = sqlSession.insert("phonebook.insert", personVo);

			return count;
		}
		
		// 등록2
		public int personInsert2(Map<String, String> pMap) {
			System.out.println("PhonebookDao.personInsert2()");
			System.out.println(pMap);
			
			int count = sqlSession.insert("phonebook.insert", pMap);
			
			return count;
		}

		// 1개 가져오기
		public PersonVo personSelectOne(int no) {
			System.out.println("PhonebookDao.personSelectOne()");

			PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
			System.out.println(personVo);
			return personVo;
		}
		
		// 1개 가져오기2
		public Map<String, Object> personSelectOne2(int no) {
			System.out.println("PhonebookDao.personSelectOne2()");
			
			Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne2", no);
			//System.out.println(pMap);
			//System.out.println(pMap.get("name"));
			
			return pMap;
		}

		// 수정
		public int personModify(PersonVo personVo) {
			System.out.println("PhonebookDao.personModify()");
			
			int count = sqlSession.update("phonebook.update", personVo);
			
			return count;

		}

		// 삭제
		public int personDelete(int no) {

			int count = sqlSession.delete("phonebook.delete", no);
			// System.out.println(count);

			return count;
		}

}
