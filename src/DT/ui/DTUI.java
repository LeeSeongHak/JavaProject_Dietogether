package DT.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import DT.dao.DTDAO;
import DT.vo.DTBoard;
import DT.vo.DTExercise;
import DT.vo.DTUserInfo;
import DT.vo.DTVO;


public class DTUI {
	Scanner scan;
	DTDAO dao;
	DTVO vo;
	DTBoard board;
	DTExercise exer;
	static DTUserInfo user;
	static String nameSave;
	public DTUI() {
		scan = new Scanner(System.in);
		dao  = new DTDAO();
		vo = new DTVO();
		board = new DTBoard();
		user = new DTUserInfo();
		exer = new DTExercise();
	}
	
	//메인 메뉴
	public int loginMenu() {
		System.out.println("######           #######                                                ");
		System.out.println("#     # # ######    #     ####   ####  ###### ##### #    # ###### #####");
		System.out.println("#     # # #         #    #    # #    # #        #   #    # #      #    #");	
		System.out.println("#     # # #####     #    #    # #      #####    #   ###### #####  #    #");
		System.out.println("#     # # #         #    #    # #  ### #        #   #    # #      #####");
		System.out.println("#     # # #         #    #    # #    # #        #   #    # #      #   #");
		System.out.println("######  # ######    #     ####   ####  ######   #   #    # ###### #    #");
		int num;
		System.out.println("	┌───────────────────────────────────────────────────────┐");
		System.out.println("	│		<     로 그 인 메  뉴     >			│");
		System.out.println("	│		1. 로 그 인 하 기				│");
		System.out.println("	│		2. 회 원 가 입 하 기				│");
		System.out.println("	│		9. 관 리 자 모 드				│");
		System.out.println("	│		0. 프 로 그 램 종 료				│");
		System.out.println("	└───────────────────────────────────────────────────────┘");
		while(true) {
			System.out.print("		* 입력 : ");
			try {
			num = scan.nextInt();
			scan.nextLine();
			break;
			}
			catch(InputMismatchException ex) {
				System.out.println("좋은말 할때 숫자써라");
				scan.nextLine();
			}
		}
		return num;
	}
	
	//로그인 하기
	public boolean login() {
		DTUserInfo loguser = new DTUserInfo();
		String id, password;
		boolean i = true;
		System.out.println("< 로 그 인 >");
		System.out.print("* 아이디 : ");
		id = scan.nextLine();
		System.out.print("* 비밀번호 : ");
		password = scan.nextLine();
		user = new DTUserInfo(id, password);
		loguser = dao.loginUser(user);
			if (loguser == null) {
				System.out.println("[알림] 회원 목록에 없는 회원입니다. 메뉴로 돌아갑니다.");
				i = false;
				}
			else {
				System.out.println("[알림] 로그인에 성공하였습니다.");
				nameSave = user.getId();
				}
			return i;
	}
	
	//전체 회원 목록
	public void selectUserInfo() {
		ArrayList<DTUserInfo> ar = new ArrayList<DTUserInfo>();
		ar = dao.selectUser();
		int i;
		System.out.println("┌───────────────────────────────────────────────────────┐");
			for(i = 0;i < ar.size();i++) {
				System.out.println(ar.get(i).toString());
				if (i == ar.size() - 1){
					break;
				}
			}
		System.out.println("└───────────────────────────────────────────────────────┘");
	}
	
	//가입하기
	public void join() 
	{
		String id, password, name, phone, address;
		System.out.println("< 회 원 가 입 >");
		out:
		while(true) 
		{
			System.out.print("* 아이디 : ");
			id = scan.nextLine();
			ArrayList<DTUserInfo> ar = new ArrayList<DTUserInfo>();
			ar = dao.selectUser();
			for(int i = 0; i < ar.size();i++) 
				{
					if (id.equals(ar.get(i).getId()))
						{
							System.out.println("[알림] 이미 존재하는 아이디입니다. 다시 입력해주세요.");
							continue out;
						}
				}
			break;
		}
		System.out.print("* 비밀번호 : ");
		password = scan.nextLine();
		System.out.print("* 이름 : ");
		name = scan.nextLine();
		System.out.print("* 연락처 : ");
		phone = scan.nextLine();
		System.out.print("* 주소 : ");
		address = scan.nextLine();
		DTUserInfo user = new DTUserInfo(id, password, name, phone, address);
		dao.insertUser(user);
		System.out.println("[알림] 가입되었습니다.");
		return;
	}
	
	//관리자 로그인 하기
	public boolean managerLogin() {
		DTUserInfo loguser = new DTUserInfo();
		String id, password;
		boolean b = true;
		System.out.println("< 관 리 자 로 그 인 >");
		System.out.println((" ID : admins / PassWord : 1234 "));
		System.out.print("* 아이디 : ");
		id = scan.nextLine();
		System.out.print("* 비밀번호 : ");
		password = scan.nextLine();
		if(id.equals("admins") || password.equals("1234")) {
			user = new DTUserInfo(id, password);
			loguser = dao.managerLogin(user);
			System.out.println("[알림] 관리자 로그인에 성공하였습니다.");
			return b;
		}
		else {
			System.out.println("[알림] 아이디 또는 비밀번호를 잘못 입력하였습니다.");
			System.out.println("[알림] 메뉴로 돌아갑니다.");
			b = false;
			return b;			
		}
	}
	
	//매니저 메뉴
	public int managerMenu() {
		int num;
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│	< 관 리 자 메 뉴 >		│");
		System.out.println("│	1. 전체 회원 목록		│");
		System.out.println("│	2. 전체 음식 목록		│");
		System.out.println("│	3. 전체 운동 목록		│");
		System.out.println("│	4. 음식DB 추가		│");
		System.out.println("│	5. 운동DB 추가		│");
		System.out.println("│	6. 회원 검색		│");
		System.out.println("│	7. 회원 추방		│");
		System.out.println("│	8. 게시판 관리		│");
		System.out.println("│	0. 메인으로 돌아가기		│");
		System.out.println("└───────────────────────────────┘");
		while(true) {
			System.out.print("* 입력 : ");
			try {
			num = scan.nextInt();
			scan.nextLine();
			break;
			}
			catch(InputMismatchException ex) {
				System.out.println("숫자");
				scan.nextLine();
			}
		}
		return num;		
	}
	
	//전체 음식 목록
	public void allFoodInfo() {
		ArrayList<DTVO> ar = new ArrayList<DTVO>();
		ar = dao.allFoodInfo();
		int i;
		int cnt = 1;
		System.out.println("┌───────────────────────────────────────────────────────┐");
			for(i = 0;i < ar.size();i++) {
				System.out.println(cnt +"번 음식 -> "+ ar.get(i)+"kcal");
				cnt++;
				if (i == ar.size() - 1){
					break;
				}
			}
		System.out.println("└───────────────────────────────────────────────────────┘");
	}
	
	//전체 운동 목록
	public void allExercise() {
		ArrayList<DTExercise> ar = new ArrayList<DTExercise>();
		ar = dao.allExercise();
		int i;
		int cnt = 1;
		System.out.println("┌───────────────────────────────────────────────────────┐");
			for(i = 0;i < ar.size();i++) {
				System.out.println(cnt +"번 운동 -> "+ ar.get(i)+"kcal 소모");
				cnt++;
				if (i == ar.size() - 1){
					break;
				}
			}
			System.out.println("└───────────────────────────────────────────────────────┘");
	}
	
	//음식 추가하기
	public void foodAdd() {
		int category;
		DTVO vo;
		String food, kcal;
		int cnt;
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│	< 음식 대분류 정보 >		│");
		System.out.println("│1.한식(밥류,국,찌개)		│");
		System.out.println("│2.분식(떡볶이,순대,김밥,튀김,오뎅,만두)	│");
		System.out.println("│3.돈까스,회,일식			│");
		System.out.println("│4.패스트푸드(치킨,피자,햄버거 등)	│");
		System.out.println("│5.중식(짜장,짬뽕,탕수육 등)		│");
		System.out.println("│6.족발,보쌈			│");
		System.out.println("│7.찜,탕				│");
		System.out.println("│8.디저트				│");
		System.out.println("│9.음료				│");
		System.out.println("└───────────────────────────────┘");
		while(true) {
		System.out.print("* 추가할 음식 대분류 : ");
		try {
			category = scan.nextInt();
			break;
		}
		catch(InputMismatchException ex) {
			System.out.println("number");
			scan.nextLine();
		}
		}
		scan.nextLine();
		System.out.print("* 추가할 음식 이름 : ");
		food = scan.nextLine();
		System.out.print("* 칼로리(1인분기준. kcal제외. 숫자만 입력) : ");
		kcal = scan.nextLine();		
		vo = new DTVO(category, food, kcal);
		cnt = dao.foodAdd(vo);
		if(cnt==0) {
			System.out.println("[알림] 음식 등록에 실패하였습니다.");
		}
		else {
			System.out.println("[알림] 새로운 음식 등록이 완료되었습니다.");
		}
		return;
	}
	
	//운동 추가하기
	public void exerciseAdd() {
		DTExercise ex;
		String name, kcal;
		int cnt;
		System.out.print("* 추가할 운동 이름(입력 예시 - 보통 걷기 10(분)) : ");
		name = scan.nextLine();
		System.out.print("* 칼로리소모량(kcal제외. 숫자만 입력) : ");
		kcal = scan.nextLine();		
		ex = new DTExercise(name, kcal);
		cnt = dao.exerciseAdd(ex);
		if(cnt == 0) {
			System.out.println("[알림] 운동 등록에 실패하였습니다.");
		}
		else {
			System.out.println("[알림] 새로운 운동 등록이 완료되었습니다.");
		}
		return;
	}

	//회원 검색
	public void userSearch() {
		String keyword = null;
		int type;
		out:
		while(true) {
		System.out.println("[ 회 원 검 색 ]");
		while(true) {
		System.out.print("* 검색할 대상 (1:아이디, 2: 이름, 3: 가입년도) : ");
		try {
			type = scan.nextInt();
			scan.nextLine();
			break;
		}
		catch(InputMismatchException ex) {
			System.out.println("숫자를 입력하세요..");
			scan.nextLine();
		}
		}
		switch (type) {
			case 1 : System.out.print("* 검색할 아이디 : "); break out;
			case 2 : System.out.print("* 검색할 이름 : "); break out;
			case 3 : System.out.print("* 검색년도(2000년일 경우 -> 2000) : "); break out;
			default : System.out.println("[알림] 잘못 입력하였습니다. 다시 입력하세요."); continue out;
			}
		}
		keyword = scan.nextLine();
		ArrayList<DTUserInfo> list = dao.searchUser(type, keyword);
		if (list == null || list.size() == 0) {
			System.out.println("[알림] 검색 결과가 없습니다.");
		}
		else {
			for (DTUserInfo vo : list) {
				System.out.println(vo);
			}
			System.out.println("[알림] " + list.size() + "개의 글이 검색되었습니다.");
		}	
	}
	
	//회원 추방
	public void userBan() {
		String id;
		System.out.println("[ 회 원 강 제 추 방 ]");
		System.out.print("* 추방할 대상의 아이디 : ");
		while(true) {	
			id = scan.nextLine();
			ArrayList<DTUserInfo> ar = new ArrayList<DTUserInfo>();
			ar = dao.selectUser();
			for(int i = 0; i < ar.size();i++) 
				{
					if (id.equals(ar.get(i).getId()))
						{
							dao.userBan(id);
							System.out.println("[알림] 회원정보가 삭제되었습니다.");
							return;
						}		
				}
			System.out.println("[알림] 검색한 아이디가 없습니다.");
			return;
			}	
	}
	
	//관리자 모드 종료
	public void m_exit() {
		System.out.println("[알림] 관리자모드를 종료합니다.");
	}
	
	//프로그램 종료
	public void exit() {
		System.out.println("[알림] 프로그램을 종료합니다.");
	}
	
	//회원 메뉴
	public int Menu() {
		int num;
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│	< 회 원 메 뉴 >		│");
		System.out.println("│	1.음식별 칼로리 검색	 	│");
		System.out.println("│	2.운동별 칼로리 소모량 정보	│");
		System.out.println("│	3.자신의 bmi 계산하기		│");
		System.out.println("│	4.다이어트플래너 게시판		│");
		System.out.println("│	0.종료			│");
		System.out.println("└───────────────────────────────┘");
		while(true) {
		System.out.print("* 입력 : ");
		try {
			num = scan.nextInt();
			scan.nextLine();
			break;
		}
		catch(InputMismatchException ex) {
			System.out.println("숫자좀 입력하세요..");
			scan.nextLine();
		}
		}
		return num;
	}
	
	//음식별 칼로리 검색
	public void foodSearch() {
		int category;
		String food;
		DTVO vo;
		ArrayList<DTVO> ar = new ArrayList<>();
		System.out.println("");
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│	< 음식 대분류 정보 >		│");
		System.out.println("│1.한식(밥류,국,찌개)		│");
		System.out.println("│2.분식(떡볶이,순대,김밥,튀김,오뎅,만두)	│");
		System.out.println("│3.돈까스,회,일식			│");
		System.out.println("│4.패스트푸드(치킨,피자,햄버거 등)	│");
		System.out.println("│5.중식(짜장,짬뽕,탕수육 등)		│");
		System.out.println("│6.족발,보쌈			│");
		System.out.println("│7.찜,탕				│");
		System.out.println("│8.디저트				│");
		System.out.println("│9.음료				│");
		System.out.println("└───────────────────────────────┘");
		while(true) {
		System.out.print("* 찾을 음식 대분류 : ");
		try {
			category = scan.nextInt();
			scan.nextLine();
			break;
		}
		catch(InputMismatchException ex) {
			System.out.println("숫 자 입 력 하 세 요");
			scan.nextLine();
		}
		}
		System.out.print("* 찾을 음식명 : ");
		food = scan.nextLine();
		vo = new DTVO(food, category);
		ar = dao.foodSearch(vo);
		int cnt = 0;
		for(int i = 0; i < ar.size() ; i++) {
			cnt++;
			System.out.println("──────────────────────────────────────────");
			System.out.println(cnt +"번 음식 -> "+ ar.get(i)+"kcal");
		}
		System.out.println("──────────────────────────────────────────");
		System.out.println("[알림] 출력을 완료하였습니다.");
	}
	
	//운동별 칼로리 소모량 정보
	public void exerciseInfo() {
		System.out.println(" < 운 동 별 칼 로 리 소 모 량 >");
		allExercise();
	}
	
	//자신의 bmi지수 계산하기
	public void bmi() {
		double height, height2, weight, result;
		System.out.println("< 신체질량지수 [body mass index] 계산 >");
		System.out.println("───키와 몸무게를 단위 상관없이 숫자만 입력해주세요.───");
		System.out.print("* 키(cm) : ");
		height = scan.nextDouble();
		System.out.print("* 몸무게(kg) : ");
		weight = scan.nextDouble();
		height2 = height / 100;
		height2 = height2 * height2;
		result = weight / height2;
		if(result<20) {
			System.out.println("[알림] 회원님은 저체중입니다. 영양가 넘치는 음식 위주로 먹어보세요!");
		} else if(result<25) {
			System.out.println("[알림] 회원님은 정상체중입니다. 건강은 있을 때 챙겨야 해요! 열심히 관리해보아요");
		} else if(result<30) {
			System.out.println("[알림] 회원님은 과체중입니다. 조금씩 식단을 조절해봅시다!");			
		}else if(result>=35) {
			System.out.println("[알림] 회원님은 비만입니다. 우리 함께 체중 조절을 해보아요!");			
		}
		System.out.println("BMI: "+result);
	}
	
	//게시판
	public int Board() {
		int num;
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│	< 게 시 판 >		│");
		System.out.println("│	1.글쓰기	 		│");
		System.out.println("│	2.전체 글읽기		│");
		System.out.println("│	3.내가 쓴 글읽기		│");
		System.out.println("│	4.글 검색하기		│");
		System.out.println("│	5.자기 글 수정하기		│");
		System.out.println("│	6.자기 글 삭제하기		│");
		System.out.println("│	0.프로그램 종료		│");
		System.out.println("└───────────────────────────────┘");
		while(true) {
			System.out.print("* 입력 : ");
			try {
				num = scan.nextInt();
				scan.nextLine();
				break;
			}
			catch(InputMismatchException ex) {
				System.out.println("숫자");
				scan.nextLine();
			}
		}
		return num;
	}
	
	//게시판 글쓰기
	public void boardWrite(){
		String id, title, content;
		id = nameSave;
		System.out.print("* 제목 : ");
		title = scan.nextLine();
		System.out.print("* 내용 : ");
		content = scan.nextLine();
		DTBoard bo = new DTBoard(id, title, content);
		dao.boardWrite(bo);
		System.out.println("[알림] 저장되었습니다.");
	}
	
	//게시판 글 전체 목록
	public void boardAll() {
		ArrayList<DTBoard> ar = new ArrayList<DTBoard>();
		ar = dao.boardAll();
		for(int i = 0;i < ar.size();i++) {
			System.out.println(ar.get(i));
		}
		if(ar.isEmpty()) {
			System.out.println("[알림] 게시판 글이 없습니다. 제일 먼저 글을 써보세요.");
		}
		else {
		System.out.println("[알림] 전체 글 출력을 완료하였습니다.");
		}
	}
	
	//자기 글 목록
	public void myBoard() {
		ArrayList<DTBoard> ar = new ArrayList<>();
		ar = dao.boardAll();
		int cnt = 0;
		for(int i = 0;i < ar.size();i++) {
			if(nameSave.equals(ar.get(i).getU_ID())) {
				System.out.println(ar.get(i));
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println("[알림] 출력할 글이 없습니다. 글을 써주세요.");
		}
		else {
		System.out.println("[알림] 본인 글 출력을 완료하였습니다.");
		}
	}
	
	//게시판 글 검색
	public void boardSearch() {
		String keyword = null;
		System.out.println("[ 검 색 ]");
		int type;
		while(true) {
		System.out.print("검색할 대상 (1:제목에서 찾기, 2: 내용에서 찾기, 3: 아이디에서 찾기) : ");
		try {
			 type = scan.nextInt();
			scan.nextLine();
			break;
		}
		catch(InputMismatchException ex) {
			System.out.println("숫자");
			scan.nextLine();
		}
		}
		System.out.print("* 검색할 내용 : ");
		keyword = scan.nextLine();
		ArrayList<DTBoard> list = dao.boardSearch(type, keyword);
		
		if (list == null || list.size() == 0) {
			System.out.println("[알림] 검색 결과가 없습니다.");
		}
		else {
			for (DTBoard vo : list) {
				System.out.println(vo);
			}
			System.out.println("[알림] " + list.size() + "개의 글이 검색되었습니다.");
		}	
	}
	
	//자기글 수정
	public void myWritingEdit() {
		ArrayList<DTBoard> ar = new ArrayList<>();
		ar = dao.boardAll();
		int cnt = 0;
		System.out.println("<본인이 올린 글 목록>");
		for(int i = 0;i < ar.size();i++) {
			if(nameSave.equals(ar.get(i).getU_ID())) {
				System.out.println(ar.get(i));
			}
		}
		while(true) {
			int num;
			while(true) {
					System.out.print("* 수정할 글 번호 : ");
					try {
						num = scan.nextInt();
						scan.nextLine();
						break;
					}
					catch(InputMismatchException ex) {
						System.out.println("숫자");
						scan.nextLine();
					}
			}
				board = dao.myWritingEdit(num);
				if (dao.myWritingEdit(num)==null) {
					System.out.println("[알림] 없는 글 번호입니다. 다시 입력해주세요.");
					break;
				}
				String title;
				System.out.print("* 수정할 글 제목(엔터 입력시 기존 제목이 유지됩니다.) : ");
				title = scan.nextLine();
				if(title.isEmpty()) {
					title = board.getDTBOARD_TITLE();
				}
				String content;
				System.out.print("* 수정할 글 내용(엔터 입력시 기존 내용이 유지됩니다.) : ");
				content = scan.nextLine();
				if(content.isEmpty()) {
					content = board.getDTBOARD_CONTENT();
				}
				
				DTBoard bo = new DTBoard(num, nameSave, title, content);
				cnt = dao.updateID(bo);
	
				if(cnt == 0) {
					System.out.println("[알림] 수정에 실패하였습니다. 본인 글 번호가 맞는지 확인해주세요.");
					break;
				}
				else {
					System.out.println("[알림] 수정되었습니다.");
					return;
				}
			}
	}
	
	//자기글 삭제하기
	public void myWritingDel() {
		ArrayList<DTBoard> ar = new ArrayList<>();
		ar = dao.boardAll();
		int cnt;
		int num = 0;
			System.out.println("<본인이 올린 글 목록>");
			for(int i = 0;i < ar.size();i++) {
				if(nameSave.equals(ar.get(i).getU_ID())) {
					System.out.println(ar.get(i));
				}
			}
		
			while(true) {
				while(true) {
						System.out.print("* 삭제할 글 번호 : ");
						try {
							num = scan.nextInt();
							scan.nextLine();
							break;
						}
						catch(InputMismatchException ex) {
							System.out.println("숫자입력하세요");
							scan.nextLine();
						}
				}
				if (dao.myWritingEdit(num)==null) {
					System.out.println("[알림] 없는 글 번호입니다. 다시 입력해주세요.");
					break;
				}		
				DTBoard bo = new DTBoard(num, nameSave);
				cnt = dao.deleteMyWriting(bo);	
				if(cnt == 0) {
					System.out.println("[알림] 삭제에 실패하였습니다. 본인 글 번호가 맞는지 확인해주세요.");
					break;
				}
				else {
					System.out.println("[알림] 삭제되었습니다.");
					return;
				}
			}	
			
			/*while(true) {
				System.out.print("* 삭제할 글 번호(0 : 게시판으로 돌아가기) : ");
				try {
					num = scan.nextInt();
					scan.nextLine();
					break;
				}
				catch(InputMismatchException ex) {
					System.out.println("숫자를 입력하세요.");
					scan.nextLine();
				}
				if(num == 0) {
					return;
				}
			}
		dao.myWritingEdit(num);
		if (dao.myWritingEdit(num)==null) {
			System.out.println("[알림] 없는 글 번호입니다.");				
		}
		System.out.println(num);
		System.out.println(nameSave);
		DTBoard bo = new DTBoard(num, nameSave);
		cnt = dao.deleteMyWriting(bo);
		if(cnt == 0) {
			System.out.println("[알림] 삭제에 실패하였습니다. 본인 글 번호인지 확인해주세요.");
		}
		else {
			System.out.println("[알림] 삭제가 완료되었습니다.");
		}*/
	}

	//매니저 게시판 관리
	public int manageBoard() {
		int num;	
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│	< 게 시 판 관 리 >		│");
		System.out.println("│	1.전체 글읽기	 	│");
		System.out.println("│	2.글 검색하기		│");
		System.out.println("│	3.유저 글 삭제하기		│");
		System.out.println("│	0.프로그램 종료	 	│");
		System.out.println("└───────────────────────────────┘");
		while(true) {
		System.out.print("* 입력 : ");
		try {
		num = scan.nextInt();
		scan.nextLine();
		break;
		}
		catch(InputMismatchException ex) {
			System.out.println("숫자");
			scan.nextLine();
		}
		}
		return num;
	}
	
	//유저글 삭제하기
	public void boardDel() {
		int cnt = 1;
		ArrayList<DTBoard> ar = new ArrayList<DTBoard>();
		ar = dao.boardAll();
		for(int i = 0;i < ar.size();i++) {
			System.out.println(ar.get(i));
		}
		int num;
		while(true) {
		System.out.print("* 지울 글의 번호 : ");
		try {
			num = scan.nextInt();
			scan.nextLine();
			break;
		}
		catch(InputMismatchException ex) {
			System.out.println("숫자");
			scan.nextLine();
		}
		}
		cnt = dao.boardDel(num);
		if (cnt == 0) {
			System.out.println("[알림] 해당 번호의 글이 없어 삭제에 실패하였습니다.");
		}
		else {
			System.out.println("[알림] " + num + "번 글이 삭제되었습니다.");
		}
	}
}