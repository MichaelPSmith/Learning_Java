
public class NameGenerator {
	private static String[] syllable = {"moo", "lan", "chi", "ser", 
			"fay", "tah", "ish", "jo", "ami", "rissa", "mi", "no",
			"cho", "lo", "ri", "ah"};
	NameGenerator(){		
	}
	private static int generateRandomNum(int min, int max){
		
		int result = (int) ((Math.random() * (max - min) + min));
		
		return result;
	}
	public static String generateName(){
		String name = "";
		
		int nameLength = generateRandomNum(1,4);
		
		for(int i = 0; i < nameLength; i++){
			name += syllable[generateRandomNum(0, syllable.length)];
		}
		String nameCap = String.valueOf(Character.toUpperCase(name.charAt(0)));
		
		String finalName = (String)nameCap;
		for(int i = 1; i < name.length(); i++){
			finalName += name.charAt(i);
		}
		
		return finalName;		
	}

}