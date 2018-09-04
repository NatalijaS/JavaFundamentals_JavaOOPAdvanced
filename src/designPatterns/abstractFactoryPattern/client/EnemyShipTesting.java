package designPatterns.abstractFactoryPattern.client;

import designPatterns.abstractFactoryPattern.factory_creator.UFOEnemyShipBuilding;
import designPatterns.abstractFactoryPattern.factory_creator.EnemyShipBuilding;
import designPatterns.abstractFactoryPattern.models_product.EnemyShip;

public class EnemyShipTesting {

    public static void main(String[] args) {

        // EnemyShipBuilding handles orders for new EnemyShips
        // You send it a code using the orderTheShip method &
        // it sends the order to the right factory_creator for creation

        EnemyShipBuilding MakeUFOs = new UFOEnemyShipBuilding();

        EnemyShip theGrunt = MakeUFOs.orderTheShip("UFO");
        System.out.println(theGrunt + "\n");

        EnemyShip theBoss = MakeUFOs.orderTheShip("UFO BOSS");
        System.out.println(theBoss + "\n");

    }
}
