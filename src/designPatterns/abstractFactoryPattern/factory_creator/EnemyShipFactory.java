package designPatterns.abstractFactoryPattern.factory_creator;

// With an Abstract Factory Pattern you won't
// just build ships, but also all of the components
// for the ships

// Here is where you define the parts that are required
// if an object wants to be an enemy ship

import designPatterns.abstractFactoryPattern.models_product.ESEngine;
import designPatterns.abstractFactoryPattern.models_product.ESWeapon;

public interface EnemyShipFactory {

    ESWeapon addESGun();

    ESEngine addESEngine();
}
