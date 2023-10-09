package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private static final int SONG_ID_LENGTH = 4;
    private static int songIdCount = 0;
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    private String generateSongId() {
        String prefix = "S";
        String id = String.format("%04d", songIdCount++);
        return prefix + id;
    }

    public Song() {
        this.songId = generateSongId();
        this.createdDate = new Date();
    }

    public Song(String songName, String descriptions, Singer singer, String songWriter) {
        this.songId = generateSongId();
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = new Date();
    }

    public void songInputData(Singer[] singer, int SingerIndex) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap thong tin bai hat: ");

        System.out.println("nhap ten bai hat");
        while (true) {
            this.songName = scanner.nextLine();
            if (!this.songName.isEmpty()) {
                break;
            } else {
                System.out.println("ten bai hat khong duoc de trong, vui long nhap lai");
            }
        }

        System.out.println("nhap mo ta bai hat");
        this.descriptions = scanner.nextLine();

        // Thực hiện thị danh sách ca sĩ cho người dùng chọn theo id nhập vào, nếu
        // không có ca sĩ nào thì bắt buộc người dùng thêm ca sĩ trước.
        System.out.println("danh sach ca si");
        for (int i = 0; i < SingerIndex; i++) {
            singer[i].displayData();
        }

        System.out.println("nhap id cua ca si: ");
        int checkID = Integer.parseInt(scanner.nextLine());
        Singer selectedSinger = null;
        for (int i = 0; i < SingerIndex; i++) {
            if (singer[i].getSingerId() == checkID) {
                selectedSinger = singer[i];
                break;
            }
        }
        while (true) {
            if (selectedSinger != null) {
                this.singer = selectedSinger;
                break;
            } else {
                System.out.println("khong tim thay ca si voi id vua nhap vao");
            }
        }

        System.out.println("nhap ten nguoi sang tac");
        while (true) {
            this.songWriter = scanner.nextLine();
            if (!this.songWriter.isEmpty()) {
                break;
            } else {
                System.out.println("ten nguoi sang tac ko duoc de trong, vui long nhap lai");
            }
        }

        System.out.println();
    }

    public void songDisplayData() {
        System.out.println("thong tin bai hat");
        System.out.println("ma bai hat: " + songId);
        System.out.println("ten bai hat: " + songName);
        System.out.println("mo ta: " + descriptions);
        System.out.println("ca si: " + singer);
        System.out.println("nguoi sang tac: " + songWriter);
        System.out.println("ngay tao: " + createdDate);
        System.out.println("trang thai: " + (songStatus ? "hoat dong" : "ngung hoat dong"));
    }

    public static int getSongIdCount() {
        return songIdCount;
    }

    public static void setSongIdCount(int songIdCount) {
        Song.songIdCount = songIdCount;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
}