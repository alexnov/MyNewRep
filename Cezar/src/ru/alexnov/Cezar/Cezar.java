package ru.alexnov.Cezar;

public class Cezar {
	
	//����������
	public static String cezarCypher(String source, int slide){
		int[] num = stringToInt(source);
		int[] numShear = criptText(num, slide);
		String rez = numToString(numShear);
		return rez;
	}
	
	
	//����� ������� �� �������� ��������
	private static int[] criptText(int[] numbers, int slide){
		int[] cyphers = new int[numbers.length];
		for (int i = 0; i<numbers.length; i++){
			cyphers[i] = addModule(numbers[i], slide, 33);
		}
		return cyphers;
	}
	
	//�������������� ������� ����� � ������
	private static String numToString(int[] numbers){
		char[] array = new char[numbers.length];
		for (int i = 0; i<numbers.length; i++){
			array[i] = intToChar(numbers[i]);
		}
		String str = new String(array);
		return str;
	}
	
	//�������������� ������ � ������ ����� �����
	private static int[] stringToInt(String str){
		String str2 = str.replaceAll(" ", "");
		char[] sarray = str2.toCharArray();
		int[] numbers = new int[str2.length()];
		for (int i=0; i<str2.length(); i++){
			numbers[i] = charToInt(sarray[i]);
		}
		
		return numbers;
	}
	
	//�������������� ������� � �����
	private static int charToInt(char s){
		switch (s){
		case '�':
			return 1;
		case '�':
			return 2;
		case '�':
			return 3;
		case '�':
			return 4;
		case '�':
			return 5;
		case '�':
			return 6;
		case '�':
			return 7;
		case '�':
			return 8;
		case '�':
			return 9;
		case '�':
			return 10;
		case '�':
			return 11;
		case '�':
			return 12;
		case '�':
			return 13;
		case '�':
			return 14;
		case '�':
			return 15;
		case '�':
			return 16;
		case '�':
			return 17;
		case '�':
			return 18;
		case '�':
			return 19;
		case '�':
			return 20;
		case '�':
			return 21;
		case '�':
			return 22;
		case '�':
			return 23;
		case '�':
			return 24;
		case '�':
			return 25;
		case '�':
			return 26;
		case '�':
			return 27;
		case '�':
			return 28;
		case '�':
			return 29;
		case '�':
			return 30;
		case '�':
			return 31;
		case '�':
			return 32;
		case '�':
			return 33;
		default:
			return 0;
		}
	}
	//�������������� ����� � ������
		private static char intToChar(int n){
			switch (n){
			case 1:
				return '�';
			case 2:
				return '�';
			case 3:
				return '�';
			case 4:
				return '�';
			case 5:
				return '�';
			case 6:
				return '�';
			case 7:
				return '�';
			case 8:
				return '�';
			case 9:
				return '�';
			case 10:
				return '�';
			case 11:
				return '�';
			case 12:
				return '�';
			case 13:
				return '�';
			case 14:
				return '�';
			case 15:
				return '�';
			case 16:
				return '�';
			case 17:
				return '�';
			case 18:
				return'�';
			case 19:
				return '�';
			case 20:
				return '�';
			case 21:
				return '�';
			case 22:
				return '�';
			case 23:
				return '�';
			case 24:
				return '�';
			case 25:
				return '�';
			case 26:
				return '�';
			case 27:
				return '�';
			case 28:
				return '�';
			case 29:
				return '�';
			case 30:
				return '�';
			case 31:
				return '�';
			case 32:
				return '�';
			case 33:
				return '�';
			default:
				return ' ';
			}
		}
	//�������� �� ������ (��� �������� ������������ ���������)
	private static int addModule(int a, int b, int mod){
		int res = a + b;
		if (res > mod){
			res = res - mod;
		}
		return res;
	}

}
