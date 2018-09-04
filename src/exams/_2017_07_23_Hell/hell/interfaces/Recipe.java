package exams._2017_07_23_Hell.hell.interfaces;

import java.util.List;

/**
 * This is the interface for the Recipe entity
 * Extends the Item interface
 *
 * @method List<String> getRequiredItems() - a getter for the requiredItems property of the Recipe
 */
public interface Recipe extends Item {

    List<String> getRequiredItems();
}