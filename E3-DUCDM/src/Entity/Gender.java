package Entity;

public enum Gender {
    M("Male"), F("female");
    private String genderLable;
    Gender(String genderLable) {
        this.genderLable = genderLable;
    }
    public String getGenderLable() {
        return this.genderLable;
    }
    public void setGenderLable(String genderLable) {
        this.genderLable = genderLable;
    }
}
