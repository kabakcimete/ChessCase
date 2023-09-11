import java.util.ArrayList;

public class WhitePieces extends Pieces{

    WhitePieces(String a, int b, int c) {
        super(a, b, c);
    }



    public boolean checkForAt(ArrayList<BlackPieces> siyahTaslar){
        for (BlackPieces tas : siyahTaslar){
            if(tas.getName().equals("as")){
                int atSatir = tas.getX();
                int atSutun = tas.getY();

                int satirfarki = Math.abs(super.getX() - atSatir);
                int sutunfarki = Math.abs(super.getY() - atSutun);

                if ((satirfarki == 2 && sutunfarki == 1) || (satirfarki == 1 && sutunfarki == 2)) {
                    return true; // Taş bir at tarafından tehdit ediliyor
                }
            }

        }
        return false;
    }


    public boolean checkForVezir(ArrayList<BlackPieces> siyahTaslar){
    for (BlackPieces tas : siyahTaslar){
        if (tas.getName().equals("vb")){
            int vezirSatir = tas.getX();
            int vezirSutun = tas.getY();

            if (super.getX() == vezirSatir || super.getY() == vezirSutun || Math.abs(super.getX() - vezirSatir) == Math.abs(super.getY() - vezirSutun)){
                return true;
            }
        }
    }
    return false;
    }


    public boolean checkForPiyon(ArrayList<BlackPieces> siyahTaslar){
        for (BlackPieces tas : siyahTaslar){
            if (tas.getName().equals("ps")){
                int piyonSatir = tas.getX();
                int piyonSutun = tas.getY();

                if (this.getX()  == piyonSatir + 1 &&  Math.abs(this.getY() - piyonSutun) == 1){
                    return true;
                }
            }
        }
        return false;
    }


}
