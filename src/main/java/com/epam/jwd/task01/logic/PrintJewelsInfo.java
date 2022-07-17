package com.epam.jwd.task01.logic;

import java.util.ArrayList;

/**
 * Utility class, containing only:
 * <p>a) methods for console output of {@link CreateGemstoneList} <i>GemstoneList</i> and
 * {@link CreateNecklace} <i>Necklace</i>, which both are instances of <tt>ArrayList</tt> collection and able to use
 * all relevant methods;
 * <p>b) methods for console output of {@link CalculateNecklace} methods for current <i>Necklace</i> instance.
 * <p>No instances of this class can exist, and all its fields and methods are static.
 *
 * @see CreateGemstoneList
 * @see CreateNecklace
 * @see CalculateNecklace
 */
public final class PrintJewelsInfo {

    private PrintJewelsInfo() {

    }

    /**
     * Outputs in console an instance of <i>GemstoneList</i> as {@link ArrayList#toString()}
     * @param gemstoneList an instance of <i>GemstoneList</i>, created by {@link CreateGemstoneList}
     */
    public static void printGemstoneList(CreateGemstoneList gemstoneList) {
        System.out.println(gemstoneList);
    }

    /**
     * Outputs in console an instance of <i>Necklace</i> as {@link ArrayList#toString()}
     * @param necklace an instance of <i>Necklace</i>, created by {@link CreateNecklace}
     */
    public static void printNecklace(CreateNecklace necklace) {
        System.out.println(necklace);
    }

    /**
     * Outputs in console the result of {@link CalculateNecklace#calculateNecklaceTotalCost(CreateNecklace)}
     * @param necklace an instance of <i>Necklace</i>, created by {@link CreateNecklace}
     */
    public static void printNecklaceCost(CreateNecklace necklace) {
        System.out.println("Necklace " + necklace.getNecklaceId() + " total cost is "
                + CalculateNecklace.calculateNecklaceTotalCost(necklace) + " USD.");
    }

    /**
     *  Outputs in console the result of {@link CalculateNecklace#calculateNecklaceTotalCaratWeight(CreateNecklace)}
     * @param necklace an instance of <i>Necklace</i>, created by {@link CreateNecklace}
     */
    public static void printNecklaceWeight(CreateNecklace necklace) {
        System.out.println("Necklace " + necklace.getNecklaceId() + " total gemstones weight is "
                + CalculateNecklace.calculateNecklaceTotalCaratWeight(necklace) + " CARAT.");
    }
}
