//Mevlüt Emre Okumuþ 05220000971
package soru.pkg2;


public class Employee {
    private String ad_soyad;
    private int kurum_sicil_no;
    private String departman;
    private String pozisyon;
    public Employee(){
        this.setSicilNo(9999);
        this.setAdSoyad(null);
        this.setDepartman(null);
        this.setPozisyon(null);
    }
    public Employee(String ad_soyad,int kurum_sicil_no,String departman,String pozisyon){
        this.setSicilNo(kurum_sicil_no);
        this.setAdSoyad(ad_soyad);
        this.setDepartman(departman);
        this.setPozisyon(pozisyon);
    }
    public String getAdSoyad(){
        return this.ad_soyad;
    }
    public int getSicilNo(){
        return this.kurum_sicil_no;
    }
    public String getDepartman(){
        return this.departman;
    }
    public String getPozisyon(){
        return this.pozisyon;
    }
    public void setAdSoyad(String ad_soyad){
        this.ad_soyad=ad_soyad;
    }
    public void setSicilNo(int kurum_sicil_no){
        this.kurum_sicil_no=kurum_sicil_no;
    }
    public void setDepartman(String departman){
        this.departman=departman;
    }
    public void setPozisyon(String pozisyon){
        this.pozisyon=pozisyon;
    }
    @Override
    public String toString(){
        
        return String.format("%s%s%n%s%d%n%s%s%n%s%s%n","Adý ve Soyadý: ",getAdSoyad(),"Sicil Numarasý: ",
                getSicilNo(),"Bulunduðu Departman: ",
                getDepartman(),"Bulunduðu Pozisyon: ",getPozisyon());
        
    }
}
