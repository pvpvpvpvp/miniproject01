

package mini.pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MiniEx {
	static final String rootPath = System.getProperty("user.dir") + "\\\\";
	static String source = rootPath + "data.txt";
	static String target = rootPath + "data.txt";
	static BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
	static List<MiniData> list = new ArrayList<MiniData>(99);
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader fr = null;

		// 보조 스트림
		BufferedReader br = null;

		fr = new FileReader(source);

		br = new BufferedReader(fr);
		
		StringTokenizer st = null;
		String[] add1 = new String[3];
		String line = "";
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line, ",");
			for (int i = 0; i < 3; i++) {
				add1[i] = st.nextToken();
			}
			for (int i = 0; i < add1.length - 2; i++) {
				MiniData a = new MiniData(add1[i], add1[i + 1], add1[i + 2]);
				list.add(a);
			}
		}
		pro: while (true) {

			System.out.println("=========================");
			System.out.println("=    전화번호 관리 프로그램   =");
			System.out.println("=========================");
			System.out.println("1,리스트 2,등록 3,삭제 4,검색 5,종료");
			int add = sc.nextInt();

			switch (add) {
			case 1:
				listOut();
				break;
			case 2:
				InputData();
				System.out.println("add");
				break;
			case 3:
				listDelete();
				break;
			case 4:
				Find();
				break;
			default:
				WriteData();
				break pro;
			}
		}
	}

	private static void WriteData() throws IOException {
		Writer fw = null;
		fw = new FileWriter(target);
		try (BufferedWriter bw = new BufferedWriter(fw)) {
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i).getName());
				bw.write(",");
				bw.write(list.get(i).getHp());
//				System.out.printf("%s,%s,%s%n",list.get(i).getName(),list.get(i).getHp(),list.get(i).getTel());
				bw.write(",");
				bw.write(list.get(i).getTel());
				bw.write("\n");
			}
		}
		System.out.println("출력완");
	}

	public static void InputData() {
		System.out.printf("<2,등록>%n이름:");
		String name = sc.next();
		System.out.printf("휴대전화:");
		String hp = sc.next();
		System.out.printf("집전화:");
		String tel = sc.next();
		MiniData mini = new MiniData(name, hp, tel); // 데이터 넣기
		list.add(mini);

	}

	public static void listOut() {
		for (int i = 0; i < list.size(); i++) {
			MiniData str = list.get(i);
			str.listout(i);
		}
	}

	public static void listDelete() {
		int Delnumber = 0;
		System.out.print("지울번호 입력하세요");
		Delnumber = sc.nextInt();
		list.remove(Delnumber - 1);// 값보정
	}

	public static void Find() { 
		System.out.print("검색 단어 입력");
		String name = sc.next();

		for (int i1 = 0; i1 < list.size(); i1++) {
			if (list.get(i1).getName().contains(name)) {
				list.get(i1).listout(i1);
			}
		}
	}
}
