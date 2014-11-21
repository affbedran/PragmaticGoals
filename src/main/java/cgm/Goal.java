package cgm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Goal extends Refinement {

	public final static int OR_DECOMPOSITION = 0;
	public final static int SERIAL_AND_DECOMPOSITION = 1;
	public final static int PARALLEL_AND_DECOMPOSITION = 2;
	
	public final static boolean OR = true;
	public final static boolean AND = false;
	protected int decompositionType;
	
	public Goal(int decompositionType) {
		super();
		dependencies = new HashSet<Refinement>();
		this.decompositionType = decompositionType;
	}
	

	@Override
	public int myType() {
		return Refinement.GOAL;
	}

	public boolean isOrDecomposition() {
		if (decompositionType==OR_DECOMPOSITION)
			return true;
		else
			return false;
	}

	public boolean isAndDecomposition() {
		return !isOrDecomposition();
	}
	
	public boolean isSerialAndDecomposition(){
		return(decompositionType==SERIAL_AND_DECOMPOSITION);
	}

	public boolean isParallelAndDecomposition(){
		return(decompositionType==PARALLEL_AND_DECOMPOSITION);
	}
	
	@Override
	public Plan isAchievable(Set<Context> current, Interpretation interp) {
		if (!this.isApplicable(current)) {
			return null;
		}

		if (isOrDecomposition()) {
			Plan plan;
			for (Refinement dep : getApplicableDependencies(current)) {
				plan = dep.isAchievable(current, interp);
				// TODO Not enough to find A suitable solution
				// need to find THE BEST solution (search all possible plans ans choose the best)
				if (plan != null) {
					return plan;
				}
			}
			return null;
		}

		if (isAndDecomposition()) {
			Plan complete, plan;
			complete = new Plan();
			//Define metric for the goal as a whole
			//Metric completeMetric = new Metric();
			for (Refinement dep : getApplicableDependencies(current)) {
				plan = dep.isAchievable(current, interp);
				if (plan != null) {
					//	planMetric = plan.getMetrics().get(completeMetric);
					//	if isSerialAndDecomposition(){
					// 		completeMetric.composeSerial(planMetric);
					//	else
					//		completeMetric.composeParallel(planMetric);
					complete.add(plan);
				} else {
					return null;
				}
			}

			// Get the quality constraints from interp for the current context
			// Set<QualityConstraint> qcs = interp.getQualityConstraints(current);
			
			// Find if any deals with the metric at hand
			// for (QualityConstraint qc : qcs) {
			// Check if it is still within acceptable boundaries
			// If it is, go on
			// If it is not, consider this goal as unachievable
			// return null;
			//}
			if (complete.getTasks().size() > 0)
				return complete;
			else
				return null;
		}
		
		
		return null;
	}

	public void parseFromYamlFile() {

	}

	// public void dumpToYamlFile(){
	// YamlHandler yaml = new YamlHandler();
	// yaml.dumpToYamlFile(this);
	//
	// }

}
