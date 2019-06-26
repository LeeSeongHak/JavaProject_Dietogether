package DT.vo;

public class DTExercise {
	private int exerciseinfo_num;
	private String exerciseinfo_name;
	private String exerciseinfo_consum;
	
	public DTExercise() {
		
	}
	
	public DTExercise(String name, String consum) {
		this.exerciseinfo_name = name;
		this.exerciseinfo_consum = consum;
	}

	public int getExerciseinfo_num() {
		return exerciseinfo_num;
	}

	public void setExerciseinfo_num(int exerciseinfo_num) {
		this.exerciseinfo_num = exerciseinfo_num;
	}

	public String getExerciseinfo_name() {
		return exerciseinfo_name;
	}

	public void setExerciseinfo_name(String exerciseinfo_name) {
		this.exerciseinfo_name = exerciseinfo_name;
	}

	public String getExerciseinfo_consum() {
		return exerciseinfo_consum;
	}

	public void setExerciseinfo_consum(String exerciseinfo_consum) {
		this.exerciseinfo_consum = exerciseinfo_consum;
	}

	@Override
	public String toString() {
		return exerciseinfo_name + " || Ä®·Î¸® -> " + exerciseinfo_consum;		
	}
}
