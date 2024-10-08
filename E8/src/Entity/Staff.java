package Entity;

import java.time.LocalDateTime;

public class Staff {
    private int id;
    private String code;
    private String name;
    private LocalDateTime DoB;

    public Staff(){;}
    public Staff(int id, String code, String name, LocalDateTime DoB) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.DoB = DoB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDoB() {
        return DoB;
    }

    public void setDoB(LocalDateTime DoB) {
        this.DoB = DoB;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", DoB=" + DoB +
                '}';
    }
}
