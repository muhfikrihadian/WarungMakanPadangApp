package com.example.stolovapadangorderfood.Model;

public class PaketMenu {
    private String sellerName,paketminggu,paketbulan;

    public PaketMenu(){
    }

    public PaketMenu(String sellerName, String paketminggu, String paketbulan) {
        this.sellerName = sellerName;
        this.paketminggu = paketminggu;
        this.paketbulan = paketbulan;
    }
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getPaketMinggu() {
        return paketminggu;
    }

    public void setPaketMinggu(String paketminggu) {
        this.paketminggu= paketminggu;
    }

    public String getPaketBulan() {
        return paketbulan;
    }

    public void setPaketBulan(String paketbulan) {
        this.paketbulan = paketbulan;
    }

}
