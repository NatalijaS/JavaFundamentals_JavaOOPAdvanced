package designPatterns.abstractFactoryPattern.factory_creator;

// This factory_creator uses the EnemyShipFactory interface
// to create very specific UFO Enemy Ship

// This is where we define all of the parts the ship
// will use by defining the methods implemented
// being ESWeapon and ESEngine

// The returned object specifies a specific weapon & engine

import designPatterns.abstractFactoryPattern.models_product.ESUFOEngine;
import designPatterns.abstractFactoryPattern.models_product.ESUFOGun;
import designPatterns.abstractFactoryPattern.models_product.ESEngine;
import designPatterns.abstractFactoryPattern.models_product.ESWeapon;

public class UFOEnemyShipFactory implements EnemyShipFactory {

    // Defines the weapon object to associate with the ship

    public ESWeapon addESGun() {
        return new ESUFOGun(); // Specific to regular UFO
    }

    // Defines the engine object to associate with the ship

    public ESEngine addESEngine() {
        return new ESUFOEngine(); // Specific to regular UFO
    }
}
