
package RPG;

import EntitySystem.Entity;
import Interface.Panel;

import com.thoughtworks.xstream.XStream;


import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class RPGState extends BasicGameState{
    
    Input input;
    StateBasedGame game;
    int stateID;
    ArrayList<Entity> localEntities;
    Panel currentPanel;
    
    static final int SELECT = Input.KEY_X;
    static final int BACK = Input.KEY_Z;
    static final int UP = Input.KEY_UP;
    static final int DOWN = Input.KEY_DOWN;
    static final int LEFT = Input.KEY_LEFT;
    static final int RIGHT = Input.KEY_RIGHT;
    static final int ENTER = Input.KEY_ENTER;
    static final int ESCAPE = Input.KEY_ESCAPE;
    
    @Override
    public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;
    @Override
    public abstract void update(GameContainer gc, StateBasedGame sbg, int i);
    @Override
    public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs);
        
    public abstract void abstractInit(GameContainer gc, StateBasedGame sbg) throws SlickException;
    public abstract void abstractUpdate(GameContainer gc, StateBasedGame sbg, int i);
    public abstract void abstractRender(GameContainer gc, StateBasedGame sbg, Graphics grphcs);

    /*
    @Override 
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException{
        System.out.println("STATE ENTERED");
        try {
            ObjectInputStream inputstream = xstream.createObjectInputStream(new BufferedReader(new FileReader("data/xml/user.xml")));
            try {
                user = (Entity)inputstream.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RPGState.class.getName()).log(Level.SEVERE, null, ex);
            }
            inputstream.close();
        } catch (IOException ex) {
            Logger.getLogger(RPGState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void leave(GameContainer gc, StateBasedGame sbg){
        System.out.println("STATE LEFT");
        try {
            ObjectOutputStream outputstream = xstream.createObjectOutputStream(new BufferedWriter(new FileWriter("data/xml/user.xml")));
            outputstream.writeObject(user);
            outputstream.close();
        } catch (IOException ex) {
            Logger.getLogger(RPGState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    */
    
    @Override
    public int getID(){
        return stateID;
    }
    public void setID(int id){
        stateID = id;
    }
    public void setInput(Input input){
        this.input=input;
    }

    public StateBasedGame getGame(){
        return this.game;
    }

    public void setGame(StateBasedGame game){
        this.game=game;
    }

    public ArrayList<Entity> getLocalEntities(){
        return localEntities;
    }

    public void setLocalEntities(ArrayList<Entity> entities){
        this.localEntities=entities;
    }


}
