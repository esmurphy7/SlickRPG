
package Managers;

import EntitySystem.BattleComponent;
import EntitySystem.Entity;
import java.util.ArrayList;

public class BattleManager {

    private static BattleManager INSTANCE = new BattleManager();

    private ArrayList<Entity> enemies;
    private ArrayList<Entity> friendlies;
    
    private ArrayList<Entity> turnOrder;
    
    private Entity currentCharacter;
    
    private BattleManager(){
        this.Reset(enemies, friendlies);
    }
    
    public static BattleManager getInstance() {
        return INSTANCE;
    }
    
    public void Reset(ArrayList<Entity> enemies, ArrayList<Entity> friendlies){
        this.setEnemies(enemies);
        this.setFriendlies(friendlies);
        this.setTurnOrder((ArrayList<Entity>) new ArrayList());
    }
    
    public void update(){
        setTurnOrder();
        
    }
    
    private void setTurnOrder(){
        
    }
    
    public void Attack(Entity target){
        BattleComponent bc = getCurrentCharacter().getComponent(BattleComponent.class);
        if(target.hasComponents(BattleComponent.class)){
            bc.Attack(getCurrentCharacter(), target);
        }
    }

    
    public ArrayList<Entity> getEnemies() {
        return enemies;
    }
    public void setEnemies(ArrayList<Entity> enemies) {
        this.enemies = enemies;
    }
    public ArrayList<Entity> getFriendlies() {
        return friendlies;
    }
    public void setFriendlies(ArrayList<Entity> friendlies) {
        this.friendlies = friendlies;
    }
    public ArrayList<Entity> getTurnOrder() {
        return turnOrder;
    }
    public void setTurnOrder(ArrayList<Entity> turnOrder) {
        this.turnOrder = turnOrder;
    }
    public Entity getCurrentCharacter() {
        return currentCharacter;
    }
    public void setCurrentCharacter(Entity currentCharacter) {
        this.currentCharacter = currentCharacter;
    }
    
}
