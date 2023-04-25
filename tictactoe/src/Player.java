public class Player {
    private static int count = 0;
    private int id;
    private int wins;
    private String name;
    public Player(String name){
        this.id = ++count;
        this.name = name;
        this.wins = 0;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void incWins(){
        this.wins += 1;
    }
    public int getWins(){
        return this.wins;
    }
}
