import java.util.ArrayList;

public class BlackPieces extends Pieces{

    BlackPieces(String a, int b, int c){
        super(a, b, c);
    }


public boolean checkForAt(ArrayList<WhitePieces> beyazTaslar){
    for (WhitePieces tas : beyazTaslar){
        if(tas.getName().equals("ab")){
            int atSatir = tas.getX();
            int atSutun = tas.getY();

            int satirfarki = Math.abs(atSatir - super.getX() );
            int sutunfarki = Math.abs(atSutun - super.getY() );
            if ((satirfarki == 2 && sutunfarki == 1) || (satirfarki == 1 && sutunfarki == 2)) {
                return true; // Taş bir at tarafından tehdit ediliyor
            }
        }

    }
    return false;
}
public boolean checkForVezir(ArrayList<WhitePieces> beyazTaslar){
    for (WhitePieces tas : beyazTaslar){
        if (tas.getName().equals("vs")){
            int vezirSatir = tas.getX();
            int vezirSutun = tas.getY();

            if (super.getX() == vezirSatir || super.getY() == vezirSutun || Math.abs(super.getX() - vezirSatir) == Math.abs(super.getY() - vezirSutun)){
                return true;
            }
        }
    }
    return false;
}
    public boolean checkForPiyon(ArrayList<WhitePieces> beyazTaslar){
        for (WhitePieces tas : beyazTaslar){
            if (tas.getName().equals("pb")){
                int piyonSatir = tas.getX();
                int piyonSutun = tas.getY();

                if (this.getX()  == piyonSatir - 1 &&  Math.abs(this.getY() - piyonSutun) == 1){
                    return true;
                }
            }
        }
        return false;
    }


}
