package DT.vo;

public class DTBoard {
	private int DTBOARD_NUM;
	private String U_ID;
	private String DTBOARD_TITLE;
	private String DTBOARD_CONTENT;
	private String DTBOARD_INPUTDATE;
	
	public DTBoard() {
		
	}
	
	public DTBoard(int DTBOARD_NUM, String U_ID) {
		this.DTBOARD_NUM = DTBOARD_NUM;
		this.U_ID = U_ID;
	}
	
	public DTBoard(String U_ID, String DTBOARD_TITLE, String DTBOARD_CONTENT) {
		this.U_ID = U_ID;
		this.DTBOARD_TITLE = DTBOARD_TITLE;
		this.DTBOARD_CONTENT = DTBOARD_CONTENT;
	}
	
	public DTBoard(int DTBOARD_NUM, String U_ID, String DTBOARD_TITLE, String DTBOARD_CONTENT) {
		this.DTBOARD_NUM = DTBOARD_NUM;
		this.U_ID = U_ID;
		this.DTBOARD_TITLE = DTBOARD_TITLE;
		this.DTBOARD_CONTENT = DTBOARD_CONTENT;
	}
	
	public DTBoard(String U_ID, String DTBOARD_TITLE, String DTBOARD_CONTENT, String DTBOARD_INPUTDATE) {
		this.U_ID = U_ID;
		this.DTBOARD_TITLE = DTBOARD_TITLE;
		this.DTBOARD_CONTENT = DTBOARD_CONTENT;
		this.DTBOARD_INPUTDATE = DTBOARD_INPUTDATE;
	}
	
	public DTBoard(int DTBOARD_NUM, String U_ID, String DTBOARD_TITLE, String DTBOARD_CONTENT, String DTBOARD_INPUTDATE) {
		this.DTBOARD_NUM = DTBOARD_NUM;
		this.U_ID = U_ID;
		this.DTBOARD_TITLE = DTBOARD_TITLE;
		this.DTBOARD_CONTENT = DTBOARD_CONTENT;
		this.DTBOARD_INPUTDATE = DTBOARD_INPUTDATE;
	}

	public int getDTBOARD_NUM() {
		return DTBOARD_NUM;
	}

	public void setDTBOARD_NUM(int dTBOARD_NUM) {
		DTBOARD_NUM = dTBOARD_NUM;
	}

	public String getU_ID() {
		return U_ID;
	}

	public void setU_ID(String u_ID) {
		U_ID = u_ID;
	}

	public String getDTBOARD_TITLE() {
		return DTBOARD_TITLE;
	}

	public void setDTBOARD_TITLE(String dTBOARD_TITLE) {
		DTBOARD_TITLE = dTBOARD_TITLE;
	}

	public String getDTBOARD_CONTENT() {
		return DTBOARD_CONTENT;
	}

	public void setDTBOARD_CONTENT(String dTBOARD_CONTENT) {
		DTBOARD_CONTENT = dTBOARD_CONTENT;
	}


	public String getDTBOARD_INPUTDATE() {
		return DTBOARD_INPUTDATE;
	}

	public void setDTBOARD_INPUTDATE(String dTBOARD_INPUTDATE) {
		DTBOARD_INPUTDATE = dTBOARD_INPUTDATE;
	}

	@Override
	public String toString() {
		return "글번호 : " + DTBOARD_NUM + " || 아이디 : " + U_ID + " || 제목 : " + DTBOARD_TITLE
				+ " || 내용 : " + DTBOARD_CONTENT + " || 등록일 : " + DTBOARD_INPUTDATE;
	}
	
	
}
