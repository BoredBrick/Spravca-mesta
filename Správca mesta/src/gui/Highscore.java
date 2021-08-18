package gui;

import buildings.Storage;
import buildings.productionbuildings.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Highscore {
    /**
     * Dosiahnuté skóre a meno hráča
     */
    private HashMap<Integer, String> highscores;
    /**
     * Súbor v ktorom sú skóre uložené
     */
    private File file;
    /**
     * Počet riadkov v súbore
     */
    private int lines;

    public Highscore() {
        this.file = new File("src/highscores.txt");
        this.highscores = new HashMap<>();
        try {
            this.getHighscoresFromFile();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Načítanie skóre na začiatku hry
     * @throws FileNotFoundException V prípade, že súbor neexistuje
     */
    public void getHighscoresFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 2);
            this.highscores.put(Integer.parseInt(parts[0]), parts[1]);
        }

        try {
            this.lines = this.countLines(this.file);
        } catch (IOException e) {
            System.out.println("Could not read file");
        }
        scanner.close();
    }
    /**
     * Ukladanie všetkých skóre do stringu na zobrazenie
     * @return String so všetkými skóre
     */
    public String getScoresToDisplay() {
        String s = "";
        ArrayList<Integer> sortedKeys = new ArrayList(this.highscores.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());
        for (int i = 0; i < sortedKeys.size(); i++) {
            int score = sortedKeys.get(i);
            String text = this.highscores.get(score);
            s += "\n" + score + " " + text;
        }
        return s;
    }
    /**
     * Zapisovanie skóre po skončení hry
     * @param name meno hráča
     * @param storage sklad
     * @param clicks počet kliknutí
     * @throws IOException Ak nie je možné zapísať skóre
     */
    public void writeHighscore(String name, Storage storage, PlayerClicks clicks) throws IOException {
        FileWriter filewriter = new FileWriter(this.file);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.highscores.put(this.calculateHighscore(storage, clicks), " " + name + " " + formatter.format(date));
        if (this.lines == 0) {
            filewriter.write(this.calculateHighscore(storage, clicks) + " " + name + " " + formatter.format(date));
            filewriter.close();
        } else {
            ArrayList<Integer> sortedKeys = new ArrayList(this.highscores.keySet());
            Collections.sort(sortedKeys, Collections.reverseOrder());
            if (this.lines == 5) {
                this.highscores.remove(sortedKeys.get(5));
                sortedKeys.remove(5);
            }
            for (int i = 0; i < sortedKeys.size(); i++) {
                int score = sortedKeys.get(i);
                String text = this.highscores.get(score);
                if (i == 0) {
                    filewriter.write(score + " " + text);
                    continue;
                }
                filewriter.write("\n" + score + " " + text);
            }
            filewriter.close();
        }
    }
    /**
     * Spočítanie riadkov v súbore
     * @param input súbor so skóre
     * @return počet riadkov
     * @throws IOException ak nie je možné prečítať súbor
     */
    public int countLines(File input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        int line = 0;
        while (reader.readLine() != null) {
            line++;
        }
        reader.close();
        return line;
    }
    /**
     * Výpočet skóre 
     * @param storage sklad, celkový počet vyprodukovaných produktov
     * @param clicks počet kliknhutí
     * @return skóre
     */
    public int calculateHighscore(Storage storage, PlayerClicks clicks) {
        HashMap<Product, Integer> totalProduced = storage.getTotalProduced();
        int score = 0;
        for (Product product : totalProduced.keySet()) {
            score += totalProduced.get(product) * this.getProductMultiplier(product);
        }
        final int miningClickMultiplier = 10;
        score += clicks.getTotalNumOfMiningClicks() / miningClickMultiplier;
        return score;
    }

    public HashMap<Integer, String> getHighscores() {
        return this.highscores;
    }
    /**
     * Násobič skóre pre dané produkty
     * @param product produkt
     * @return hodnota násobiča
     */
    private int getProductMultiplier(Product product) {
        switch (product) {
            case SMOKED_MEAT:
                return 2;
            case GOLD:
                return 3;
            case STEEL:
                return 2;
            default:
                return 1;
        }

    }
}
