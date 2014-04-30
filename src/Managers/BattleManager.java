
package Managers;

import EntitySystem.BattleComponent;
import EntitySystem.Entity;
import java.util.ArrayList;

public class BattleManager {

    private static BattleManager INSTANCE = new BattleManager();

    /**
     * @return the INSTANCE
     */
    public static BattleManager getINSTANCE() {
        return INSTANCE;
    }

    /**
     * @param aINSTANCE the INSTANCE to set
     */
    public static void setINSTANCE(BattleManager aINSTANCE) {
        INSTANCE = aINSTANCE;
    }
    
    private ArrayList<Entity> enemies;
    private ArrayList<Entity> friendlies;
    
    private ArrayList<Entity> turnOrder;
    
    private Entity currentCharacter;
    
    private BattleManager(){
        this.Reset(enemies, friendlies);
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

    /**
     * @return the enemies
     */
    public ArrayList<Entity> getEnemies() {
        return enemies;
    }

    /**
     * @param enemies the enemies to set
     */
    public void setEnemies(ArrayList<Entity> enemies) {
        this.enemies = enemies;
    }

    /**
     * @return the friendlies
     */
    public ArrayList<Entity> getFriendlies() {
        return friendlies;
    }

    /**
     * @param friendlies the friendlies to set
     */
    public void setFriendlies(ArrayList<Entity> friendlies) {
        this.friendlies = friendlies;
    }

    /**
     * @return the turnOrder
     */
    public ArrayList<Entity> getTurnOrder() {
        return turnOrder;
    }

    /**
     * @param turnOrder the turnOrder to set
     */
    public void setTurnOrder(ArrayList<Entity> turnOrder) {
        this.turnOrder = turnOrder;
    }

    /**
     * @return the currentCharacter
     */
    public Entity getCurrentCharacter() {
        return currentCharacter;
    }

    /**
     * @param currentCharacter the currentCharacter to set
     */
    public void setCurrentCharacter(Entity currentCharacter) {
        this.currentCharacter = currentCharacter;
    }
    
}
