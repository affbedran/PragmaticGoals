package cgm;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class GoalTest {

	@Test
	public void shouldGetDependencies() {
		Refinement root = new Goal(Goal.PARALLEL_AND_DECOMPOSITION);

		Task task = new Task();
		Refinement goal = new Goal(Goal.PARALLEL_AND_DECOMPOSITION);
		Delegation delegation = new Delegation();

		root.addDependency(task);
		root.addDependency(goal);
		root.addDependency(delegation);

		HashSet<Refinement> deps = new HashSet<Refinement>();
		deps.add(delegation);
		deps.add(goal);
		deps.add(task);

		assertTrue(deps.containsAll(root.getDependencies()));
		assertTrue(root.getDependencies().containsAll(deps));
	}

	@Test
	public void shouldGetApplicableDependencies() {
		Refinement root = new Goal(Goal.PARALLEL_AND_DECOMPOSITION);

		Context context = new Context("c1");
		HashSet<Context> current = new HashSet<Context>();
		current.add(context);
		Task task = new Task();
		Refinement goal = new Goal(Goal.PARALLEL_AND_DECOMPOSITION);
		Delegation delegation = new Delegation();

		task.addApplicableContext(context);

		root.addDependency(task);
		root.addDependency(goal);
		root.addDependency(delegation);

		HashSet<Refinement> deps = new HashSet<Refinement>();
		deps.add(task);

		assertEquals(1, deps.size());
		assertTrue(deps.contains(task));
	}

	@Test
	public void shouldBeOrDecompositionOrAndDecomposition() throws Exception {
		Goal or = new Goal(Goal.OR_DECOMPOSITION);
		Goal and = new Goal(Goal.PARALLEL_AND_DECOMPOSITION);

		assertTrue(or.isOrDecomposition());
		assertFalse(or.isAndDecomposition());

		assertFalse(and.isOrDecomposition());
		assertTrue(and.isAndDecomposition());
	}

}
