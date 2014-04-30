
package EntitySystem;

public class BattleComponent extends EntityComponent{

    private static final float INITIAL_MISSCHANCE = 0.1f;
    
    /* Exectue attack command between attacker and target entities 
     * Called by BattleManager, which is called by TargetOverlay
     */
    public void Attack(Entity attacker, Entity target){
        /* Determine miss chance then "roll the dice"
         * Play weapon attack animation
         * Compute damage to be dealt then inflict damage
         */
        StatsComponent attackerSC = attacker.getComponent(StatsComponent.class);
        StatsComponent targetSC = attacker.getComponent(StatsComponent.class);
        
        float missChance = INITIAL_MISSCHANCE;
        float ratio = attackerSC.getDex()/targetSC.getDex();
        float effectiveValue = 0.1f*(ratio-1);
        if(ratio >= 0){
            missChance = missChance - effectiveValue;
        } else {
            missChance = missChance + effectiveValue;
        }
        if(missChance > 0.9){
                missChance = 0.9f;
        }
        if(missChance < 0){
                missChance = 0;
        }
        
        boolean hasMissed = false;
        float roll = (float)Math.random();
        if(roll <= missChance){
            hasMissed = true;
        }
    }
    
}
