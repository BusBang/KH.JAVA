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
		p[pIndex++] = new Phone("��S8", 150000, 50);
		p[pIndex++] = new Phone("��S9", 200000, 150);
		p[pIndex++] = new Phone("��S10", 500000, 150);
		p[pIndex++] = new Phone("��Ʈ9", 500000, 150);
		p[pIndex++] = new Phone("��Ʈ10", 1000000, 200);

		d[dIndex++] = new Display("Ŀ���", 700000, 100, "QLED", 80);
		d[dIndex++] = new Display("Ŀ���", 700000, 70, "LED", 80);
		d[dIndex++] = new Display("Ŀ���", 600000, 60, "QLED", 70);
		d[dIndex++] = new Display("Ŀ���", 600000, 40, "LED", 70);
		d[dIndex++] = new Display("�Ϲ�", 500000, 91, "QLED", 80);
		d[dIndex++] = new Display("�Ϲ�", 400000, 88, "LED", 80);
		d[dIndex++] = new Display("�Ϲ�", 400000, 150, "QLED", 70);
		d[dIndex++] = new Display("�Ϲ�", 300000, 130, "LED", 70);

		l[lIndex++] = new Laptop("�÷���", 1500000, 30, 13);
		l[lIndex++] = new Laptop("�÷���", 1700000, 25, 15);
		l[lIndex++] = new Laptop("���̿�", 2000000, 33, 13);
		l[lIndex++] = new Laptop("���̿�", 2200000, 40, 15);
		l[lIndex++] = new Laptop("����", 1800000, 20, 13);
		l[lIndex++] = new Laptop("�ֺ�", 2000000, 12, 15);

		w[wIndex++] = new Wearable("����ġ", 400000, 60);
		w[wIndex++] = new Wearable("������", 180000, 300);
		w[wIndex++] = new Wearable("����", 100000, 250);
	}

	public void main() {
		while (true) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("-=-=-=-=-=-=�Ｚ ������ ������-=-=-=-=-=-");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("����� �����Դϱ� ? ");
			System.out.println("1. ����");
			System.out.println("2. ��");
			System.out.println("0. �����ϱ�");
			System.out.print("���� >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				staff();
				break;
			case 2:
				customer();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	// ���� ��Ϻ���
	private void staff() {
		System.out.println();
		System.out.println("----------------");
		System.out.println("<������> <�ְ��߱�> <�����ŷ�>");
		System.out.println("�������� �������� �ְ��� ��ǰ�� ���񽺸� �����ϴ� ������ �˽ô�!");
		System.out.println();
		System.out.println("------<���� ���>------");
		System.out.println("1. ��ǰ �߰� �ϱ�");
		System.out.println("2. ��ǰ ��ü ����");
		System.out.println("3. ��ǰ ��� ���� �ϱ�");
		System.out.println("4. ��ǰ ���� �ϱ�");
		System.out.println("0. ����ȭ������");
		System.out.print("���� >>");
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
			System.out.println("����ȭ������ �ǵ��ư��ϴ�..");
			return;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
		}
	}

	// ���� case 4 : ��ǰ �����ϱ�
    public void deleteProduct() {
        System.out.println("----<��ǰ ����>----");
        System.out.println("1. �޴���");
        System.out.println("2. �����");
        System.out.println("3. ��Ʈ��");
        System.out.println("4. �����");
        System.out.println("0. �ǵ��ư���");
        System.out.print("������ ��ǰ ī�װ� ���� >>");
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

	// ���� case 3 : ��ǰ ��� �����ϱ�
	private void modifyProduct() {
		while (true) {
			System.out.println("-----<��ǰ ��� �����ϱ�>-----");
			System.out.println("��ǰ�� ī�װ��� �Է����ּ��� : ");
			System.out.println("1. �޴���");
			System.out.println("2. ��Ʈ��");
			System.out.println("3. �����");
			System.out.println("4. �����");
			System.out.println("0. ��������");
			System.out.print("���� >> ");
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
				System.out.println("�������� �ǵ��ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	private void modifyProduct(Phone[] product) {
		System.out.print("��� ������ ��ǰ�� ��ȣ�� ����ּ��� : ");
		int selectIndex = sc.nextInt() - 1;
		System.out.println("[" + product[selectIndex].getName() + "]��ǰ�� �����Ͽ����ϴ�.");
		System.out.println(
				"���� [" + product[selectIndex].getName() + "]��ǰ�� ���� " + product[selectIndex].getStock() + "�� �Դϴ�. ");
		System.out.print("������ �Է� : ");
		int modifyNumber = sc.nextInt();
		product[selectIndex].setStock(modifyNumber);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}

	// ���� case 2 : ��ǰ ��� ����

	// ���� case 1 : ��ǰ �߰��ϱ�
	private void insertProduct() {
		System.out.println("------<��ǰ �߰��ϱ�>------");
		System.out.println("��ǰ�� ī�װ��� �Է����ּ��� : ");
		System.out.println("1. �޴���");
		System.out.println("2. ��Ʈ��");
		System.out.println("3. �����");
		System.out.println("4. �����");
		System.out.println("0. ��������");
		System.out.print("���� >> ");
		int select = sc.nextInt();
		System.out.print("��ǰ���� �Է����ּ��� : ");
		String newName = sc.next();
		System.out.print("��ǰ�� ������ �Է����ּ��� : ");
		int newPrice = sc.nextInt();
		System.out.print("��ǰ�� ������ �Է����ּ��� : ");
		int newStock = sc.nextInt();
		switch (select) {
		case 1:// �޴��� �߰�
			p[pIndex++] = new Phone(newName, newPrice, newStock);
			break;
		case 2:// ��Ʈ���߰�
			System.out.print("��ǰ�� ȭ��ũ�⸦ �Է����ּ��� (inch) : ");
			int newWide = sc.nextInt();
			l[lIndex++] = new Laptop(newName, newPrice, newStock, newWide);
			break;
		case 3: // ����� �߰�
			System.out.print("��ǰ�� ȭ���� �Է����ּ��� [QLED / LED] : ");
			String newDepth = sc.next().toUpperCase();
			System.out.print("��ǰ�� ȭ��ũ�⸦ �Է����ּ��� (ince) : ");
			int newWide2 = sc.nextInt();
			d[dIndex++] = new Display(newName, newPrice, newStock, newDepth, newWide2);
			break;
		case 4:// ����� �߰�
			w[wIndex++] = new Wearable(newName, newPrice, newStock);
			break;
		case 0:
			System.out.println("�������� �ǵ��ư��ϴ�");
			return;
		}
	}

	// Customer
	public void customer() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("���� �Բ��ϴ� No.1 ���� ���� ���� �Ｚ �������ö���");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		while (true) {
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.println("1. �����ϱ�");
			System.out.println("2. ��ٱ��� ����");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
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
			System.out.println("====�����ϱ�====");
			System.out.println("1. �޴���");
			System.out.println("2. ��Ʈ��");
			System.out.println("3. �����");
			System.out.println("4. �����");
			System.out.println("0. ��������");
			System.out.print("������ ��ǰ ī�װ��� �����ϼ��� > ");
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
		System.out.print("������ ��ǰ ��ȣ �Է� : ");
		int index = sc.nextInt() - 1;
		System.out.println("������ ��ǰ�� ������ �Է����ּ��� (�Է� ���� ���� <=" + product[index].getStock() + ")");
		System.out.print("���� �Է� : ");
		int count = sc.nextInt();
		if (product[index].getStock() < count) {
			System.out.println("���� ������� ���� ������ �Է��ϼ̽��ϴ�.");
			System.out.println("�����޴��� ���ư��ϴ�.");
			return;
		}
		System.out.println("[" + product[index].getName() + "] ��ǰ" + count + "���� �����ϼ̽��ϴ�.");
		System.out.print("��ٱ��Ͽ� �����ðڽ��ϱ� [y/n]? : ");
		char sel = sc.next().charAt(0);
		if (sel == 'y') {
			// ��ǰ�̸�, ����, ���
			int price = product[index].getPrice();
			int stock = count;
			String name = product[index].getName();
			cart[cIndex++] = new Phone(name, price, stock);
			product[index].setStock(product[index].getStock() - count);
			System.out.println("��ٱ��Ͽ� �����ϴ�.");
		}
	}

	// Customer shoppintList
	public void shoppingList() {
		System.out.println("=====������ ��ٱ����Դϴ�=====");
		System.out.println("��ǰ��\t����\t����");
		int totalPrice = 0;
		for (int i = 0; i < cIndex; i++) {
			System.out.println(cart[i].getName() + "\t" + cart[i].getPrice() + "\t" + cart[i].getStock());
			totalPrice += cart[i].getPrice() * cart[i].getStock();
		}
		System.out.println("=================================");
		System.out.println("������ �� ���� ���� �ݾ���... \n" + totalPrice + "�� �Դϴ�.");
	}

	// ��ǰ ��Ϻ���
	public void printPhone() {
		System.out.println("----------�޴���----------");
		System.out.println("No\t�̸�\t����\t����");
		for (int i = 0; i < pIndex; i++) {
			System.out.println((i + 1) + "\t" + p[i].getName() + "\t" + p[i].getPrice() + "\t" + p[i].getStock());
		}
	}

	public void printDisplay() {
		System.out.println("----------�����----------");
		System.out.println("No\t�̸�\t����\t����\tȭ��\t��ġ");
		for (int i = 0; i < dIndex; i++) {
			System.out.println((i + 1) + "\t" + d[i].getName() + "\t" + d[i].getPrice() + "\t" + d[i].getStock() + "\t"
					+ d[i].getDepth() + "\t" + d[i].getWide());
		}
	}

	public void printLaptop() {
		System.out.println("----------��Ʈ��----------");
		System.out.println("No\t�̸�\t����\t����\t��ġ");
		for (int i = 0; i < lIndex; i++) {
			System.out.println((i + 1) + "\t" + l[i].getName() + "\t" + l[i].getPrice() + "\t" + l[i].getStock() + "\t"
					+ l[i].getWide());
		}
	}

	public void printWearable() {
		System.out.println("---------�����---------");
		System.out.println("No\t�̸�\t����\t����");
		for (int i = 0; i < wIndex; i++) {
			System.out.println((i + 1) + "\t" + w[i].getName() + "\t" + w[i].getPrice() + "\t" + w[i].getStock());
		}
	}

	// �����۾�
	public int deleteProduct(Phone[] product, int categoryIndex) {
		System.out.println("������ ��ǰ�� ��ȣ�� �Է��ϼ��� : ");
		int num = sc.nextInt() - 1;
		System.out.println("[" + product[num].getName() + "] �� �����ϼ̽��ϴ�.");
		System.out.print("���� �����Ͻðڽ��ϱ� ?? [y/n]");
		char ch = sc.next().charAt(0);
		if (ch == 'y') {
			for (int i = num; i < categoryIndex - 1; i++) {
				product[i] = product[i + 1];
			}
			product[categoryIndex - 1] = null;
			categoryIndex--;
		} else {
			System.out.println("�����۾� ���");
		}
		return categoryIndex;
	}
}
