package ra.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MusicManagement {
    static Singer[] singers = new Singer[100];
    static Song[] songs = new Song[100];
    static int SingerIndex = 0;
    static int SongIndex = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("****** Menu Music Management ******");
            System.out.println("Chọn 1_ Quản lý ca sĩ");
            System.out.println("Chọn 2_ Quản lý bài hát");
            System.out.println("Chọn 3_ Tìm kiếm bài hát");
            System.out.println("Chọn 4_ Thoát ");
            System.out.println("Mời nhập lựa chọn của bạn : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    singerManagement();
                    break;
                case 2:
                    songManagement();
                    break;
                case 3:
                    searchManagement();
                    break;
                case 4:
                    System.exit(1);
                    break;
            }
        } while (true);
    }

    // Quản lý ca sĩ
    public static void singerManagement() {
        int choice1;
        do {
            System.out.println("------------------------Quản lý ca sĩ-------------------------");
            System.out.println("Chọn 1_ Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("Chọn 2_ Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("Chọn 3_ Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("Chọn 4_ Xóa ca sĩ theo mã id");
            System.out.println("Chọn 5_ Thoát ");
            System.out.println("Mời nhập lựa chọn của bạn : ");
            choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    addSinger();
                    break;
                case 2:
                    showSinger();
                    break;
                case 3:
                    editSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private static void addSinger() {
        System.out.println("Nhap so luong ca si can them: ");
        int addSingerCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < addSingerCount; i++) {
            System.out.println("Them ca si lan thu: " + i + 1);
            ra.model.Singer singer = new Singer();
            singer.inputData(scanner);
            singers[SingerIndex++] = singer;
            System.out.println("Da them thanh cong!");
        }
    }

    private static void showSinger() {
        System.out.println("Danh sach tat ca cac ca si: ");
        for (int i = 0; i < SingerIndex; i++) {
            singers[i].displayData();
        }
    }

    private static void editSinger() {
        System.out.println("hay nhap id cua ca si can sua: ");
        int editedSingerId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < SingerIndex; i++) {
            if (singers[i].getSingerId() == editedSingerId) {
                System.out.println("thong tin cua ca si ma ban muon sua la: ");
                singers[i].displayData();
                singers[i].inputData(scanner);
                System.out.println("da cap nhat thong tin thanh cong!");
                return;
            }
        }
        System.out.println("khong tim thay ca si voi id la: " + editedSingerId);
    }

    private static void deleteSinger() {
        System.out.println("Hay nhap id cua ca si can xoa: ");
        int deletedSingerId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < SingerIndex; i++) {
            if (singers[i].getSingerId() == deletedSingerId) {
                for (int j = i; j < SingerIndex; j++) {
                    singers[j] = singers[j + 1];
                }
                SingerIndex--;
            }
        }
        System.out.println("Khong tim thay ca si voi id la: " + deletedSingerId);
    }

    // Quản lý bài hát
    public static void songManagement() {
        int choice2;
        do {
            System.out.println("------------------------Quản lý bài hát-------------------------");
            System.out.println("Chọn 1_ Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("Chọn 2_ Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("Chọn 3_ Thay đổi thông tin bài hát theo mã id");
            System.out.println("Chọn 4_ Xóa bài hát theo mã id");
            System.out.println("Chọn 5_ Thoát ");
            System.out.println("Mời nhập lựa chọn của bạn : ");
            choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    addSong();
                    break;
                case 2:
                    showSong();
                    break;
                case 3:
                    editSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private static void addSong() {
        System.out.println("Nhap so luong bai hat can them: ");
        int addSongCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < addSongCount; i++) {
            System.out.println("Them bai hat lan thu: " + i + 1);
            ra.model.Song song = new Song();
            song.songInputData(singers, SingerIndex);
            songs[SongIndex++] = song;
            System.out.println("Da them thanh cong!");
        }
    }

    private static void showSong() {
        System.out.println("Danh sach tat ca bai hat: ");
        for (int i = 0; i < SongIndex; i++) {
            songs[i].songDisplayData();
        }
    }

    private static void editSong() {
        System.out.println("hay nhap id cua bai hat can sua: ");
        String editedSongId = scanner.nextLine();
        for (int i = 0; i < SongIndex; i++) {
            if (songs[i].getSongId().equals(editedSongId)) {
                System.out.println("thong tin cusa ca si ma ban muon sua la: ");
                songs[i].songDisplayData();
                songs[i].songInputData(singers, SingerIndex);
                System.out.println("da cap nhat thong tin thanh cong!");
                return;
            }
        }
        System.out.println("khong tim thay ca si voi id la: " + editedSongId);
    }

    private static void deleteSong() {
        System.out.println("Hay nhap id cua ca si can xoa: ");
        String deletedSongId = scanner.nextLine();
        for (int i = 0; i < SingerIndex; i++) {
            if (songs[i].getSongId().equals(deletedSongId)) {
                for (int j = i; j < SongIndex; j++) {
                    songs[j] = songs[j + 1];
                }
                SongIndex--;
            }
        }
        System.out.println("Khong tim thay ca si voi id la: " + deletedSongId);
    }

    // Tìm kiếm bài hát
    public static void searchManagement() {
        int choice3;
        do {
            System.out.println("------------------------Tìm kiếm bài hát-------------------------");
            System.out.println("Chọn 1_ Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("Chọn 2_ Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("Chọn 3_ Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("Chọn 4_ Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("Chọn 5_ Thoát ");
            System.out.println("Mời nhập lựa chọn của bạn : ");
            choice3 = Integer.parseInt(scanner.nextLine());
            switch (choice3) {
                case 1:
                    searchSongName();
                    break;
                case 2:
                    searchSingName();
                    break;
                case 3:
                    showCountUp();
                    break;
                case 4:
                    showNewSong();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private static void searchSongName() {
        System.out.print("tim kiem bai hat theo ten ca si hoac the loai: ");
        String text1 = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < SingerIndex; i++) {
            if (singers[i].getSingerName().contains(text1) || singers[i].getGenre().contains(text1)) {
                System.out.println("bai hat " + (i + 1) + ":");
                singers[i].displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay bai hat nao voi tu khoa " + "\'" + text1 + "\'");
        }
    }

    private static void searchSingName() {
        System.out.print("tim kiem ca si theo ten hoac the loai: ");
        String text2 = scanner.nextLine();
        boolean check = false;
        for (int j = 0; j < SingerIndex; j++) {
            if (songs[j].getSongName().contains(text2) || singers[j].getGenre().contains(text2)) {
                System.out.println("ca si: " + (j + 1) + ":");
                songs[j].songDisplayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay ca si nao voi tu khoa " + "\'" + text2 + "\'");
        }
    }

    private static void showCountUp() {
        Arrays.sort(songs, 0, SongIndex, (b1, b2) -> b1.getSongName().compareTo(b2.getSongName()));
        System.out.println("danh sach bai hat theo thu tu tang dan len la: ");
        for (int i = 0; i < SongIndex; i++) {
            System.out.println(songs[i].getSongName());
        }
    }

    private static void showNewSong() {
        // SongIndex - 1  chi so bai hat cuoi cung trong danh sach
        // Điều kiện của vòng lặp for là i không nhỏ hơn 0 (để đảm bảo vẫn còn bài hát trong danh sách)
        // và j nhỏ hơn 10 (để chỉ hiển thị thông tin của 10 bài hát).
        // i--, j++: Các biến đếm i và j được cập nhật sau mỗi lần lặp. Biến i giảm đi 1 và biến j tăng lên 1.
        for (int i = SongIndex - 1, j = 0; i >= 0 && j < 10; i--, j++) {
            songs[i].songDisplayData();
        }
    }
}
