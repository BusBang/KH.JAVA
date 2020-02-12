package samsung.controller;

import java.util.Scanner;

import samsung.vo.Display;
import samsung.vo.Laptop;
import samsung.vo.Phone;
import samsung.vo.Wearable;

public class SamsungMgr {

	Display[] d = new Display[10];
	Laptop[] l = new Laptop[10];
	Phone[] p = new Phone[10];
	Wearable[] w = new Wearable[10];
	Scanner sc = new Scanner(System.in);
	Phone[] cart = new Phone[40];
	int dIndex, lIndex, pIndex, wIndex, cIndex;

	public SamsungMgr() {
		p[pIndex++] = new Phone("갤S8", 150000, 50);
		p[pIndex++] = new Phone("갤S9", 200000, 150);
		p[pIndex++] = new Phone("갤S10", 500000, 150);
		p[pIndex++] = new Phone("노트9", 500000, 150);
		p[pIndex++] = new Phone("노트10", 1000000, 200);

		d[dIndex++] = new Display("커브드", 700000, 100, "QLED", 80);
		d[dIndex++] = new Display("커브드", 700000, 70, "LED", 80);
		d[dIndex++] = new Display("커브드", 600000, 60, "QLED", 70);
		d[dIndex++] = new Display("커브드", 600000, 40, "LED", 70);
		d[dIndex++] = new Display("일반", 500000, 91, "QLED", 80);
		d[dIndex++] = new Display("일반", 400000, 88, "LED", 80);
		d[dIndex++] = new Display("일반", 400000, 150, "QLED", 70);
		d[dIndex++] = new Display("일반", 300000, 130, "LED", 70);

		l[lIndex++] = new Laptop("플렉스", 1500000, 30, 13);
		l[lIndex++] = new Laptop("플렉스", 1700000, 25, 15);
		l[lIndex++] = new Laptop("갤이온", 2000000, 33, 13);
		l[lIndex++] = new Laptop("갤이온", 2200000, 40, 15);
		l[lIndex++] = new Laptop("갤북", 1800000, 20, 13);
		l[lIndex++] = new Laptop("겔북", 2000000, 12, 15);

		w[wIndex++] = new Wearable("갤워치", 400000, 60);
		w[wIndex++] = new Wearable("갤버즈", 180000, 300);
		w[wIndex++] = new Wearable("갤핏", 100000, 250);
	}

	public void main() {
		while (true) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("-=-=-=-=-=-=삼성 디지털 프라자-=-=-=-=-=-");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("당신은 누구입니까 ? ");
			System.out.println("1. 직원");
			System.out.println("2. 고객");
			System.out.println("0. 종료하기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				staff();
				break;
			case 2:
				customer();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	// 직원 목록보기
	private void staff() {
		System.out.println();
		System.out.println("----------------");
		System.out.println("<고객제일> <최고추구> <열린신뢰>");
		System.out.println("전문성을 바탕으로 최고의 제품과 서비스를 제공하는 직원이 됩시다!");
		System.out.println();
		System.out.println("------<선택 목록>------");
		System.out.println("1. 상품 추가 하기");
		System.out.println("2. 상품 전체 보기");
		System.out.println("3. 상품 재고 변경 하기");
		System.out.println("4. 상품 삭제 하기");
		System.out.println("0. 이전화면으로");
		System.out.print("선택 >>");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			insertProduct();
			break;
		case 2:
			printPhone();
			printLaptop();
			printDisplay();
			printWearable();
			break;
		case 3:
			modifyProduct();
			break;
		case 4:
			deleteProduct();
			break;
		case 0:
			System.out.println("이전화면으로 되돌아갑니다..");
			return;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}

	// 직원 case 4 : 제품 삭제하기
    public void deleteProduct() {
        System.out.println("----<제품 삭제>----");
        System.out.println("1. 휴대폰");
        System.out.println("2. 모니터");
        System.out.println("3. 노트북");
        System.out.println("4. 웨어러블");
        System.out.println("0. 되돌아가기");
        System.out.print("삭제할 제품 카테고리 선택 >>");
        int select = sc.nextInt();
        switch(select) {
        case 1:
           printPhone();
           pIndex = deleteProduct(p,pIndex);
           break;
           
        case 2:
           printDisplay();
           dIndex = deleteProduct(d,dIndex);
           break;
        case 3:
           printLaptop();
           lIndex = deleteProduct(l,lIndex);
           break;
        case 4:
           printWearable();
           wIndex = deleteProduct(w,wIndex);
           break;
        case 0:
           return;
        }
        
     }

	// 직원 case 3 : 제품 재고 수정하기
	private void modifyProduct() {
		while (true) {
			System.out.println("-----<제품 재고 수정하기>-----");
			System.out.println("상품의 카테고리를 입력해주세요 : ");
			System.out.println("1. 휴대폰");
			System.out.println("2. 노트북");
			System.out.println("3. 모니터");
			System.out.println("4. 웨어러블");
			System.out.println("0. 이전으로");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				printPhone();
				modifyProduct(p);
				break;
			case 2:
				printLaptop();
				modifyProduct(l);
				break;
			case 3:
				printDisplay();
				modifyProduct(d);
				break;
			case 4:
				printWearable();
				modifyProduct(w);
				break;
			case 0:
				System.out.println("이전으로 되돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	private void modifyProduct(Phone[] product) {
		System.out.print("재고를 수정할 제품의 번호를 골라주세요 : ");
		int selectIndex = sc.nextInt() - 1;
		System.out.println("[" + product[selectIndex].getName() + "]제품을 선택하였습니다.");
		System.out.println(
				"현재 [" + product[selectIndex].getName() + "]제품의 재고는 " + product[selectIndex].getStock() + "개 입니다. ");
		System.out.print("수정값 입력 : ");
		int modifyNumber = sc.nextInt();
		product[selectIndex].setStock(modifyNumber);
		System.out.println("변경이 완료되었습니다.");
	}

	// 직원 case 2 : 제품 목록 보기

	// 직원 case 1 : 제품 추가하기
	private void insertProduct() {
		System.out.println("------<제품 추가하기>------");
		System.out.println("상품의 카테고리를 입력해주세요 : ");
		System.out.println("1. 휴대폰");
		System.out.println("2. 노트북");
		System.out.println("3. 모니터");
		System.out.println("4. 웨어러블");
		System.out.println("0. 이전으로");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		System.out.print("상품명을 입력해주세요 : ");
		String newName = sc.next();
		System.out.print("상품의 가격을 입력해주세요 : ");
		int newPrice = sc.nextInt();
		System.out.print("상품의 수량을 입력해주세요 : ");
		int newStock = sc.nextInt();
		switch (select) {
		case 1:// 휴대폰 추가
			p[pIndex++] = new Phone(newName, newPrice, newStock);
			break;
		case 2:// 노트북추가
			System.out.print("상품의 화면크기를 입력해주세요 (inch) : ");
			int newWide = sc.nextInt();
			l[lIndex++] = new Laptop(newName, newPrice, newStock, newWide);
			break;
		case 3: // 모니터 추가
			System.out.print("상품의 화질을 입력해주세요 [QLED / LED] : ");
			String newDepth = sc.next().toUpperCase();
			System.out.print("상품의 화면크기를 입력해주세요 (ince) : ");
			int newWide2 = sc.nextInt();
			d[dIndex++] = new Display(newName, newPrice, newStock, newDepth, newWide2);
			break;
		case 4:// 웨어러블 추가
			w[wIndex++] = new Wearable(newName, newPrice, newStock);
			break;
		case 0:
			System.out.println("이전으로 되돌아갑니다");
			return;
		}
	}

	// Customer
	public void customer() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("고객과 함께하는 No.1 전자 전문 유통 삼성 디지털플라자");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		while (true) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1. 쇼핑하기");
			System.out.println("2. 장바구니 보기");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				shopping();
				break;
			case 2:
				shoppingList();
				break;
			case 0:
				return;
			}
		}
	}

	public void shopping() {
		while (true) {
			System.out.println("====쇼핑하기====");
			System.out.println("1. 휴대폰");
			System.out.println("2. 노트북");
			System.out.println("3. 모니터");
			System.out.println("4. 웨어러블");
			System.out.println("0. 이전으로");
			System.out.print("구매할 제품 카테고리를 선택하세요 > ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				printPhone();
				buying(p);
				break;
			case 2:
				printLaptop();
				buying(l);
				break;
			case 3:
				printDisplay();
				buying(d);
				break;
			case 4:
				printWearable();
				buying(w);
				break;
			case 0:
				return;
			}
		}
	}

	public void buying(Phone[] product) {
		System.out.print("구매할 제품 번호 입력 : ");
		int index = sc.nextInt() - 1;
		System.out.println("구매할 제품의 개수를 입력해주세요 (입력 가능 개수 <=" + product[index].getStock() + ")");
		System.out.print("개수 입력 : ");
		int count = sc.nextInt();
		if (product[index].getStock() < count) {
			System.out.println("현재 재고량보다 많은 개수를 입력하셨습니다.");
			System.out.println("이전메뉴로 돌아갑니다.");
			return;
		}
		System.out.println("[" + product[index].getName() + "] 제품" + count + "개를 선택하셨습니다.");
		System.out.print("장바구니에 담으시겠습니까 [y/n]? : ");
		char sel = sc.next().charAt(0);
		if (sel == 'y') {
			// 상품이름, 가격, 재고
			int price = product[index].getPrice();
			int stock = count;
			String name = product[index].getName();
			cart[cIndex++] = new Phone(name, price, stock);
			product[index].setStock(product[index].getStock() - count);
			System.out.println("장바구니에 담겼습니다.");
		}
	}

	// Customer shoppintList
	public void shoppingList() {
		System.out.println("=====고객님의 장바구니입니다=====");
		System.out.println("제품명\t가격\t수량");
		int totalPrice = 0;
		for (int i = 0; i < cIndex; i++) {
			System.out.println(cart[i].getName() + "\t" + cart[i].getPrice() + "\t" + cart[i].getStock());
			totalPrice += cart[i].getPrice() * cart[i].getStock();
		}
		System.out.println("=================================");
		System.out.println("고객님의 총 구매 예정 금액은... \n" + totalPrice + "원 입니다.");
	}

	// 제품 목록보기
	public void printPhone() {
		System.out.println("----------휴대폰----------");
		System.out.println("No\t이름\t가격\t수량");
		for (int i = 0; i < pIndex; i++) {
			System.out.println((i + 1) + "\t" + p[i].getName() + "\t" + p[i].getPrice() + "\t" + p[i].getStock());
		}
	}

	public void printDisplay() {
		System.out.println("----------모니터----------");
		System.out.println("No\t이름\t가격\t수량\t화질\t인치");
		for (int i = 0; i < dIndex; i++) {
			System.out.println((i + 1) + "\t" + d[i].getName() + "\t" + d[i].getPrice() + "\t" + d[i].getStock() + "\t"
					+ d[i].getDepth() + "\t" + d[i].getWide());
		}
	}

	public void printLaptop() {
		System.out.println("----------노트북----------");
		System.out.println("No\t이름\t가격\t수량\t인치");
		for (int i = 0; i < lIndex; i++) {
			System.out.println((i + 1) + "\t" + l[i].getName() + "\t" + l[i].getPrice() + "\t" + l[i].getStock() + "\t"
					+ l[i].getWide());
		}
	}

	public void printWearable() {
		System.out.println("---------웨어러블---------");
		System.out.println("No\t이름\t가격\t수량");
		for (int i = 0; i < wIndex; i++) {
			System.out.println((i + 1) + "\t" + w[i].getName() + "\t" + w[i].getPrice() + "\t" + w[i].getStock());
		}
	}

	// 삭제작업
	public int deleteProduct(Phone[] product, int categoryIndex) {
		System.out.println("삭제할 제품의 번호를 입력하세요 : ");
		int num = sc.nextInt() - 1;
		System.out.println("[" + product[num].getName() + "] 을 선택하셨습니다.");
		System.out.print("정말 삭제하시겠습니까 ?? [y/n]");
		char ch = sc.next().charAt(0);
		if (ch == 'y') {
			for (int i = num; i < categoryIndex - 1; i++) {
				product[i] = product[i + 1];
			}
			product[categoryIndex - 1] = null;
			categoryIndex--;
		} else {
			System.out.println("삭제작업 취소");
		}
		return categoryIndex;
	}
}
