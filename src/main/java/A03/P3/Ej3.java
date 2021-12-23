package A03.P3;

import java.io.IOException;

public class Ej3 {
	static int [][] FUNCTIONAL_MATRIX = {{0,0,0},{1,1,2},{2,1,2},{2,2,3},{3,3,4},{4,5,5}};
	static int [][] MAINTAINABILITY_MATRIX = {{0,0,0,0,0},{1,1,0,1,1},{2,2,1,2,1},{2,2,2,3,2},{3,3,3,4,4},{4,5,5,5,4}};
	static int [][] ADECUATION_FUNCTIONAL_MATRIX = {{1,1,1,1,1},{1,2,2,2,2},{2,2,3,3,3},{3,3,3,3,4},{3,3,4,4,5}};
	static int [] functional_input = {0,0,0};
	static int [] maintainability_input = {0,0,0,0,0};
	public static void main(String[] args) {
		try {
			int completeness_value = get_Value (FUNCTIONAL_MATRIX, functional_input[0], 0);
			int correcteness_value = get_Value (FUNCTIONAL_MATRIX, functional_input[1], 1);
			int appropiateness_value = get_Value (FUNCTIONAL_MATRIX, functional_input[2], 2);
			int min_functional = calculate_min_functional (completeness_value, correcteness_value, appropiateness_value);
			int modularity_value = get_Value (MAINTAINABILITY_MATRIX, maintainability_input[0], 0);
			int reusability_value = get_Value (MAINTAINABILITY_MATRIX, maintainability_input[1], 1);
			int analyzability_value = get_Value (MAINTAINABILITY_MATRIX, maintainability_input[2], 2);
			int modified_value = get_Value (MAINTAINABILITY_MATRIX, maintainability_input[3], 3);
			int tested_value = get_Value (MAINTAINABILITY_MATRIX, maintainability_input[4], 4);
			int min_maintainability = calculate_min_maintainability (modularity_value, reusability_value, analyzability_value, modified_value, tested_value);
			int value_adecuational_functional = ADECUATION_FUNCTIONAL_MATRIX [min_functional][min_maintainability];
			System.out.println(value_adecuational_functional);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static int calculate_min_functional (int completeness_value, int correcteness_value, int appropiateness_value) {
		return Math.min(Math.min(correcteness_value, appropiateness_value), appropiateness_value);
	}

	public static int calculate_min_maintainability (int modularity_value, int reusability_value, int analyzability_value, int modified_value, int tested_value) {
		return Math.min(Math.min(reusability_value, analyzability_value), Math.min(modified_value, Math.min(tested_value, modularity_value)));
	}
	
	public static int get_Value (int [][] matrix, int input, int type) throws IOException {
		int range = get_range(input);
		int value = matrix[range][type];
		return value;
	}
	
	public static int get_range (int input) throws IOException {
		int range = 0;
		if (input < 0 || input > 100) {
			throw new IOException("Range must be from 0 to 100");
		} else if (input < 10) {
			range = 0;	
		} else if (input < 35) {
			range = 1;
		} else if (input < 50) {
			range = 2;
		} else if (input < 70) {
			range = 3;
		} else if (input < 90) {
			range = 4;
		} else {
			range = 5;
		}
		return range;
	}
}
