import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1=new Album("itemSong","pawan");
        album1.addSongstoAlbum("5k3",3.00);
        album1.addSongstoAlbum("bijli",2.25);
        album1.addSongstoAlbum("aaja ",5.25);
        album1.addSongstoAlbum("nikal",3.25);
        album1.addSongstoAlbum("rap",1.25);

        Album album2=new Album("itemSong","bpark");
        album2.addSongstoAlbum("kdmfml",2.25);
        album2.addSongstoAlbum("jkdhfo",4.25);
        album2.addSongstoAlbum("dknfl",3.95);
        album2.addSongstoAlbum("jhfoe",3.28);
        album2.addSongstoAlbum("hfoe",3.00);
        System.out.println(album1.findSong("bijli"));
        LinkedList<Song> myPlaylist=new LinkedList<>();
        album2.addToPlayListFromAlbum("jhfoe",myPlaylist);
        album2.addToPlayListFromAlbum("hfoe",myPlaylist);
        album2.addToPlayListFromAlbum("dknfl",myPlaylist);
        album2.addToPlayListFromAlbum("kdmfml",myPlaylist);
        album2.addToPlayListFromAlbum("jkdhfo",myPlaylist);
        play(myPlaylist);


    }
    public static void play(LinkedList<Song> playList){
        boolean isForward=false;
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr=playList.listIterator();
        if(playList.size()>0){
            System.out.print("currently playing");
            System.out.println(itr.next());
            isForward=true;
        }
        else {
            System.out.println("empty");
            return;
        }

        System.out.println("Enter your choice");

        printMenu();
        boolean quit=false;
        while(!quit){
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("you are reached at the end of playlist");
                        isForward=false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());

                    }
                    else {
                        System.out.println("you come int front of playlist");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward=false;
                        }
                        else {
                            System.out.println("khtm ho gya");
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward=true;
                        }
                        else{
                            System.out.println("khtm ho gya");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSong(playList);
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
    }
    public static void printSong(LinkedList<Song> playlist){
        for(Song song:playlist){
            System.out.println(song);
        }
        return;
    }

    public static void printMenu(){
        System.out.println("Select your choice");
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all song in playlist");
        System.out.println("7 - exit");

        return;
    }
}