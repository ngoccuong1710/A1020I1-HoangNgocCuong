package model;

public class Email {
    private String language;
    private int pageSIze;
    private boolean spamsFilters;
    private String signature;

    public Email() {
    }

    public Email(String language, int pageSIze, boolean spamsFilters, String signature) {
        this.language = language;
        this.pageSIze = pageSIze;
        this.spamsFilters = spamsFilters;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSIze() {
        return pageSIze;
    }

    public void setPageSIze(int pageSIze) {
        this.pageSIze = pageSIze;
    }

    public boolean isSpamsFilters() {
        return spamsFilters;
    }

    public void setSpamsFilters(boolean spamsFilters) {
        this.spamsFilters = spamsFilters;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
