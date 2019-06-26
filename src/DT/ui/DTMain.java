package DT.ui;

public class DTMain {
	
	public static void main(String[] args) {
		DTUI ui = new DTUI();
		boolean b;
		while(true){
			int n = ui.loginMenu();
			switch(n) {
			case 1 : {
				b = ui.login();
				if(b == true) {
					Menu();					
				}
				break;
			}
			case 2 : ui.join(); break;
			case 9 : {
				b = ui.managerLogin();
				if(b == true) {
					manager();
				}
			}
			break;
			case 0 : ui.exit(); return;		
			}
		}

	}

	public static void manager() {
		DTUI ui = new DTUI();
		while(true){
			int n = ui.managerMenu();
			switch(n) {
			case 1 : ui.selectUserInfo(); break;
			case 2 : ui.allFoodInfo(); break;
			case 3 : ui.allExercise(); break;
			case 4 : ui.foodAdd(); break;
			case 5 : ui.exerciseAdd(); break;
			case 6 : ui.userSearch(); break;
			case 7 : ui.userBan(); break;
			case 8 : manageBoard(); break;
			case 0 : ui.m_exit(); return;		
			}
		}
	}
	
	public static void Menu() {
		DTUI ui = new DTUI();
		while(true) {
			int n = ui.Menu();
			switch(n) {
			case 1 : ui.foodSearch(); break;
			case 2 : ui.exerciseInfo(); break;
			case 3 : ui.bmi(); break;
			case 4 : Board(); break;
			case 0 : System.out.println("로그인 화면으로 돌아갑니다."); return;
			}
		}
	}
	
	public static void Board() {
		DTUI ui = new DTUI();
		while(true) {
			int n = ui.Board();
			switch(n) {
			case 1 : ui.boardWrite(); break;
			case 2 : ui.boardAll(); break;
			case 3 : ui.myBoard(); break;
			case 4 : ui.boardSearch(); break;
			case 5 : ui.myWritingEdit(); break;
			case 6 : ui.myWritingDel(); break;
			case 0 : System.out.println("프로그램을 종료합니다"); System.exit(0);
			}
		}
	}
	
	public static void manageBoard() {
		DTUI ui = new DTUI();
		while(true) {
			int n = ui.manageBoard();
			switch(n) {
			case 1 : ui.boardAll(); break;
			case 2 : ui.boardSearch(); break;
			case 3 : ui.boardDel(); break;
			case 0 : System.out.println("프로그램을 종료합니다."); System.exit(0);
			}
		}
	}
	
	
	
}