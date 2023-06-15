package account;

import java.util.Scanner;

public class BankApplication {
	
	private static Scanner sc = new Scanner(System.in);
	private static Account[] arr = new Account[100];
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택> ");
			int choiceNum = sc.nextInt();
			
			if(choiceNum==1) {
				create();
			}
			else if(choiceNum==2) {
				list();
			}
			else if(choiceNum==3) {
				deposit();
			}
			else if(choiceNum==4) {
				withdraw();
			}
			else if(choiceNum==5) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	//1.계좌생성
	private static void create() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String num = sc.next();
		System.out.print("계좌주: ");
		String name = sc.next();
		System.out.println("초기입금액: ");
		int money = sc.nextInt();
		
		Account ac = new Account (num,name,money);
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==null) {
				arr[i]=ac;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	//2.계좌목록
	private static void list() {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		
		for(int i=0;i<arr.length;i++) {
			Account ac = arr[i];
			if(ac != null) {
				System.out.print(ac.getAccountNum());
				System.out.print(" ");
				System.out.print(ac.getOwnerName());
				System.out.print(" ");
				System.out.println(ac.getFirstMoney());
				System.out.println(" ");
			}
		}
	}
	//3.입금
	private static void deposit() {
		System.out.println("------");
		System.out.println("예금");
		System.out.println("-------");
		System.out.print("계좌번호: ");
		String num = sc.next();
		System.out.print("예금액: ");
		int inputMoney = sc.nextInt();
		
		Account ac = findAccount(num);
		
		if(ac==null) {
			System.out.println("계좌가 없습니다.");
			return;
		}
		ac.setFirstMoney(ac.getFirstMoney()+inputMoney);
	}
	//계좌 찾기
	private static Account findAccount(String num) {
		Account ac = null;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null) {
				String inputNum = arr[i].getAccountNum();
				if(inputNum.equals(num)) {
					ac = arr[i];
					break;
				}
			}
		}
		return ac;
	}
	//4.출금
	private static void withdraw() {
		System.out.println("------");
		System.out.println("출금");
		System.out.println("------");
		System.out.print("계좌번호: ");
		String num = sc.next();
		System.out.print("출금액: ");
		int outputMoney = sc.nextInt();
		
		Account ac = findAccount(num);
		
		if(ac == null) {
			System.out.println("일치하는 계좌가 없습니다.");
			return;
		}
		System.out.println("결과: 출금이 성공되었습니다.");
		ac.setFirstMoney(ac.getFirstMoney()-outputMoney);
	}

}
