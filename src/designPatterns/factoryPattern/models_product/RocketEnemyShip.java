package designPatterns.factoryPattern.models_product;

import designPatterns.factoryPattern.models_product.EnemyShip;

public class RocketEnemyShip extends EnemyShip {

    public RocketEnemyShip() {
        setName("Rocket Enemy Ship");

        setDamage(10.0);
    }
}
