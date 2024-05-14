
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Dagiac {
    private ArrayList<Dinh> danhSachDinhArrayList;
    private Dinh[] danhSachDinhArray;

    public Dagiac() {
        danhSachDinhArrayList = new ArrayList<>();
        danhSachDinhArray = new Dinh[0];
    }

    public Dagiac(ArrayList<Dinh> danhSachDinhArrayList) {
        this.danhSachDinhArrayList = danhSachDinhArrayList;
        this.danhSachDinhArray = danhSachDinhArrayList.toArray(new Dinh[0]);
    }

    public Dagiac(Dagiac daGiac) {
        this.danhSachDinhArrayList = new ArrayList<>(daGiac.danhSachDinhArrayList);
        this.danhSachDinhArray = Arrays.copyOf(daGiac.danhSachDinhArray, daGiac.danhSachDinhArray.length);
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so dinh cua da giac: ");
        int soDinh = scanner.nextInt();

        danhSachDinhArray = new Dinh[soDinh]; // Khởi tạo mảng với số phần tử là soDinh

        for (int i = 0; i < soDinh; i++) {
            System.out.print("Nhap toa do x cua dinh thu " + (i + 1) + ": ");
            double x = scanner.nextDouble();
            System.out.print("Nhap toa đo y cua dinh thu " + (i + 1) + ": ");
            double y = scanner.nextDouble();

            Dinh dinh = new Dinh(x, y);

            danhSachDinhArrayList.add(dinh);
            danhSachDinhArray[i] = dinh;
        }

        scanner.close();
    }

    public void xuat() {
        System.out.println("Danh sach dinh (ArrayList):");
        for (Dinh dinh : danhSachDinhArrayList) {
            System.out.println("(" + dinh.getX() + ", " + dinh.getY() + ")");
        }

        System.out.println("Danh sach dinh (Mang thong thuong ):");
        for (Dinh dinh : danhSachDinhArray) {
            System.out.println("(" + dinh.getX() + ", " + dinh.getY() + ")");
        }
    }

    public double tinhChuVi() {
        double chuVi = 0;
        int soDinh = danhSachDinhArrayList.size();

        for (int i = 0; i < soDinh; i++) {
            Dinh dinh1 = danhSachDinhArrayList.get(i);
            Dinh dinh2 = danhSachDinhArrayList.get((i + 1) % soDinh);
            chuVi += Math.sqrt(Math.pow(dinh2.getX() - dinh1.getX(), 2) + Math.pow(dinh2.getY() - dinh1.getY(), 2));
        }

        return chuVi;
    }

    public Dinh timDinhXaNhat() {
        double maxDistance = 0;
        Dinh dinhXaNhat = null;

        for (Dinh dinh : danhSachDinhArrayList) {
            double distance = Math.sqrt(Math.pow(dinh.getX(), 2) + Math.pow(dinh.getY(), 2));
            if (distance > maxDistance) {
                maxDistance = distance;
                dinhXaNhat = dinh;
            }
        }

        return dinhXaNhat;
    }

    public ArrayList<Dinh> getDanhSachDinhArrayList() {
        return danhSachDinhArrayList;
    }

    public void setDanhSachDinhArrayList(ArrayList<Dinh> danhSachDinhArrayList) {
        this.danhSachDinhArrayList = danhSachDinhArrayList;
        this.danhSachDinhArray = danhSachDinhArrayList.toArray(new Dinh[0]);
    }

    public Dinh[] getDanhSachDinhArray() {
        return danhSachDinhArray;
    }

    public void setDanhSachDinhArray(Dinh[] danhSachDinhArray) {
        this.danhSachDinhArray = danhSachDinhArray;
        this.danhSachDinhArrayList = new ArrayList<>(Arrays.asList(danhSachDinhArray));
    }
}

class Dinh {
    private double x;
    private double y;

    public Dinh(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }



    public static void main(String[] args) {
        Dagiac daGiacArrayList = new Dagiac();
        System.out.println("Nhap da giac (ArrayList):");
        daGiacArrayList.nhap();
        System.out.println("Xuat thong tin da giac (ArrayList):");
        daGiacArrayList.xuat();
        System.out.println("Chu vi da giac (ArrayList): " + daGiacArrayList.tinhChuVi());
        System.out.println("Dinh xa goc toa do nhat (ArrayList): " + daGiacArrayList.timDinhXaNhat().getX() + ", " + daGiacArrayList.timDinhXaNhat().getY());

        Dagiac daGiacArray = new Dagiac(new ArrayList<>());
        System.out.println("\nNhap da giac (Mang thong thuong):");
        daGiacArray.nhap();
        System.out.println("Xuat thông tin da giac (Mang thong thuong):");
        daGiacArray.xuat();
        System.out.println("Chu vi da giac (Mang thông thuong): " + daGiacArray.tinhChuVi());
        System.out.println("dinh xa gốc toa do nhat (Mang thong thuong): " + daGiacArray.timDinhXaNhat().getX() + ", " + daGiacArray.timDinhXaNhat().getY());
    }
}
