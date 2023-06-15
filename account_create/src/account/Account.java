package account;

public class Account {

	private String accountNum;
	private String ownerName;
	private int firstMoney;
	
	Account(String num, String name, int money) {
		this.accountNum = num;
		this.ownerName = name;
		this.firstMoney = money;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getFirstMoney() {
		return firstMoney;
	}

	public void setFirstMoney(int firstMoney) {
		this.firstMoney = firstMoney;
	}
	
	
	
}
