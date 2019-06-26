package DT.vo;

public class DTVO {
	private int foodinfo_num;
	private String foodinfo_foodname;
	private String foodinfo_calorie;
	private int c_num;
	
	public DTVO() {
		
	}
	
	public DTVO(String food, int category) {
		this.c_num = category;
		this.foodinfo_foodname = food;
	}
	
	public DTVO(int c_num, String name, String kcal) {
		this.c_num = c_num;
		this.foodinfo_foodname = name;
		this.foodinfo_calorie = kcal;
	}

	public int getFoodinfo_num() {
		return foodinfo_num;
	}

	public void setFoodinfo_num(int foodinfo_num) {
		this.foodinfo_num = foodinfo_num;
	}

	public String getFoodinfo_foodname() {
		return foodinfo_foodname;
	}

	public void setFoodinfo_foodname(String foodinfo_foodname) {
		this.foodinfo_foodname = foodinfo_foodname;
	}

	public String getFoodinfo_calorie() {
		return foodinfo_calorie;
	}

	public void setFoodinfo_calorie(String foodinfo_calorie) {
		this.foodinfo_calorie = foodinfo_calorie;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	@Override
	public String toString() {
		return foodinfo_foodname + " || Ä®·Î¸® -> " + foodinfo_calorie;
	}
	
	
}
