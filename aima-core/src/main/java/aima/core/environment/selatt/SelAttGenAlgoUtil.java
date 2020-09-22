package aima.core.environment.selatt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import aima.core.search.framework.problem.GoalTest;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.Individual;


public class SelAttGenAlgoUtil {

	public static FitnessFunction<Integer> getFitnessFunction() {
		return new SelAttFitnessFunction();
	}
	
	public static GoalTest getGoalTest() {
		return new SelAttGenAlgoGoalTest();
	}
	

	public static Individual<Integer> generateRandomIndividual(int boardSize) {
		List<Integer> individualRepresentation = new ArrayList<Integer>();
		for (int i = 0; i < boardSize; i++) {
			individualRepresentation.add(new Random().nextInt(2));
		}
		Individual<Integer> individual = new Individual<Integer>(individualRepresentation);
		return individual;
	}

	public static Collection<Integer> getFiniteAlphabetForBoardOfSize(int size) {
		Collection<Integer> fab = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			fab.add(i);
		}

		return fab;
	}
	
	public static class SelAttFitnessFunction implements FitnessFunction<Integer> {

		public double apply(Individual<Integer> individual) {
			double fitness = 0;

			SelAttBoard board = getBoardForIndividual(individual);
			int boardSize = board.getSize();
                        
                        int [] state = board.getState();
                        int k = 0; //Numero Atributos del subconjunto
                        int [] subconjunto = new int[boardSize];
                        double rCl=0; //Guarda la suma de todas las correlaciones con la clase
                        for(int i=0;i<boardSize;i++){
                            if(state[i]==1){
                                subconjunto[k]=i;
                                rCl+=board.DATA[9][i];
                                k++;
                            }
                        }
        
                        double rAt=0; //Guarda la suma de todas las correlaciones entre los atributos
                        for(int i=0;i<k-1;i++){
                            for(int j=i+1;j<k;j++){
                                rAt+=board.DATA[subconjunto[i]][subconjunto[j]];
                            }
                        }
                        
                        double mediarAt=rAt/k;
                        double mediarCl=rCl/k;
                        
                        double CFS = (k*mediarCl)/(Math.sqrt(k+k*(k-1)*mediarAt));
			
                        fitness = CFS;
			return fitness;
		}
	}

	public static class SelAttGenAlgoGoalTest implements GoalTest {
		private final SelAttGoalTest goalTest = new SelAttGoalTest();

		@SuppressWarnings("unchecked")
		public boolean isGoalState(Object state) {
			return goalTest.isGoalState(getBoardForIndividual((Individual<Integer>) state));
		}
	}

	public static SelAttBoard getBoardForIndividual(Individual<Integer> individual) {
		int boardSize = individual.length();
		SelAttBoard board = new SelAttBoard();
		for (int i = 0; i < boardSize; i++) {
			int value = individual.getRepresentation().get(i);
			board.add(i,value);
		}

		return board;
	}
}