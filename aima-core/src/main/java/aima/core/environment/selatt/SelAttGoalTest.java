package aima.core.environment.selatt;

import aima.core.search.framework.problem.GoalTest;

public class SelAttGoalTest implements GoalTest {

	public boolean isGoalState(Object state) {
		SelAttBoard board = (SelAttBoard) state;
		return false; //Siempre falso al no saber de antemano el mejor subconjunto
	}
}