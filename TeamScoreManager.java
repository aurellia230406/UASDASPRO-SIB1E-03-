import java.util.*;

class Team {
    String name;
    int level1Score;
    int level2Score;

    Team(String name, int level1Score, int level2Score) {
        this.name = name;
        this.level1Score = level1Score;
        this.level2Score = level2Score;
    }

    int getTotalScore() {
        return level1Score + level2Score;
    }
}

public class TeamScoreManager {
    private static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    inputTeamScores(scanner);
                    break;
                case 2:
                    displayScoreTable();
                    break;
                case 3:
                    determineWinner();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    private static void inputTeamScores(Scanner scanner) {
        for (int i = 1; i <= 4; i++) {
            System.out.print("Masukkan nama tim ke-" + i + ": ");
            String name = scanner.nextLine();
            System.out.print("Masukkan skor " + name + " untuk Level 1: ");
            int level1Score = scanner.nextInt();
            System.out.print("Masukkan skor " + name + " untuk Level 2: ");
            int level2Score = scanner.nextInt();
            scanner.nextLine(); // consume newline

            teams.add(new Team(name, level1Score, level2Score));
            System.out.println("Data tim " + name + " berhasil ditambahkan.");
        }
    }

    private static void displayScoreTable() {
        if (teams.isEmpty()) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }

        System.out.println("=== TABEL SKOR ===");
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Nama Tim", "Level 1", "Level 2", "Total");
        for (Team team : teams) {
            System.out.printf("%-10s %-10d %-10d %-10d%n",
                    team.name, team.level1Score, team.level2Score, team.getTotalScore());
        }
    }

    private static void determineWinner() {
        if (teams.isEmpty()) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }

        Team winner = Collections.max(teams, Comparator.comparingInt(Team::getTotalScore));
        System.out.println("Selamat kepada " + winner.name + " yang telah memenangkan kompetisi!");
    }
}