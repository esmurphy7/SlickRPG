
package FactorySystem;

import Abilities.Ability;
import Abilities.WeaponAttack;
import EntitySystem.AbilityComponent;
import EntitySystem.Entity;
import EntitySystem.InputComponent;
import EntitySystem.ItemBearerComponent;
import EntitySystem.ItemWearerComponent;
import EntitySystem.PartyComponent;
import EntitySystem.PhysicalComponent;
import EntitySystem.StatsComponent;
import EntitySystem.VisibleComponent;
import Managers.ResourceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class UserFactory implements EntityFactory{

    private float xpos;
    private float ypos;
    private Animation sprite, up, down, left, right;
    private SpriteSheet spritesheet;
    
    public UserFactory(float x, float y){
        xpos=x;
        ypos=y;
        spritesheet = ResourceManager.getInstance().userSheet;
        int duration = 150;
        up = new Animation(spritesheet, 4, 1, 7, 1, true, duration, false);
        down = new Animation(spritesheet, 0, 0, 3, 0, true, duration, false);
        left = new Animation(spritesheet, 4, 0, 7, 0, true, duration, false);
        right = new Animation(spritesheet, 0, 1, 3, 1, true, duration, false);
        sprite=down;
    }
    
    @Override
    public Entity createEntity() {
        Entity user = new Entity(new PhysicalComponent(new Rectangle(xpos,ypos,sprite.getWidth(),sprite.getHeight())), 
                                new VisibleComponent(spritesheet,sprite,up,down,left,right), new InputComponent(), 
                                new ItemBearerComponent(), 
                                new ItemWearerComponent(), 
                                new StatsComponent());
        
        SpriteSheet weaponattacksheet = ResourceManager.getInstance().userWeaponAttackSheet;
        Animation weaponattackanim = new Animation(weaponattacksheet, 0, 0, 11, 0, true, 150, false);
        Ability weaponattack = new WeaponAttack(weaponattackanim);
        user.addComponents(new AbilityComponent(weaponattack));
        user.addComponents(new PartyComponent(user));
        
        return user;
    }

    
    
}
