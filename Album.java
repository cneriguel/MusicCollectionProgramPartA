/**VERSION 1
 * Description: The Java class - Album represents the album that contains music. There can only be 3 albums and 4 songs inside each album. 
 * Author: Liz Tulio & Charlene Eriguel
 * Student Number: C3250794 - C3383599
 * Created: 23 Mar 2023
 * Modified: 27/4/23
 * Submitted: 28/4/23
 **/

public class Album
{   
    //Private fields
    private Song song1,song2,song3,song4;
    private String name;
    private final int MAX_TIME = 1200; //20 minutes
    private double totalTime;
    private double newTotalTime;
    
    public Album()
    {
        //Initialises name of album into empty string
        name = "";             
        //Creates four instances of song class
        song1 = new Song();        
        song2 = new Song();
        song3 = new Song();
        song4 = new Song();
        //Initiales totalTime to zero
        totalTime = 0;
    }

    //Set album name
    public void setName(String albumName)
    {
        name = albumName;    
    }
    
    //Get album name
    public String getName()
    {
        return name;
    }
   
    //Check if song exists in an album
    public boolean checkSongExists(String title)
    {
     {
        if (song1.getTitle().equals(title)) {
            return true;
        }
        else if (song2.getTitle().equals(title)) {
            return true;
        }
        else if (song3.getTitle().equals(title)) {
            return true;
        }
        else if (song4.getTitle().equals(title)) {
            return true;
        } else {
            return false;
        }
     }
    }

    //Add song title, artist name, genre and duration
    public void addSong(String title, String artist, String genre, double duration)
    {  
        if (totalTime+duration <= 1200) {
           if (song1.getTitle().equals("")){
                song1.setTitle(title);
                song1.setArtist(artist);
                song1.setGenre(genre);
                song1.setDuration(duration);
                
                //Checks if album has reached max time and song will be added if not
                if (song1.getDuration() <= MAX_TIME){
                   totalTime+=song1.getDuration();
                   newTotalTime=MAX_TIME-totalTime;
                    System.out.println("Song added! There is " + newTotalTime + " seconds left in this album");
                }else{              
                    System.out.println("Can't add song. Song duration has reached maximum limit");
                }
           }else if (song2.getTitle().equals("")){
                song2.setTitle(title);
                song2.setArtist(artist);
                song2.setGenre(genre);
                song2.setDuration(duration);
                
                if (song2.getDuration() <= newTotalTime){
                    totalTime+=song2.getDuration();
                    newTotalTime-=song2.getDuration();
                    System.out.println("Song added! There is " + newTotalTime + " seconds left in this album");
               }else {
                    System.out.println("Can't add song. Duration has reached over the limit");
                }
            }else if (song3.getTitle().equals("")){
                song3.setTitle(title);
                song3.setArtist(artist);
                song3.setGenre(genre);
                song3.setDuration(duration);
                song3.getDuration();
                
               if (song3.getDuration() <= newTotalTime){
                totalTime+=song3.getDuration();
                newTotalTime-=song3.getDuration();
                System.out.println("Song added! There is " + newTotalTime + " seconds left in this album");
                }else {
                    System.out.println("Can't add song. Song duration has reached maximum limit");}
           }else if (song4.getTitle().equals("")){
                song4.setTitle(title);
                song4.setArtist(artist);
                song4.setGenre(genre);
                song4.setDuration(duration);
    
                if (song4.getDuration() <= newTotalTime){
                totalTime+=song4.getDuration();
                newTotalTime-=song4.getDuration();
                System.out.println("Song added! There is " + newTotalTime + " seconds left in this album");
               }else {
                System.out.println("Can't add song. Song duration has reached maximum limit");}
           }else {
                System.out.println( "The album you selected has reached the maximum number of songs");
            }    
        }
    }
    
    //Allows user to search song by duration
    public void searchDuration(double seconds){
        
        if(song1.getTitle().equals("")){
            //Checks if song 1 meets requirements
        }else{
            if(song1.getDuration() < seconds){
                System.out.println(" 1. " + song1.getTitle());
            }
            else System.out.println("No Songs listed ");
        }

        if(song2.getTitle().equals("")){
            //Checks if song 2 meets requirements/
        }else{
            if(song2.getDuration() < seconds){
                System.out.println(" 2: " + song2.getTitle());
            }
            else System.out.println("No Songs listed ");
        }

        if(song3.getTitle().equals("")){
            //Checks if song 3 meets requirements
        }else{
            if(song3.getDuration() < seconds){
                System.out.println(" 3. " + song3.getTitle());
            }
            else System.out.println("No Songs listed ");
        }

        if(song4.getTitle().equals("")){
            //Checks if song 4 meets requirements
        }else{
            if(song4.getDuration() < seconds){
                System.out.println(" 4. " + song4.getTitle());
            }
            else System.out.println("No Songs listed ");
        }
    }

    //Checks genre of each song in the album and if no genre song matches genre it prints out warning message
    public void searchGenre(String genreSearched)
    {
        if(song1.getTitle().equals("")){
            //Checks if song 1 meets genre
        }else{
            if(song1.getGenre().equals(genreSearched)){
                System.out.println(" 1. " + song1.getTitle());
            }
            else System.out.println("No Songs listed ");
        }

        if(song2.getTitle().equals("")){
            //Checks if song 2 meets requirements
        }else{
            if(song2.getGenre().equals(genreSearched)){
                System.out.println(" 2. " + song2.getTitle());
            }
            else System.out.println("No Songs listed ");
        }

        if(song3.getTitle().equals("")){
            //Checks if song 3 meets genre
        }else{
            if(song3.getGenre().equals(genreSearched)){
                System.out.println(" 3. " + song3.getTitle());
            }
            else System.out.println("No Songs listed ");
        }

        if(song4.getTitle().equals("")){
            //Checks if song 3 meets genre
        }else{
            if(song4.getGenre().equals(genreSearched)){
                System.out.println(" 4. " + song4.getTitle());
            }
            else System.out.println("No Songs listed ");
        }
    } 
        
    //Deletes song corresponding to i
    public void deleteSong(int i){
        if (i == 1){
            System.out.println("Song "+song1.getTitle()+" has been removed");
            removeSong(1);          
        }else if (i == 2){
            System.out.println("Song "+song2.getTitle()+" has been removed");
            removeSong(2);       
        }else if (i == 3){
            System.out.println("Song "+song3.getTitle()+" has been removed");
            removeSong(3);
        }else if (i == 4){
            System.out.println("Song "+song4.getTitle()+" has been removed");
            removeSong(4);
        }
    }

    //Deletes song details corresponding to i
    public void removeSong(int i){
        if (i == 1){
            String createTitle = song1.getTitle();
            song1.setTitle("");
            song1.setArtist("");
            song1.setGenre("");
            song1.setDuration(0);;
        }else if (i == 2){
            String createTitle = song2.getTitle();
            song2.setTitle("");
            song2.setArtist("");
            song2.setGenre("");
            song2.setDuration(0);
        }else if (i == 3){
            String createTitle = song3.getTitle();
            song3.setTitle("");
            song3.setArtist("");
            song3.setGenre("");
            song3.setDuration(0);
        }
        else if (i == 4){
            String createTitle = song4.getTitle();
            song4.setTitle("");
            song4.setArtist("");
            song4.setGenre("");
            song4.setDuration(0);
        }
    }

    //Checks if song exists and prints out song title along with number index
    public void viewAllSongs(){
        if(song1.getTitle().equals("")){
            // Prints out song title for song1
        }else{
            System.out.println("\n [1] SONG NAME: " + song1.getTitle());
        }

        if(song2.getTitle().equals("")){
            // Prints out song title for song2
        }else{
            System.out.println("\n [2] SONG NAME: " + song2.getTitle());
        }

        if(song3.getTitle().equals("")){
            // Prints out song title for song3
        }else{
            System.out.println("\n [3] SONG NAME: " + song3.getTitle());
        }
        
        if(song4.getTitle().equals("")){
            // Prints out song title for song4
        }else{
            System.out.println("\n [4] SONG NAME: " + song4.getTitle());
        }
    }

    //Checks song titles to determine how many songs have been added to the album
    public int checkNumSongs(){
        if (((song1.getTitle()).equals("")) && ((song2.getTitle()).equals("")) && ((song3.getTitle()).equals("")) && ((song4.getTitle()).equals(""))){
            return 0;
        }else if (((song1.getTitle()).equals("")) && ((song2.getTitle()).equals("")) && ((song3.getTitle()).equals(""))|| ((song3.getTitle()).equals("")) && ((song4.getTitle()).equals("")) && ((song1.getTitle()).equals(""))|| ((song2.getTitle()).equals("")) && ((song3.getTitle()).equals("")) && ((song4.getTitle()).equals(""))){
            return 1;
        }else if (((song1.getTitle()).equals("")) && ((song2.getTitle()).equals("")) || ((song2.getTitle()).equals("")) && ((song3.getTitle()).equals("")) || ((song3.getTitle()).equals("")) && ((song4.getTitle()).equals(""))|| ((song4.getTitle()).equals("")) && ((song1.getTitle()).equals(""))){
            return 2;
        }else if (((song1.getTitle()).equals("")) || ((song2.getTitle()).equals("")) || ((song3.getTitle()).equals("")) || ((song4.getTitle()).equals(""))){
            return 3;
        }else{
            return 4;
        }
    }   
    
    //Deletes album song according to int i and checks input is correct
    public void deleteAlbumSong(int i){
        if (i == 1){ 
            if(song1.getTitle().equals(null)){
               System.out.println( "Song doesn't exist..."); 
            }else{
                System.out.println( song1.getTitle() +" has been removed");
                removeSong(1);    
            }
        }else if (i == 2){
            String b = song2.getTitle();
            if(b == null){
               System.out.println( "Song doesn't exist..."); 
            }else{
                System.out.println(song2.getTitle() + " has been removed");
                removeSong(2);
            }
        }else if (i == 3){
             if(song3.getTitle().equals(null)){
               System.out.println( "Song doesn't exist..."); 
            }else{
                System.out.println( song3.getTitle() +" has been removed");
                removeSong(3);
            }
        }else if (i == 4){
             if(song4.getTitle().equals(null)){
               System.out.println( "Song doesn't exist..."); 
            }else{
                System.out.println( song4.getTitle() +" has been removed");
                removeSong(4);
            }
        }
    }

    //Displays song list and its details
    public void getSongList()
    {
        if(song1.getTitle().equals("")){
            //Display song details for song1
        }else{
            System.out.println("\n SONG NAME: " + song1.getTitle() + "\n ARTIST: " + song1.getArtist() + "\n GENRE: " + song1.getGenre() + "\n DURATION: " + song1.getDuration()+ "\n");
        }

        if(song2.getTitle().equals("")){
            //Display song details for song2
        }else{
            System.out.println("\n SONG NAME: " + song2.getTitle() + "\n ARTIST: " + song2.getArtist() + "\n GENRE: " + song2.getGenre() + "\n DURATION: " + song2.getDuration()+"\n");
        }

        if(song3.getTitle().equals("")){
            //Display song details for song3
        }else{
            System.out.println("\n SONG NAME: " + song3.getTitle() + "\n ARTIST: " + song3.getArtist() + "\n GENRE: " + song3.getGenre() + "\n DURATION: " + song3.getDuration()+"\n");
        }
        
        if(song4.getTitle().equals("")){
            //Display song details for song4
        }else{
            System.out.println("\n SONG NAME: " + song4.getTitle() + "\n ARTIST:" + song4.getArtist() + "\n GENRE: " + song4.getGenre() + "\n DURATION: " + song4.getDuration());
        }
    }
}


 
 