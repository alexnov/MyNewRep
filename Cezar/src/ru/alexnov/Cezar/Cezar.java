package ru.alexnov.Cezar;

public class Cezar {
	
	//Ўифрование
	public static String cezarCypher(String source, int slide){
		int[] num = stringToInt(source);
		int[] numShear = criptText(num, slide);
		String rez = numToString(numShear);
		return rez;
	}
	
	
	//—двиг массива на заданную величину
	private static int[] criptText(int[] numbers, int slide){
		int[] cyphers = new int[numbers.length];
		for (int i = 0; i<numbers.length; i++){
			cyphers[i] = addModule(numbers[i], slide, 33);
		}
		return cyphers;
	}
	
	//преобразование массива чисел в строку
	private static String numToString(int[] numbers){
		char[] array = new char[numbers.length];
		for (int i = 0; i<numbers.length; i++){
			array[i] = intToChar(numbers[i]);
		}
		String str = new String(array);
		return str;
	}
	
	//преобразование строки в массив целых чисел
	private static int[] stringToInt(String str){
		String str2 = str.replaceAll(" ", "");
		char[] sarray = str2.toCharArray();
		int[] numbers = new int[str2.length()];
		for (int i=0; i<str2.length(); i++){
			numbers[i] = charToInt(sarray[i]);
		}
		
		return numbers;
	}
	
	//преобразование символа в число
	private static int charToInt(char s){
		switch (s){
		case 'а':
			return 1;
		case 'б':
			return 2;
		case 'в':
			return 3;
		case 'г':
			return 4;
		case 'д':
			return 5;
		case 'е':
			return 6;
		case 'Є':
			return 7;
		case 'ж':
			return 8;
		case 'з':
			return 9;
		case 'и':
			return 10;
		case 'й':
			return 11;
		case 'к':
			return 12;
		case 'л':
			return 13;
		case 'м':
			return 14;
		case 'н':
			return 15;
		case 'о':
			return 16;
		case 'п':
			return 17;
		case 'р':
			return 18;
		case 'с':
			return 19;
		case 'т':
			return 20;
		case 'у':
			return 21;
		case 'ф':
			return 22;
		case 'х':
			return 23;
		case 'ц':
			return 24;
		case 'ч':
			return 25;
		case 'ш':
			return 26;
		case 'щ':
			return 27;
		case 'ь':
			return 28;
		case 'ы':
			return 29;
		case 'ъ':
			return 30;
		case 'э':
			return 31;
		case 'ю':
			return 32;
		case '€':
			return 33;
		default:
			return 0;
		}
	}
	//преобразование числа в символ
		private static char intToChar(int n){
			switch (n){
			case 1:
				return 'а';
			case 2:
				return 'б';
			case 3:
				return 'в';
			case 4:
				return 'г';
			case 5:
				return 'д';
			case 6:
				return 'е';
			case 7:
				return 'Є';
			case 8:
				return 'ж';
			case 9:
				return 'з';
			case 10:
				return 'и';
			case 11:
				return 'й';
			case 12:
				return 'к';
			case 13:
				return 'л';
			case 14:
				return 'м';
			case 15:
				return 'н';
			case 16:
				return 'о';
			case 17:
				return 'п';
			case 18:
				return'р';
			case 19:
				return 'с';
			case 20:
				return 'т';
			case 21:
				return 'у';
			case 22:
				return 'ф';
			case 23:
				return 'х';
			case 24:
				return 'ц';
			case 25:
				return 'ч';
			case 26:
				return 'ш';
			case 27:
				return 'щ';
			case 28:
				return 'ь';
			case 29:
				return 'ы';
			case 30:
				return 'ъ';
			case 31:
				return 'э';
			case 32:
				return 'ю';
			case 33:
				return '€';
			default:
				return ' ';
			}
		}
	//—ложение по модулю (без проверки правильности слагаемых)
	private static int addModule(int a, int b, int mod){
		int res = a + b;
		if (res > mod){
			res = res - mod;
		}
		return res;
	}

}
