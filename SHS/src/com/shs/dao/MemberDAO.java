package com.shs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shs.dto.MemberDTO;
import com.shs.mybatis.SqlMapConfig;

public class MemberDAO {
	// MY batis 세탕값을 호출한다.
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

	// mapper에 접근하기 위한 SqlSession !
	SqlSession sqlSession;

	int result = 0;

	// [singleton패턴을 활용한 DAO객체 사용]
	// :객체생성은 1회만 동작하고 생성된 객체를 빌려쓰는형태 +외부에서는 객체생성이 불가능하게 잠금!
	private MemberDAO() {
	}

	// 외부에서 빌려서 사용할 객체 생성 (instance)
	private static MemberDAO instance = new MemberDAO();

	// 외부에서 getInstance()를 호출하면 객체를 빌려줌.
	public static MemberDAO getInstance() {
		return instance;
	}

	// 학생등록
	public int memInsert(MemberDTO mDto) {
		// (11) mybatis를사용하기 위해 sqlSessionFactory를 사용하여 sqlSession을 생성 매개변수로 true를 넣어 auto commit 기능추가		
		sqlSession = sqlSessionFactory.openSession(true); // commit를 입력해주기 위해 true 입력!!
		// sqlSession.commit();다른 commit방법
		try {
			//(12) 생성된 sqlSession을 사용하여 mybatis insert구문을 실행(**Mapper.xml),  sql문은 memInsert를 ID값으로 가지는 SQL문을 실행
			//SQL문 바인딩변수(ex:#{sid})에 들어갈 값은 mDto  결론: mapper.xml가서 memInsert SQL문에 mDto 값을 
			//바인딩 변수로 채워주고 SQL문을 실행해라.
			result = sqlSession.insert("memInsert", mDto); // sqlSession에서 insert동작중에서 "memInsert"를 가져오고 mDto에 있는 값을적어준다.
			//(14) DB에서 실행한 SQL문의 결과가 result 변수에 담김. 												

			if (result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// (15) DB에서 SQL문 실행결과가 담긴 result 변수를 호출했던곳(InsertPlayAction)으로 전송. 
		return result; // return을 만나면 메서드종결

	}

	// 출석부(학생전체출력)
	public List<MemberDTO> memSelect() {
		sqlSession = sqlSessionFactory.openSession();
		List<MemberDTO> list = null;
		try {
			System.out.println("확인");
			list = sqlSession.selectList("memSelect"); // 어떤 sql문을 실행할지 경로를 지정해주는것이다. selectList는 MY batis 라이버러리에서 기능을
														// 추가해준것!!

			for (MemberDTO memberDTO : list) {
				System.out.println(memberDTO.getSid() + ", ");
				System.out.println(memberDTO.getSname() + ", ");
				System.out.println(memberDTO.getSphone());
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace(); // e.printStackTrace(); DB에서는 예외처리는 반드시 필수기 때문에 만들어줌 캐치는 없어됨.
		} finally {
			sqlSession.close(); // close를 사용하면 다시반납.
		}
		return list;
	}

	// 학생정보 출력(1명) - Update페이지 출력시 사용
	public MemberDTO memInfo(int id) {
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = null; // 지역변수를 초기화!

		try {
			mDto = sqlSession.selectOne("memInfo", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return mDto;
	}

	// 학생 정보 수정
	public int memUpdate(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession(true);

		try {
			result = sqlSession.update("memUpdate", mDto);
			if (result > 0) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	// 학생 제적!!
	public int memDelete(int id) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			result = sqlSession.delete("memDelete", id);
			if (result > 0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	//학생검색(이름)
	public 	List<MemberDTO> memSearch(String name) {
		List<MemberDTO> list = null;
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("memSearch", name);
			
			for (MemberDTO memberDTO : list) {
				System.out.println(memberDTO.getSid() + ", ");
				System.out.println(memberDTO.getSname() + ", ");
				System.out.println(memberDTO.getSphone());
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
}
