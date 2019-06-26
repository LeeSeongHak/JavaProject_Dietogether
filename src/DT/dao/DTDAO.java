package DT.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import DT.vo.DTBoard;
import DT.vo.DTExercise;
import DT.vo.DTUserInfo;
import DT.vo.DTVO;

public class DTDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//�α���
	public DTUserInfo loginUser(DTUserInfo user) {
		SqlSession ss = null;
		DTUserInfo userinfo = null;

		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			userinfo = mapper.loginUser(user);		
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return userinfo;
	}
	
	//ȸ�� ���
	public void insertUser(DTUserInfo user) {
		SqlSession ss = null;
	
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			mapper.insertUser(user);		
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
		
	//��ü ȸ�� ���
	public ArrayList<DTUserInfo> selectUser() {
		SqlSession ss = null;
		ArrayList<DTUserInfo> list = null;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			list = mapper.selectUser();
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return list;
	}
		
	//��ü ���� ���
	public ArrayList<DTVO> allFoodInfo() {
		SqlSession ss = null;
		ArrayList<DTVO> list = null;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			list = mapper.allFoodInfo();
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return list;
	}
	
	//��ü � ���
	public ArrayList<DTExercise> allExercise() {
		SqlSession ss = null;
		ArrayList<DTExercise> list = null;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			list = mapper.allExercise();
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return list;
	}
		
	//���� DB �߰�
	public int foodAdd(DTVO food) {
		SqlSession ss = null;
		int cnt = 0;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			cnt = mapper.foodAdd(food);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return cnt;
	}
	
	
	//� DB �߰�
	public int exerciseAdd(DTExercise exer) {
		SqlSession ss = null;
		int cnt = 0;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			cnt = mapper.exerciseAdd(exer);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return cnt;
	}
	
	//���� ���� �˻�
	public ArrayList<DTUserInfo> searchUser(int type, String keyword){
		SqlSession ss = null;
		ArrayList<DTUserInfo> ar = null;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("keyword", keyword);
			map.put("type", type);
			ar = mapper.searchUser(map);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return ar;
	}
	
	//���� �� 
	public void userBan(String name) {
		SqlSession ss = null;

		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			mapper.userBan(name);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	//�Ŵ��� �α���
	public DTUserInfo managerLogin(DTUserInfo manager) {
		SqlSession ss = null;
		DTUserInfo userinfo = null;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			userinfo = mapper.managerLogin(manager);		
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return userinfo;
	}
	
	//���� �˻�
	public ArrayList<DTVO> foodSearch(DTVO vo) {
		SqlSession ss = null;
		ArrayList<DTVO> ar = new ArrayList<>();
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			ar = mapper.foodSearch(vo);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return ar;
	}
	
	//�Խ��� �۾��� 
	public void boardWrite(DTBoard bo) {
		SqlSession ss = null;
	
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			mapper.boardWrite(bo);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	//�Խ��� ��ü�����
	public ArrayList<DTBoard> boardAll() {
		SqlSession ss = null;
		ArrayList<DTBoard> ar = new ArrayList<>();
		
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			ar = mapper.boardAll();
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return ar;
	}
	
	//�� ���ǰ˻�
	public ArrayList<DTBoard> boardSearch(int type, String keyword){
		SqlSession ss = null;
		ArrayList<DTBoard> ar = null;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			HashMap<String, Object> map = new HashMap<>();
			map.put("type", type);
			map.put("keyword", keyword);
			ar = mapper.search(map);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return ar;
	}
	
	//�ڱ�� ����-1
	public DTBoard myWritingEdit(int num) {
		SqlSession ss = null;
		DTBoard vo = null;
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			vo = mapper.myWritingEdit(num);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return vo;
	}
	
	//�ڱ�� ����-2
	public int updateID(DTBoard VO) {
		SqlSession ss = null;
		int cnt = 0;
		
		try {
			ss = factory.openSession();		
			DTMapper mapper = ss.getMapper(DTMapper.class);	
			cnt = mapper.updateID(VO);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return cnt;
	}
	
	//�ڱ�� ����
	public int deleteMyWriting(DTBoard bo) {
		SqlSession ss = null;
		int cnt = 0;
		try {
			ss = factory.openSession();
			DTMapper mapper = ss.getMapper(DTMapper.class);
			cnt = mapper.deleteMyWriting(bo);
			ss.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			if (ss != null) ss.close();
		}
		return cnt;
	}
	
	//�Ŵ����� �� �����ϱ�
	public int boardDel(int num) {
		SqlSession ss = null;
		int cnt = 0;
		try {
			ss = factory.openSession();
			DTMapper mapper = ss.getMapper(DTMapper.class);
			cnt = mapper.boardDel(num);
			ss.commit();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally{
				if (ss != null) ss.close();
			}
		return cnt;
	}
}
