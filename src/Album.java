import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;

    private List<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;

        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title){
        for(Song x:songs){
            if(x.getTitle().equals(title)){
               return true;
            }
        }
        return false;
    }
    void addSongstoAlbum(String title,double duration){
        Song s=new Song(title,duration);
        if(findSong(s.getTitle())==true){
            System.out.println("Song is Already present");
        }
        else{
            songs.add(s);
            System.out.println("new song added");
        }

    }
    public void addToPlayListFromAlbum(String title, LinkedList<Song> playlist ){
        if(findSong(title)==true){
            for(Song song: songs){
                //System.out.println("jdfosfo");
                if(song.getTitle().equals(title)){
                        playlist.add(song);
                    System.out.println("song is added in your playlist");
                        break;
                }
            }

        }
        else {
            System.out.println("song is not present in the album");
        }
        return;
    }
    public void addToPlayListFromAlbum(int trackNo,LinkedList<Song> playlist ){
        int index=trackNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));

        }
        else{
            System.out.println("invalid track no");
        }
        return;
    }

}
