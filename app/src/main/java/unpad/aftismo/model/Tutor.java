package unpad.aftismo.model;

public class Tutor {
    public String ID;
    public String Nama;
    public String Lokasi;
    public String Tutor_Phone;
    public String Picture;
    public String Price;

    public String getTutor_Phone() {
        return Tutor_Phone;
    }

    public void setTutor_Phone(String tutor_Phone) {
        Tutor_Phone = tutor_Phone;
    }

    public String Availability;
    public String SkillSatu, SkillDua, SkillTiga, SkillEmpat, SkillLima;

    public Tutor() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public String getSkillSatu() {
        return SkillSatu;
    }

    public void setSkillSatu(String skillSatu) {
        SkillSatu = skillSatu;
    }

    public String getSkillDua() {
        return SkillDua;
    }

    public void setSkillDua(String skillDua) {
        SkillDua = skillDua;
    }

    public String getSkillTiga() {
        return SkillTiga;
    }

    public void setSkillTiga(String skillTiga) {
        SkillTiga = skillTiga;
    }

    public String getSkillEmpat() {
        return SkillEmpat;
    }

    public void setSkillEmpat(String skillEmpat) {
        SkillEmpat = skillEmpat;
    }

    public String getSkillLima() {
        return SkillLima;
    }

    public void setSkillLima(String skillLima) {
        SkillLima = skillLima;
    }
}
