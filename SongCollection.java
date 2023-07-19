/**VERSION 1
 * Description: This is a Music Collection program which allows users to create an album and
 * add new songs with details such as artist name, title, genre, and song duration.
 * This program also allows the user to add or delete songs and albums.
 * The user can only create 3 albums and each album can only have upto 4 songs.
 * Author: Liz Tulio & Charlene Eriguel
 * Student Number: C3250794 - C3383599
 * Created: 23 Mar 2023
 * Modified: 27/4/23 
 * Submitted: 28/4/23
 **/
import java.util.*;
    
public class SongCollection
{   
        // Instance variables
        private Album album1, album2, album3;
        private Song song, song1, song2, song3, song4;
        Album a = new Album(); //creates an object of the album class
        int option;
        Scanner console = new Scanner(System.in); 
        
        
        public void run() // Controls the flow of program
        {        
            //Displays main menu containing program functionalities 
            do
                {
                System.out.println("\n          ﾟ ♬˚₊ ♪｡⋆♫ Select and enter ♫⋆｡♪ ₊˚♬ ﾟ\n");
                System.out.println("1 - Create Album");
                System.out.println("2 - Enter a new song into an album");
                System.out.println("3 - Show all songs from an album ");
                System.out.println("4 - Show all albums ");
                System.out.println("5 - Show songs using duration ");
                System.out.println("6 - Show songs using genre");
                System.out.println("7 - Delete an album");
                System.out.println("8 - Delete a song from an album ");
                System.out.println("0 - Exit");
                //Displays error message when user enters invalid input
                while(console.hasNextInt() != true){
                    System.out.println("\n Note: Please enter a menu number only... ");
                    console.next(); 
                    backToMenu();
                }
                option = console.nextInt();
            
                //Calls the appropriate method based on user selection 
                switch(option)
                {   
                    case 1: addAlbum();
                    break;
                    case 2: addSongToAlbum(); 
                    break;
                    case 3: viewSongList();
                    break;
                    case 4: printAlbum();
                    break;
                    case 5: searchDuration();
                    break;
                    case 6: searchGenre();
                    break;
                    case 7: deleteAlbum();
                    break;
                    case 8: deleteSong();          
                    break;
                    case 0: break;
                    default: System.out.println("Invalid Selection"); 
                    backToMenu();
                    return;
                }
                    break;
                }
            while (option!=0);
        }
        
        //This method allows user to create new album
        public void addAlbum()
        {
                    Scanner console = new Scanner(System.in);
                    int end;
                    Album a = new Album();
                    
                    System.out.print("          ﾟ ♬˚₊ ♪｡⋆♫ Enter Album name: ♫⋆｡♪ ₊˚♬ ﾟ\n");
                    String name = console.nextLine();
                    
                    //Checks if album already exists
                    if (album1 != null && album1.getName().equals(name))
                    {
                     System.out.println("The album already exists. Please try again");
                     backToMenu();
                     return;
                    }
                    
                    if (album2 != null && album2.getName().equals(name))
                    {
                     System.out.println("The album already exists. Please try again");
                     backToMenu();
                     return;
                    }
                    
                    if (album3 != null && album3.getName().equals(name))
                    {
                     System.out.println("The album already exists. Please try again");
                     backToMenu();
                     return;
                    }
                    
                    a.setName(name);
                    
                    //Prevents user from entering a new album if maximum number of album has been reached
                    if (album1 == null){
                        album1 = a;
                    }
                    else if (album2 == null){
                        album2 = a;
                    }
                    else if (album3 == null){
                        album3 = a;
                    }else{
                        System.out.println("\n You can't create new album: Max limit reached\n");
                        backToMenu();
                        return;
                    }      
                    
                    System.out.println("Album: " + a.getName() + " has been added \n");
                        backToMenu();
                        return;
               
        }
        
        //backToMenu method asks the user if they want to go back to menu or continue
        public void backToMenu()
        {
            System.out.println("\n          ﾟ ♬˚₊ ♪｡⋆♫♫⋆｡♪ ₊˚♬ﾟ♬˚₊ ♪｡⋆♫♫⋆｡♪ ₊˚♬ ﾟ\n");
            run();
        }
        
        //This method allows user to add song into an album
        public void addSongToAlbum()
        {
                //checks if there are any existing albums
                if(checkallAlbum())
                {
                    System.out.println("**********************************");
                    System.out.println("**    Create an album first     **");
                    System.out.println("**********************************");
                    System.out.println("\n");
                    backToMenu();
                    return;
                }
                //if there is an album, proceed to add song
                else {                 
                    addSong(); //calls the method to add song
                }
        }
        
        //This method allows user to enter song and its details: title, artist, genre, duration 
        public void addSong()
        {
                Scanner console = new Scanner(System.in);
                Album a = new Album();
                String title = "";
                String artist = "";
                String genre = "";
                double duration = 0;
                double totalTime= 1200; //maximum duration in album
                int albumNum, end;

                System.out.print("\n          ﾟ ♬˚₊ ♪｡⋆♫ Enter song title:  ♫⋆｡♪ ₊˚♬ ﾟ \n");
                title = console.nextLine();
                
                //Checks if song already exists in an album
                if (album1 != null && album1.checkSongExists(title)) {
                    System.out.println("Song cannot be added due to existing record in album " + album1.getName());
                    backToMenu();
                    return;   
                } else if (album2 != null && album2.checkSongExists(title)) {
                    System.out.println("Song cannot be added due to existing record in album " + album2.getName());
                    backToMenu();
                    return;   
                } else if (album3 != null && album3.checkSongExists(title)) {
                    System.out.println("Song cannot be added due to existing record in album " + album3.getName());
                    backToMenu();
                    return;   
                } 
                
                System.out.print("\n          ﾟ ♬˚₊ ♪｡⋆♫ Enter artist name:  ♫⋆｡♪ ₊˚♬ ﾟ \n");
                artist = console.nextLine();
                
                System.out.print("\n          ﾟ ♬˚₊ ♪｡⋆♫ Enter song genre:  ♫⋆｡♪ ₊˚♬ ﾟ \n");
                System.out.print("\n         Type: Rock | Pop | Hip-hop | Bossa nova   \n");
                genre = console.nextLine();
                //Prints an error message when user enters wrong genre 
                if (!genre.equals("Rock") && !genre.equals("Pop") && !genre.equals("Hip-hop") && !genre.equals("Bossa nova")) {
                    System.out.println(" \n Invalid genre.\n Only choose the Type given ");
                    System.out.print("\n          ﾟ ♬˚₊ ♪｡⋆♫ Enter the exact song genre selection:  ♫⋆｡♪ ₊˚♬ ﾟ \n");
                    genre = console.nextLine();
                    
                }

                System.out.print("\n          ﾟ ♬˚₊ ♪｡⋆♫ Enter song duration in seconds:  ♫⋆｡♪ ₊˚♬ ﾟ \n");
                //Prints an error message whenuser enters invalid input 
                while(console.hasNextInt() != true){
                    System.out.println("\n Note: Please enter the number of seconds only... ");
                    console.next(); 
                }
                
                duration = console.nextDouble();
                
                //Prints an error message if new song reached max duration
                if (duration > totalTime){
                    System.out.println("\n Can't add song. Duration is over the limit \n");
                }
                else {
                System.out.println("----------------------------");
                System.out.println("\n Which album would you like to add the song? \n"); //Allows user to select an album to add song 
                
                //Displays list of albums 
                if(album1 == null){
                    System.out.println("1: No album created");
                }else{
                    System.out.println("1: " + album1.getName());
                }
                
                if(album2 == null){
                    System.out.println("2: No album created");
                }else{
                    System.out.println("2: " + album2.getName());
                }
                
                if(album3 == null){
                    System.out.println("3: No album created");
                }else{
                    System.out.println("3: " + album3.getName());
                }
            
                System.out.println("\n          ﾟ ♬˚₊ ♪｡⋆♫ Enter selection;  ♫⋆｡♪ ₊˚♬ ﾟ \n");
                //Prints message if user did not enter selection number only and allows user to return to main menu
                while(console.hasNextInt() != true){
                    System.out.println("\n Note: Please enter the selection number only... ");
                    System.out.println("Type 9 to return to main menu \n");
                    console.next(); // consume the invalid input
                }
                albumNum = console.nextInt();
                
                //Checks if selected album exists 
                if(albumNum == 1){
                    
                     if(album1 == null){
                         System.out.println("Create album first!");
                     }else{
                    album1.addSong(title, artist, genre, duration);
                }

                }else if(albumNum == 2){
                     if(album2 == null){
                         System.out.println("Create album first!");
                     }else{
                    album2.addSong(title, artist, genre, duration);
                }

                }else if(albumNum == 3){
                   if(album3 == null){
                     System.out.println("Create album first!");
                   }else{
                    album3.addSong(title, artist, genre, duration);
                } 
                }
                }

                backToMenu();
                return;
        }
                
        //Allows user to request a list of all songs (and the details of each song) from an album.
        public void viewSongList()
        {
            int albumNum; //variable for selecting album number
            
            System.out.println("\n          ﾟ ♬˚₊ ♪｡⋆♫ Select album  ♫⋆｡♪ ₊˚♬ ﾟ \n");
            
            //Checks if album exists and displays an error message if not        
            if (album1 == null){
                System.out.println("1. No album created");
                }
                else{
                System.out.println("1. " + album1.getName());
            }
                    
            if(album2 == null){
                    System.out.println("2. No album created");
                    }
            else{
                    System.out.println("2: " + album2.getName());
                    }
                    
            if(album3 == null){
                    System.out.println("3. No album created");
                   }
            else{
                    System.out.println("3: " + album3.getName());
                   }
            
            //Checks if user entered valid album number           
            while(console.hasNextInt() != true){
                    System.out.println("\n Note: Please enter the album number only... ");
                    System.out.println("\n Type 9 to return to main menu \n");
                    console.next(); // consume the invalid input
            }
                albumNum = console.nextInt();
            
            //If album exists, program prints song list from selected album 
            if(albumNum == 1){
                    System.out.println("Album " + album1.getName() + " contains:");
                    album1.getSongList();
    
                    }else if(albumNum == 2){
                        System.out.println("Album " + album2.getName() + " contains:");
                        album2.getSongList();
                    }else if(albumNum == 3){
                        System.out.println("Album " + album3.getName() + " contains:");
                        album3.getSongList();
            }        
            backToMenu();
        }
                
        //This method prints list of all albums
        public void printAlbum()
        {
                System.out.println("\n          ﾟ ♬˚₊ ♪｡⋆♫ Here's a list of all albums  ♫⋆｡♪ ₊˚♬ ﾟ \n");
                
                //Checks if album exists and prints error message if not
                //Displays list of songs if album exists
                if(album1 == null){
                    System.out.println("Album 1 does not exist yet...");
                    }else{
                    System.out.println(album1.getName()); 
                    album1.getSongList();  
                    } 
                
                if(album2 == null){
                    System.out.println("Album 2 does not exist yet...");
                    }else{
                    System.out.println(album2.getName()); 
                    album2.getSongList(); 
                    } 
                
                if(album3 == null){
                    System.out.println("Album 3 does not exist yet...");
                    }else{
                    System.out.println(album3.getName()); 
                    album3.getSongList();
                    } 
                
                backToMenu();
                return;
                
        }
    
        //This method allows user to search a song within certain duration
        public void searchDuration()
        {
            double minutes;
            
            System.out.println("\n          ﾟ ♬˚₊ ♪｡⋆♫ What is the song duration in seconds?  ♫⋆｡♪ ₊˚♬ ﾟ \n");
            
                //Consumes invalid input
                while(console.hasNextInt() != true){
                    System.out.println("\n Note: Please enter the number of seconds only... \n");
                    console.next(); 
                }
        
            minutes = console.nextDouble();
    
            System.out.println("\n Here is a list of all songs that are under the duration of: " + minutes + " seconds \n"); 
            
                //Checks if album exists and if so it will print album name and any song within certain duration 
                if(album1 == null){
                    System.out.println("\n ALBUM 1 is not available");
                }else{
                    System.out.println("\n ALBUM: " + album1.getName());
                    album1.searchDuration(minutes);
                }
                    
                if(album2 == null){
                    System.out.println("\n ALBUM 2 is not available");
                   }else{
                    System.out.println("\n ALBUM: " + album2.getName());
                    album2.searchDuration(minutes);
                }
                    
                if(album3 == null){
                    System.out.println("\n ALBUM 3 is not available");
                    }else{
                    System.out.println("\n ALBUM " + album3.getName());
                    album3.searchDuration(minutes);
                }
                backToMenu();
        }
    
        //This method allows user to search genre and prints list of all songs in the genre
        public void searchGenre()
        {
            Scanner console = new Scanner(System.in);
            String genreSearched;  
            
            System.out.println("\n          ﾟ ♬˚₊ ♪｡⋆♫ What is the genre?  ♫⋆｡♪ ₊˚♬ ﾟ \n");
            genreSearched = console.nextLine();
            
                //Checks if user entered correct genre name
                if (!genreSearched.equals("Rock") && !genreSearched.equals("Pop") && !genreSearched.equals("Hip-hop") && !genreSearched.equals("Bossa nova")) {
                    System.out.println(" \n Invalid genre.\n The accepted genres are: \n Rock \n Pop \n Hip-hop \n Bossa nova \n ");
                    searchGenre();
                    return;
                }
            
            System.out.println("\n Here is a list of all songs that are in the genre " + genreSearched + " : \n"); 
            
                //Checks if album exists and if so, lists all songs under chosen genre
                if(album1 == null){
                    System.out.println("\n ALBUM 1 is not available");
                }else{
                    System.out.println("\n ALBUM: " + album1.getName());
                    album1.searchGenre(genreSearched);
                }
                    
                if(album2 == null){
                    System.out.println("\n ALBUM 2 is not available");
                }else{
                    System.out.println("\n ALBUM: " + album2.getName());
                    album2.searchGenre(genreSearched);
                }
                    
                if(album3 == null){
                    System.out.println("\n ALBUM 3 is not available");
                }else{
                    System.out.println("\n ALBUM " + album3.getName());
                    album3.searchGenre(genreSearched);
                }
                backToMenu(); 
                return;
        }
        
        //Allows user to delete an existing album
        public void deleteAlbum()
        {
            System.out.println("\n List of current albums: \n");
                //Checks if albums exists and displays album name if yes
                if (album1 == null){
                    System.out.println("There is no album created for Album 1");
                    }
                    else  {
                    System.out.println("[1] " + album1.getName()); 
                }
                       
                if (album2 == null)
                {
                    System.out.println(" There is no album created for Album 2");
                }
                   else {
                        System.out.println("[2] " + album2.getName());
                }
                        
                if (album3 == null)
                {
                    System.out.println("There is no album created for Album 3");  
                }
                else {
                        System.out.println("[3] " + album3.getName());  
                } 
                 
            System.out.println("\nﾟ ♬˚₊ ♪｡⋆♫♫⋆｡♪ ₊˚♬ ﾟ\n");         
            System.out.println("\n Which album would you like to delete? : \n");
                
                //Checks if user input is correct
                while(console.hasNextInt() != true){
                    System.out.println("\n Note: Please enter the album number only... \n");
                    console.next(); 
                }
                int option = console.nextInt();
    
                    //Deletes album after removing all songs
                    if (option == 1 && album1 != null){
                        album1.setName("");
                        album1.removeSong(1);
                        album1.removeSong(2);
                        album1.removeSong(3);
                        album1.removeSong(4);
                        album1 = null;
                        System.out.println("\n Album 1 has been removed! \n");
                    }else if (option == 2 && album2 != null){
                        album2.setName("");
                        album2.removeSong(1);
                        album2.removeSong(2);
                        album2.removeSong(3);
                        album2.removeSong(4);
                        album2 = null;
                        System.out.println("\n Album 2 has been removed! \n");
                    }else if (option == 3 && album3 != null){
                        album3.setName("");
                        album3.removeSong(1);
                        album3.removeSong(2);
                        album3.removeSong(3);
                        album3.removeSong(4);
                        album3 = null;
                        System.out.println("\n Album 3 has been removed! \n");
                    }else {
                        System.out.println("\n Error: This album could not be found");
                        backToMenu();   
                    }
                    backToMenu();
                        return;
        }

        //This method deletes song from a selected album
        public void deleteSong()
        {
            //Checks if there is any existing albums and if so, prints album names
            if(checkallAlbum()){
                 System.out.println("There are no albums! Please create one.");
                 backToMenu();
            }
               
            if (album1 == null){
                 System.out.println("\n There is no Album 1");
            }else{ 
                 System.out.println("[1] " + album1.getName()); 
            }
                       
            if (album2 == null){
                System.out.println("\n There is no Album 2");
            }else {
                System.out.println("[2] " + album2.getName());
            }
                        
            if (album3 == null){
                 System.out.println("There is no Album 3");
            }else {
                 System.out.println("[3] " + album3.getName());  
            } 
                 
            System.out.println("\n ﾟ ♬˚₊ ♪｡⋆♫♫⋆｡♪ ₊˚♬ ﾟ\n ");
           
            System.out.println("\n Select Album to remove songs ");
            System.out.println("\n Enter [9] to return to main menu \n");
             
                //Checks if user input is valid
                while(console.hasNextInt() != true){
                    System.out.println("\n Note: Please enter the album number only... ");
                    
                    System.out.println("\n Enter [9] to return to main menu \n");
                        console.next(); 
                }
                
                int option = console.nextInt();
    
                //Checks if an album has any songs
                //
                if (option == 1 && album1 != null){
                    if (album1.checkNumSongs() == 0){ 
                         System.out.println("\n This album does not currently contain any songs \n"); 
                         backToMenu();
                    }else { 
                          System.out.println("\n The current songs are as follows: \n");
                          album1.viewAllSongs();
                          System.out.println("\n Which songs would you like to remove? \n");
                          
                          //Checks if user input is valid
                          while(console.hasNextInt() != true){
                              System.out.println("\n Note: Please enter the song number only... ");
                              System.out.println("\n Type 9 to return to main menu \n");
                              console.next(); 
                          }
                          
                          int select = console.nextInt();
                          //Deletes an album song depending on user selection      
                          if (select == 1){
                              album1.deleteAlbumSong(1);
                              backToMenu();
                              return;
                          }else if (select == 2){
                              album1.deleteAlbumSong(2);
                              backToMenu();
                              return;
                          }else if (select == 3){
                              album1.deleteAlbumSong(3);
                              backToMenu();
                              return;
                          }else if (select==4){
                              album1.deleteAlbumSong(4);
                              backToMenu();
                              return;
                          }else {
                              System.out.println("Ooops! Song could not be found");
                          }
                    }
                }else if (option == 2 && album2 != null){
                    if (album2.checkNumSongs() == 0){ 
                         System.out.println("\n This album does not currently contain any songs \n"); 
                         backToMenu();
                    } else{
                         System.out.println("\n The current songs are as follows: \n");
                         album2.viewAllSongs();
                        
                         System.out.println("\n Which songs would you like to remove? \n");
                        
                          //Checks if user input is valid  
                          while(console.hasNextInt() != true){
                              System.out.println("\n Note: Please enter the song number only... ");
                              System.out.println("Type 9 to return to main menu \n");
                                    console.next(); // consume the invalid input
                          }
                          
                          int select = console.nextInt();
                            //Deletes song based on user selection        
                            if (select==1){
                                album2.deleteAlbumSong(1);
                                backToMenu();
                                return;
                            }else if (select==2){
                                album2.deleteAlbumSong(2);
                                backToMenu();
                                return;
                            }else if (select==3){
                                album2.deleteAlbumSong(3);
                                backToMenu();
                                return;
                            }else if (select==4){
                                album2.deleteAlbumSong(4);
                                backToMenu();
                                return;
                            }else {
                                System.out.println("Ooops! Song could not be found");
                            }
                    }   
                }else if (option == 3 && album3 != null){
                    if (album3.checkNumSongs() == 0){ 
                         System.out.println("\n This album does not currently contain any songs \n"); 
                         backToMenu();
                    } else {
                        System.out.println("\n The current songs are as follows: \n");
                        album3.viewAllSongs();
                        System.out.println("\n Which songs would you like to remove? \n");
                            //Checks if user input is valid
                            while(console.hasNextInt() != true){
                              System.out.println("\n Note: Please enter the song number only... ");
                              System.out.println("\n Type 9 to return to main menu \n");
                              console.next(); 
                            }
                            
                            int select = console.nextInt();
                            
                            //Deletes song according to user selection
                            if (select==1){
                                        album3.deleteAlbumSong(1);
                                        backToMenu();
                                        return;
                            }else if (select==2){
                                        album3.deleteAlbumSong(2);
                                        backToMenu();
                                        return;
                            }else if (select==3){
                                       album3.deleteAlbumSong(3);
                                        backToMenu();
                                        return;
                            }else if (select==4){
                                       album3.deleteAlbumSong(4);
                                        backToMenu();
                                        return;
                            }else {
                                        System.out.println("Ooops! Song could not be found");
                            }
                    }
                }else {
                    System.out.println("Error: This album could not be found"); //Displays error message if album cannot be found
                    backToMenu();
                    return;
                }
        }
                
        //Checks if albums have been created and if so, displays album name
        public void checkAlbum()
        {
                if (album1 == null){
                    System.out.println("\n There is no album created for Album 1");
                }else {
                        
                        System.out.println("[1] " + album1.getName()); 
                }
                if (album2 == null){
                    System.out.println("\n There is no album created for Album 2");
                }
                else {
                        System.out.println("[2] " + album2.getName());
                }
                if (album3 == null){
                    System.out.println("\n There is no album created for Album 3");
                }
        }
        
        //Checks if albums are null
        public boolean checkallAlbum(){
            if (album3 == null && album2 == null && album1 == null ){
                return true;
            }else {
                return false;
            }
        }
        
        //Runs the program
        public static void main(String[] args) 
        {
            Scanner console = new Scanner(System.in);
            
            SongCollection sg = new SongCollection();
            sg.run();
                
        
        }
}

