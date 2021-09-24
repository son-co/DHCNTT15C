package modul2.bai2;

public class SinhVien {
	long mssv;
	String hoten;
	double diemTH,diemLT;
	public SinhVien() {
		super();
	}
	public SinhVien(long mssv,String hoten,double diemTH,double diemLT) {
		setMssv(mssv);
		setHoten(hoten);
		setDiemTH(diemTH);
		setDiemLT(diemLT);
	}
	
	public long getMssv() {
		return mssv;
	}
	public void setMssv(long mssv) {
		if (mssv<0) {
			this.mssv=0;
		}
			
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public double getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(double diemTH) {
		if (diemTH<0 && diemTH>10 ) {
			this.diemTH=0;
		}
		else {
			this.diemTH = diemTH;
		}
	}
	public double getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(double diemLT) {
		if (diemLT<0 && diemLT>10 ) {
			this.diemLT=0;
		}
		else {
			this.diemLT = diemLT;
		}
	}
	public double diemTB()
	{
		return (diemTH+diemLT)/2;
	}
	public static String tieude() {
		return String.format("%-15s %-25s %10s %10s %10s","MaSV", "Họ và Tên", "Điểm TH", "Điểm LT", "Điểm TB");
	}
	@Override
	public String toString() {
		return String.format("%-15d %-25s %10.2f %10.2f %10.2f",mssv,hoten,diemTH,diemLT,diemTB());
	}
	


	
}
