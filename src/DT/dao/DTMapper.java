package DT.dao;

import java.util.ArrayList;
import java.util.HashMap;

import DT.vo.DTBoard;
import DT.vo.DTExercise;
import DT.vo.DTUserInfo;
import DT.vo.DTVO;

public interface DTMapper {

	public void insertUser(DTUserInfo i);
	public DTUserInfo loginUser(DTUserInfo i);
	public ArrayList<DTUserInfo> selectUser();
	public ArrayList<DTVO> allFoodInfo();
	public ArrayList<DTExercise> allExercise();
	public int foodAdd(DTVO i);
	public int exerciseAdd(DTExercise i);
	public ArrayList<DTUserInfo> searchUser(HashMap<String, Object> map);
	public void userBan(String name);
	public DTUserInfo managerLogin(DTUserInfo i);
	public ArrayList<DTVO> foodSearch(DTVO vo);
	public void boardWrite(DTBoard bo);
	public ArrayList<DTBoard> boardAll();	
	public ArrayList<DTBoard> search(HashMap<String,Object> map);
	public DTBoard myWritingEdit(int num);
	public DTBoard idnumCheck(DTBoard bo);
	public int updateID(DTBoard bo);
	public int deleteMyWriting(DTBoard bo);
	public int boardDel(int num);
}
