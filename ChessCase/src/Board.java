import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
ArrayList<BlackPieces> blacks = new ArrayList<>();;
ArrayList<WhitePieces> whites = new ArrayList<>();;



    public void ReadBoard(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[][] chessboard = new String[8][8]; // Satranç tahtasını saklamak için 8x8 bir dizi

            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] rowValues = line.split(" ");
                if (rowValues.length == 8) {
                    for (int col = 0; col < 8; col++) {
                        chessboard[row][col] = rowValues[col];
                      // System.out.println(rowValues[col]);
                        if(rowValues[col].charAt(1) == 's'){
                            BlackPieces b1 = new BlackPieces(rowValues[col] , row , col);
                            blacks.add(b1);
                        } else if (rowValues[col].charAt(1) == 'b') {
                            WhitePieces w1 = new WhitePieces(rowValues[col] , row , col);
                            whites.add(w1);
                        }
                    }
                    row++;
                } else {
                    System.err.println("Satır " + (row + 1) + " geçersiz bir satır uzunluğuna sahiptir.");
                }

//               for (int i=0 ; i<rowValues.length ; i++){
//                   if(rowValues[i].charAt(1) == 's'){
//                       System.out.println("siyah");
//                   }
//                   else if(rowValues[i].charAt(1) == 'b')
//                       System.out.println("beyaz");
//
//                   else{
//                       System.out.println("bosluk");
//                   }
//               }

            }



            // Satranç tahtasını ekrana yazdırma
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(chessboard[i][j] + " ");
//                }
//                System.out.println();
//            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
//        System.out.println(blacks.size());
//        System.out.println(whites.size());
//
//        for(int i=0 ; i< blacks.size() ; i++){
//            System.out.println(blacks.get(i).getName() + blacks.get(i).getX() + blacks.get(i).getY());
//
//        }
//        for(int i=0 ; i< whites.size() ; i++){
//            System.out.println(whites.get(i).getName() + whites.get(i).getX() + whites.get(i).getY());
//        }
    }

    public void GetScores(){
        double totalScoreBlacks = 0;
        double totalScoreWhites = 0;

        for(int i=0 ; i<blacks.size() ; i++){
            /**kale icin**/
            if(blacks.get(i).getName().charAt(0) == 'k'){
                if(blacks.get(i).checkForAt(whites) || blacks.get(i).checkForVezir(whites) || blacks.get(i).checkForPiyon(whites)){
                    totalScoreBlacks = totalScoreBlacks + 2.5;
                }
                else{
                    totalScoreBlacks = totalScoreBlacks + 5;
                }
            }
            /**at icin**/
            if(blacks.get(i).getName().charAt(0) == 'a'){
                if(blacks.get(i).checkForAt(whites) || blacks.get(i).checkForVezir(whites) || blacks.get(i).checkForPiyon(whites)){
                    totalScoreBlacks = totalScoreBlacks + 1.5;
                }
                else{
                    totalScoreBlacks = totalScoreBlacks + 3;
                }
            }
            /**fil icin**/
            if(blacks.get(i).getName().charAt(0) == 'f'){
                if(blacks.get(i).checkForAt(whites) || blacks.get(i).checkForVezir(whites) || blacks.get(i).checkForPiyon(whites)){
                    totalScoreBlacks = totalScoreBlacks + 1.5;
                }
                else{
                    totalScoreBlacks = totalScoreBlacks + 3;
                }
            }
            /**vezir icin**/
            if(blacks.get(i).getName().charAt(0) == 'v'){
                if(blacks.get(i).checkForAt(whites) || blacks.get(i).checkForVezir(whites) || blacks.get(i).checkForPiyon(whites)){
                    totalScoreBlacks = totalScoreBlacks + 4.5;
                }
                else{
                    totalScoreBlacks = totalScoreBlacks + 9;
                }
            }
            /**sah icin**/
            if(blacks.get(i).getName().charAt(0) == 's'){
                if(blacks.get(i).checkForAt(whites) || blacks.get(i).checkForVezir(whites) || blacks.get(i).checkForPiyon(whites)){
                    totalScoreBlacks = totalScoreBlacks + 50;
                }
                else{
                    totalScoreBlacks = totalScoreBlacks + 100;
                }
            }
            /**piyon icin**/
            if(blacks.get(i).getName().charAt(0) == 'p'){
                if(blacks.get(i).checkForAt(whites) || blacks.get(i).checkForVezir(whites) || blacks.get(i).checkForPiyon(whites)){
                    totalScoreBlacks = totalScoreBlacks + 0.5;
                }
                else{
                    totalScoreBlacks = totalScoreBlacks + 1;
                }
            }

        }
        System.out.println("Total score for blacks:" + totalScoreBlacks);

        for(int i=0 ; i<whites.size() ; i++){
            /**kale icin**/
            if(whites.get(i).getName().charAt(0) == 'k'){
                if(whites.get(i).checkForAt(blacks) || whites.get(i).checkForVezir(blacks) || whites.get(i).checkForPiyon(blacks)){
                    totalScoreWhites = totalScoreWhites + 2.5;
                }
                else{
                    totalScoreWhites = totalScoreWhites + 5;
                }
            }
            /**at icin**/
            if(whites.get(i).getName().charAt(0) == 'a'){
                if(whites.get(i).checkForAt(blacks) || whites.get(i).checkForVezir(blacks) || whites.get(i).checkForPiyon(blacks)){
                    totalScoreWhites = totalScoreWhites + 1.5;
                }
                else{
                    totalScoreWhites = totalScoreWhites + 3;
                }
            }
            /**fil icin**/
            if(whites.get(i).getName().charAt(0) == 'f'){
                if(whites.get(i).checkForAt(blacks) || whites.get(i).checkForVezir(blacks) || whites.get(i).checkForPiyon(blacks)){
                    totalScoreWhites = totalScoreWhites + 1.5;
                }
                else{
                    totalScoreWhites = totalScoreWhites + 3;
                }
            }
            /**vezir icin**/
            if(whites.get(i).getName().charAt(0) == 'v'){
                if(whites.get(i).checkForAt(blacks) || whites.get(i).checkForVezir(blacks) || whites.get(i).checkForPiyon(blacks)){
                    totalScoreWhites = totalScoreWhites + 4.5;
                }
                else{
                    totalScoreWhites = totalScoreWhites + 9;
                }
            }
            /**sah icin**/
            if(whites.get(i).getName().charAt(0) == 's'){
                if(whites.get(i).checkForAt(blacks) || whites.get(i).checkForVezir(blacks) || whites.get(i).checkForPiyon(blacks)){
                    totalScoreWhites = totalScoreWhites + 50;
                }
                else{
                    totalScoreWhites = totalScoreWhites + 100;
                }
            }
            /**piyon icin**/
            if(whites.get(i).getName().charAt(0) == 'p'){
                if(whites.get(i).checkForAt(blacks) || whites.get(i).checkForVezir(blacks) || whites.get(i).checkForPiyon(blacks)){
                    totalScoreWhites = totalScoreWhites + 0.5;
                }
                else{
                    totalScoreWhites = totalScoreWhites + 1;
                }
            }

        }
        System.out.println("Total score for Whites:" + totalScoreWhites);
    }
}