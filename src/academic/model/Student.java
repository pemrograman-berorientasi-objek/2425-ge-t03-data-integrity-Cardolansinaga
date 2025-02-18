package academic.model;

public class Student {
    private String nim;
    private String nama;
    private int angkatan;
    private String prodi;

    public Student(String nim, String nama, int angkatan, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.angkatan = angkatan;
        this.prodi = prodi;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    @Override
    public String toString() {
        return nim + "|" + nama + "|" + angkatan + "|" + prodi;
    }
}