package Entity;

public enum Gender {
    M("Male"), F("Female");

    private String genderLabel;

    Gender (String genderLabel) {
        this.genderLabel = genderLabel;
    }
    public String getGenderLabel() {
        return genderLabel;
    }
    public void setGenderLabel(String genderLabel) {
        this.genderLabel = genderLabel;
    }
}
