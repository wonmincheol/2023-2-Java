import  java.io.*;

public class GameJava2_05 {
    public static void main(String[] args) throws IOException{

        System.out.println("당신의 파일은 잠겼습니다.");

        Hangman hangman = new Hangman();

        int result = hangman.playGame();

        System.out.println();
        if(result <= 2) {
            System.out.println("참 잘 했어요.");
        }
        else if(result <= 3){
            System.out.println("잘 했어요");
        }
        else if(result <= 4){
            System.out.println("보통");
        }
        else{
            System.out.println("다시 ㄱ");
        }
    }

}
























