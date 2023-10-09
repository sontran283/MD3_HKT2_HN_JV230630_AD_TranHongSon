package ra.model;

import java.util.Scanner;

public class Singer {
    private static int singerIdCount = 1;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
        this.singerId = singerIdCount++;
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public void inputData(Scanner scanner) {
        System.out.println("hay nhap thong tin ca si: ");

        System.out.println("nhap ten ca si: ");
        while (true) {
            this.singerName = scanner.nextLine();
            if (!this.singerName.isEmpty()) {
                break;
            } else {
                System.out.println("ten khong duoc de trong, moi nhap lai!");
            }
        }

        System.out.println("nhap tuoi: ");
        while (true) {
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age > 0) {
                break;
            } else {
                System.out.println("tuoi phai lon hon 0, vui long nhap lai!");
            }
        }

        System.out.println("nhap quoc tich: ");
        while (true) {
            this.nationality = scanner.nextLine();
            if (!this.nationality.isEmpty()) {
                break;
            } else {
                System.out.println("quoc tich khong duoc de trong, moi nhap lai!");
            }
        }

        System.out.println("nhap gioi tinh (1_male, 2_female): ");
        int genderOption = Integer.parseInt(scanner.nextLine());
        this.gender = (genderOption == 1);

        System.out.println("nhap the loai: ");
        while (true) {
            this.genre = scanner.nextLine();
            if (!this.genre.isEmpty()) {
                break;
            } else {
                System.out.println("the loai khong duoc de trong, moi nhap lai");
            }
        }

        System.out.println();
    }

    public void displayData() {
        System.out.println(
                "Singer{" +
                        ", singerId=" + singerId +
                        ", singerName='" + singerName + '\'' +
                        ", age=" + age +
                        ", nationality='" + nationality + '\'' +
                        ", gender=" + (gender ? "male" : "female") + '\'' +
                        ", genre='" + genre + '\'' +
                        '}'
        );
    }

    public static int getSingerIdCount() {
        return singerIdCount;
    }

    public static void setSingerIdCount(int singerIdCount) {
        Singer.singerIdCount = singerIdCount;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
