/*Trabajo Búsqueda Local*/

/**
 *
 * @author José_Manuel_Fernández_Labrador
 */

package aima.gui.demo.search;

import aima.core.environment.selatt.GeneticAlgorithmSelAtt;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


import aima.core.environment.selatt.SelAttGenAlgoUtil;
import aima.core.search.framework.problem.GoalTest;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.Individual;


public class SelAttDemo {

	private static final int boardSize = 9;

	public static void main(String[] args) {
		newSelAttDemo();
	}

	private static void newSelAttDemo() {

		selAttGeneticAlgorithmSearch();
	}

	

	public static void selAttGeneticAlgorithmSearch() {
		System.out.println("\nSelAtt GeneticAlgorithmSearch  -->");
		try {
			FitnessFunction<Integer> fitnessFunction = SelAttGenAlgoUtil.getFitnessFunction();
			GoalTest goalTest = SelAttGenAlgoUtil.getGoalTest();
			// Generate an initial population
                        
                        //PopulationSize=50,MutateProb=0.15,Time=1000L:
			Set<Individual<Integer>> population = new HashSet<Individual<Integer>>();
			for (int i = 0; i < 50; i++) {
				population.add(SelAttGenAlgoUtil.generateRandomIndividual(boardSize));
			}

			GeneticAlgorithmSelAtt<Integer> ga = new GeneticAlgorithmSelAtt<Integer>(boardSize,
					SelAttGenAlgoUtil.getFiniteAlphabetForBoardOfSize(boardSize), 0.15);

			Individual<Integer> bestIndividual = ga.geneticAlgorithm(population, fitnessFunction, goalTest, 1000L);

			System.out.println("\nPopulationSize=50,MutateProb=0.15,Time=1000L:\n"
					+ SelAttGenAlgoUtil.getBoardForIndividual(bestIndividual));
			System.out.println("Board Size      = " + boardSize);
			System.out.println("# Board Layouts = " + (new BigDecimal(boardSize)).pow(boardSize));
			System.out.println("Fitness         = " + fitnessFunction.apply(bestIndividual));
			System.out.println("Is Goal         = " + goalTest.isGoalState(bestIndividual));
			System.out.println("Population Size = " + ga.getPopulationSize());
			System.out.println("Itertions       = " + ga.getIterations());
			System.out.println("Took            = " + ga.getTimeInMilliseconds() + "ms.");
                        
                        //PopulationSize=10,MutateProb=0.001,Time=200L:
                        population = new HashSet<Individual<Integer>>();
			for (int i = 0; i < 10; i++) {
				population.add(SelAttGenAlgoUtil.generateRandomIndividual(boardSize));
			}

			ga = new GeneticAlgorithmSelAtt<Integer>(boardSize,
					SelAttGenAlgoUtil.getFiniteAlphabetForBoardOfSize(boardSize), 0.001);

			bestIndividual = ga.geneticAlgorithm(population, fitnessFunction, goalTest, 200L);

			System.out.println("\nPopulationSize=10,MutateProb=0.001,Time=200L:\n"
					+ SelAttGenAlgoUtil.getBoardForIndividual(bestIndividual));
			System.out.println("Board Size      = " + boardSize);
			System.out.println("# Board Layouts = " + (new BigDecimal(boardSize)).pow(boardSize));
			System.out.println("Fitness         = " + fitnessFunction.apply(bestIndividual));
			System.out.println("Is Goal         = " + goalTest.isGoalState(bestIndividual));
			System.out.println("Population Size = " + ga.getPopulationSize());
			System.out.println("Itertions       = " + ga.getIterations());
			System.out.println("Took            = " + ga.getTimeInMilliseconds() + "ms.");

			//PopulationSize=500,MutateProb=0.3,Time=80L:
                        population = new HashSet<Individual<Integer>>();
			for (int i = 0; i < 500; i++) {
				population.add(SelAttGenAlgoUtil.generateRandomIndividual(boardSize));
			}

			ga = new GeneticAlgorithmSelAtt<Integer>(boardSize,
					SelAttGenAlgoUtil.getFiniteAlphabetForBoardOfSize(boardSize), 0.3);

			bestIndividual = ga.geneticAlgorithm(population, fitnessFunction, goalTest, 80L);

			System.out.println("\nPopulationSize=500,MutateProb=0.3,Time=80L:\n"
					+ SelAttGenAlgoUtil.getBoardForIndividual(bestIndividual));
			System.out.println("Board Size      = " + boardSize);
			System.out.println("# Board Layouts = " + (new BigDecimal(boardSize)).pow(boardSize));
			System.out.println("Fitness         = " + fitnessFunction.apply(bestIndividual));
			System.out.println("Is Goal         = " + goalTest.isGoalState(bestIndividual));
			System.out.println("Population Size = " + ga.getPopulationSize());
			System.out.println("Itertions       = " + ga.getIterations());
			System.out.println("Took            = " + ga.getTimeInMilliseconds() + "ms.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}