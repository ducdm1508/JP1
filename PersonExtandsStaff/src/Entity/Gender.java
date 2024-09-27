package Entity;

public enum Gender {
    M("Male"), F("Female"), O("Other");
    private String genderLable;

    Gender(String genderLable) {
        this.genderLable = genderLable;
    }

    public String getGender() {
        return this.genderLable;
    }

    public void setGender(String genderLable) {
        this.genderLable = genderLable;
    }

}
